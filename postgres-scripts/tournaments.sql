\c betting_db;

DROP TABLE IF EXISTS tournaments;

CREATE TABLE tournaments (
	tournament_id VARCHAR(20),
	tournament_name VARCHAR(255) NOT NULL,
	PRIMARY KEY(tournament_id)
);

