CREATE DATABASE contact_management;

USE contact_management;

CREATE TABLE users
(
  username VARCHAR(100) NOT NULL,
  password VARCHAR(100) NOT NULL,
  name VARCHAR(100) NOT NULL,
  token VARCHAR(100),
  token_expired_at BIGINT,
  PRIMARY KEY (username),
  UNIQUE (token)
);

CREATE TABLE contacts
(
  id INT NOT NULL,
  username VARCHAR(100) NOT NULL,
  first_name VARCHAR(100) NOT NULL,
  last_name VARCHAR(100),
  phone VARCHAR(100),
  email VARCHAR(100),
  PRIMARY KEY (id),
  FOREIGN KEY fk_users_contacts (username) REFERENCES users(username)
);

CREATE TABLE addresses
(
  id INT NOT NULL,
  contact_id INT NOT NULL,
  street VARCHAR(100),
  city VARCHAR(100),
  province VARCHAR(100),
  country VARCHAR(100),
  PRIMARY KEY (id),
  FOREIGN KEY fk_contacts_addresses (contact_id) REFERENCES contacts(id)
);
