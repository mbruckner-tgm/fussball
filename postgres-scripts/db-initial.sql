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
	tournament_start DATE NOT NULL,
	tournament_end DATE NOT NULL,
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
 	match_day DATE NOT NULL,
	home_team_id VARCHAR(20) NOT NULL,
	opponent_team_id VARCHAR(20) NOT NULL,
	tournament_id VARCHAR(20),
	home_team_goals INT NOT NULL,
	opponent_team_goals INT NOT NULL,
	matchresult VARCHAR(1) NOT NULL,
	anlage_user  VARCHAR(36) NOT NULL,
	anlage_zeitpunkt TIMESTAMP NOT NULL,
	update_user  VARCHAR(36) NOT NULL,
	update_zeitpunkt TIMESTAMP NOT NULL,
	CONSTRAINT match_id PRIMARY KEY(match_day, home_team_id, opponent_team_id)
);


DROP TABLE IF EXISTS betting_picks;

CREATE TABLE betting_picks (
	betting_picks_collection_id VARCHAR(12),
	betting_pick_id VARCHAR(17),
	user_name VARCHAR(36),
	match_id VARCHAR(50) NOT NULL,
	betting_pick_result SMALLINT NOT NULL,
	matchresult VARCHAR(1) NOT NULL,
	team1_goals INT ,
	team2_goals INT ,
	PRIMARY KEY(betting_picks_collection_id,betting_pick_id,user_name),
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

\i teams_insert.sql
\i tournaments_insert.sql


-- users
--INSERT INTO app_user (player_name) VALUES ('Brucks');
--INSERT INTO app_user (player_name) VALUES ('Börni');
--INSERT INTO app_user (player_name) VALUES ('Fipsi');
--INSERT INTO app_user (player_name) VALUES ('Jake');
--INSERT INTO app_user (player_name) VALUES ('Flo');
--INSERT INTO app_user (player_name) VALUES ('Mani');
