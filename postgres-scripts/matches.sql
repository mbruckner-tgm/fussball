\c betting_db;

DROP TABLE IF EXISTS matches;

CREATE TABLE matches (
	match_id VARCHAR(50),
	tournament_id VARCHAR(20) NOT NULL,
	home_team_id VARCHAR(20) NOT NULL,
	opponent_team_id VARCHAR(20) NOT NULL,
	home_team_goals INT NOT NULL,
	opponent_team_goals INT NOT NULL,
	matchresult VARCHAR(1) NOT NULL,
	PRIMARY KEY(match_id)
);