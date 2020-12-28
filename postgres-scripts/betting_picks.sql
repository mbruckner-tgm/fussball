\c betting_db;

DROP TABLE IF EXISTS betting_picks;

CREATE TABLE betting_picks (
	betting_picks_collection_id VARCHAR(12),
	betting_pick_id VARCHAR(17),
	match_id VARCHAR(50),
	player_id INT,
	matchresult VARCHAR(1) NOT NULL,
	home_team_goals INT ,
	opponent_team_goals INT ,
	PRIMARY KEY(betting_picks_collection_id,betting_pick_id,player_id),
	FOREIGN KEY(match_id) REFERENCES matches (match_id) ON DELETE CASCADE,
	FOREIGN KEY(player_id) REFERENCES players (player_id)
);

