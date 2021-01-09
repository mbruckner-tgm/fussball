\c betting_db;

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
