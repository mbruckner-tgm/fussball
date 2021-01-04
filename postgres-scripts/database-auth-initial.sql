DROP DATABASE IF EXISTS auth_db;
CREATE DATABASE auth_db;

\c auth_db;

DROP TABLE IF EXISTS app_user;

CREATE TABLE app_user (
	user_id BIGINT PRIMARY KEY NOT NULL,
	user_name VARCHAR(36) UNIQUE NOT NULL,
	encrypted_password VARCHAR(128) NOT NULL,
	enabled INT NOT NULL
);

DROP TABLE IF EXISTS app_role;

CREATE TABLE app_role (
	role_id BIGINT PRIMARY KEY NOT NULL,
	role_name VARCHAR(30) UNIQUE NOT NULL 
);

DROP TABLE IF EXISTS user_role;

CREATE TABLE user_role(
	id BIGINT PRIMARY KEY NOT NULL,
	user_id BIGINT not null,
	role_id BIGINT not null,
	UNIQUE (user_id,role_id),
	FOREIGN KEY(user_id) REFERENCES app_user(user_id), 
	FOREIGN KEY(role_id) REFERENCES app_role(role_id)
);

DROP TABLE IF EXISTS persistent_logins;

CREATE TABLE persistent_logins (
    username varchar(64) NOT NULL,
    series varchar(64) NOT NULL,
    token varchar(64) NOT NULL,
    last_used timestamp NOT NULL,
    PRIMARY KEY (series)
);


INSERT INTO app_user (user_id, user_name, encrypted_password, enabled)
VALUES (2, 'dbuser1', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 1);
 
INSERT INTO app_user (user_id, user_name, encrypted_password, enabled)
VALUES (1, 'dbadmin1', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 1);
 
---
 
INSERT INTO app_role (role_id, role_name)
VALUES (1, 'ROLE_ADMIN');
 
INSERT INTO app_role (role_id, role_name)
VALUES (2, 'ROLE_USER');
 
---
 
INSERT INTO user_role (id, user_id, role_id)
VALUES (1, 1, 1);
 
INSERT INTO user_role (id, user_id, role_id)
VALUES (2, 1, 2);
 
INSERT INTO user_role (id, user_id, role_id)
VALUES (3, 2, 2);