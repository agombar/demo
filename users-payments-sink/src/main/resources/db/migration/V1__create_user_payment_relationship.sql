-- Enable the extension for UUID generation in PostgreSQL
CREATE EXTENSION IF NOT EXISTS "uuid-ossp";

-- Create table `users`
CREATE TABLE IF NOT EXISTS users (
    id UUID PRIMARY KEY,
    username VARCHAR(50) NOT NULL,
    email VARCHAR(100) UNIQUE NOT NULL,
    created_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP DEFAULT CURRENT_TIMESTAMP
);

-- Create table `payments`
CREATE TABLE IF NOT EXISTS payments (
    id UUID PRIMARY KEY,
    amount DECIMAL(10, 2) NOT NULL,
    payment_date TIMESTAMP DEFAULT CURRENT_TIMESTAMP,
    user_id UUID NOT NULL,  -- UUID foreign key to users table
    -- Foreign key constraint linking payment to user
    CONSTRAINT fk_user
    FOREIGN KEY (user_id)
    REFERENCES users(id)
    ON DELETE CASCADE
);

-- Create index on `user_id` in `payments` table for faster querying
CREATE INDEX idx_payments_user_id ON payments(user_id);
