\c betting_db;

DROP TABLE IF EXISTS betting_picks;
DROP TABLE IF EXISTS matches;

CREATE TABLE matches (
 	match_day DATE NOT NULL,
	home_team_id VARCHAR(20) NOT NULL,
	opponent_team_id VARCHAR(20) NOT NULL,
	tournament_id VARCHAR(20),
	home_team_goals INT ,
	opponent_team_goals INT ,
	kickoff VARCHAR(5) NOT NULL,
	matchresult VARCHAR(1) ,
	anlage_user  VARCHAR(36) NOT NULL,
	anlage_zeitpunkt TIMESTAMP NOT NULL,
	update_user  VARCHAR(36) NOT NULL,
	update_zeitpunkt TIMESTAMP NOT NULL,
	CONSTRAINT match_id PRIMARY KEY(match_day, home_team_id, opponent_team_id)
);

\i betting_picks.sql
