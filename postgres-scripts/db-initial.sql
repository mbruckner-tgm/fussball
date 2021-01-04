DROP DATABASE IF EXISTS betting_db;
CREATE DATABASE betting_db WITH ENCODING = 'UTF8';

\c betting_db;

DROP TABLE IF EXISTS app_role;

CREATE TABLE app_role (
	role_name VARCHAR(30) UNIQUE NOT NULL,
	PRIMARY KEY(role_name)
);

DROP TABLE IF EXISTS app_user;

CREATE TABLE app_user (
	user_name VARCHAR(36) UNIQUE NOT NULL,
	encrypted_password VARCHAR(128) NOT NULL,
	role_name VARCHAR(30) NOT NULL,
	enabled INT NOT NULL,
	PRIMARY KEY(user_name),
	FOREIGN KEY(role_name) REFERENCES app_role (role_name) ON DELETE SET NULL
);

DROP TABLE IF EXISTS tournaments;

CREATE TABLE tournaments (
	tournament_id VARCHAR(20),
	tournament_name VARCHAR(255) NOT NULL,
	PRIMARY KEY(tournament_id)
);

DROP TABLE IF EXISTS teams;

CREATE TABLE teams (
	team_id VARCHAR(20),
	team_name VARCHAR(255) NOT NULL,
	PRIMARY KEY(team_id)
);


DROP TABLE IF EXISTS matches;

CREATE TABLE matches (
	match_id VARCHAR(50),
	tournament_id VARCHAR(20) NOT NULL,
	team1_id VARCHAR(20) NOT NULL,
	team2_id VARCHAR(20) NOT NULL,
	team1_goals INT NOT NULL,
	team2_goals INT NOT NULL,
	matchresult VARCHAR(1) NOT NULL,
	PRIMARY KEY(match_id)
);


DROP TABLE IF EXISTS betting_picks;

CREATE TABLE betting_picks (
	betting_picks_collection_id VARCHAR(12),
	betting_pick_id VARCHAR(17),
	user_name VARCHAR(36),
	match_id VARCHAR(50),
	matchresult VARCHAR(1) NOT NULL,
	team1_goals INT ,
	team2_goals INT ,
	PRIMARY KEY(betting_picks_collection_id,betting_pick_id,user_name),
	FOREIGN KEY(match_id) REFERENCES matches (match_id) ON DELETE CASCADE,
	FOREIGN KEY(user_name) REFERENCES app_user (user_name)
);




DROP TABLE IF EXISTS persistent_logins;

CREATE TABLE persistent_logins (
    username varchar(64) NOT NULL,
    series varchar(64) NOT NULL,
    token varchar(64) NOT NULL,
    last_used timestamp NOT NULL,
    PRIMARY KEY (series)
);

INSERT INTO app_role (role_name)
VALUES ('ROLE_ADMIN');
 
INSERT INTO app_role (role_name)
VALUES ('ROLE_USER');

INSERT INTO app_user (user_name, encrypted_password, role_name, enabled)
VALUES ('dbuser1', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 'ROLE_USER', 1);
 
INSERT INTO app_user (user_name, encrypted_password, role_name, enabled)
VALUES ('dbadmin1', '$2a$10$PrI5Gk9L.tSZiW9FXhTS8O8Mz9E97k2FZbFvGFFaSsiTUIl.TCrFu', 'ROLE_ADMIN', 1);
 
-- users 
--INSERT INTO app_user (player_name) VALUES ('Brucks');
--INSERT INTO app_user (player_name) VALUES ('Börni');
--INSERT INTO app_user (player_name) VALUES ('Fipsi');
--INSERT INTO app_user (player_name) VALUES ('Jake');
--INSERT INTO app_user (player_name) VALUES ('Flo');
--INSERT INTO app_user (player_name) VALUES ('Mani');


