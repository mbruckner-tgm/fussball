\c betting_db;

DROP TABLE IF EXISTS teams;

CREATE TABLE teams (
	team_id VARCHAR(20),
	team_name VARCHAR(255) NOT NULL,
	PRIMARY KEY(team_id)
);

