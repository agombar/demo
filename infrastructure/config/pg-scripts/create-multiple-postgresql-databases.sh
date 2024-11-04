function create_user_and_database() {
	local database=$( echo $1 | cut -d '|' -f 1 )
  local user=$( echo $1 | cut -d '|' -f 2 )
  local extensions=$( echo $1 | cut -d '|' -f 3 )
	echo "Creating database '$database' for - '$user' with pass '$user' -"
	psql -v ON_ERROR_STOP=1 --username "$POSTGRES_USER" <<-EOSQL
	    CREATE ROLE $user WITH NOSUPERUSER CREATEDB CREATEROLE INHERIT LOGIN NOREPLICATION NOBYPASSRLS PASSWORD '$user';

	    CREATE DATABASE $database;
	    GRANT ALL PRIVILEGES ON DATABASE $database TO $user;

EOSQL

for extension in $( echo ${extensions} | tr ';' ' ' ); do
	echo "Creating extension '${extension}' for database '${database}'"
	echo -n "CREATE EXTENSION IF NOT EXISTS \"${extension}\" SCHEMA public;" | psql -v ON_ERROR_STOP=1 --username "services" -d "${database}" --no-password
done

}

if [ -n "$POSTGRES_MULTIPLE_DATABASES" ]; then
	echo "Multiple database creation requested: $POSTGRES_MULTIPLE_DATABASES"
	for dbusr in $(echo $POSTGRES_MULTIPLE_DATABASES | tr ',' ' '); do
		create_user_and_database $dbusr
	done
	echo "Multiple databases created"
fi