from __future__ import print_function
import base64
import os
import hashlib
import struct

# This is the password we wish to encode
password = 'users_payments'

# 1.Generate a random 32 bit salt:
# This will generate 32 bits of random data:
salt = os.urandom(4)

# 2.Concatenate that with the UTF-8 representation of the password (in this case "simon")
tmp0 = salt + password.encode('utf-8')

# 3. Take the SHA256 hash and get the bytes back
tmp1 = hashlib.sha256(tmp0).digest()

# 4. Concatenate the salt again:
salted_hash = salt + tmp1

# 5. convert to base64 encoding:
pass_hash = base64.b64encode(salted_hash)

print(pass_hash.decode('UTF-8'))