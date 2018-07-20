DROP TABLE IF EXISTS PUBLIC."team";
CREATE TABLE "team"
(
	"id"										SERIAL PRIMARY KEY,
	"name"										VARCHAR(64),
	"country"									VARCHAR(64),
	"continent"									VARCHAR(64),
	"coach"										VARCHAR(64),
	"logo"										VARCHAR(128),
	"history"									TEXT,
	"condition"									VARCHAR(256),
	"is_deleted"								BOOLEAN,
	"create_by"									INT4,
	"create_on"									TIMESTAMP,
	"modify_by"									INT4,
	"modify_on"									TIMESTAMP
);

DROP TABLE IF EXISTS PUBLIC."statement";
CREATE TABLE "statement"
(
	"id"										SERIAL PRIMARY KEY,
	"name"										VARCHAR(64),
	"from_date"									TIMESTAMP,
	"to_date"									TIMESTAMP,
	"history"									TEXT,
	"code"										VARCHAR(64),
	"parent_id"									INT4,
	"is_legs"									BOOLEAN,
	"is_deleted"								BOOLEAN,
	"create_by"									INT4,
	"create_on"									TIMESTAMP,
	"modify_by"									INT4,
	"modify_on"									TIMESTAMP
);

DROP TABLE IF EXISTS PUBLIC."calendar";
CREATE TABLE "calendar"
(
	"id"										SERIAL PRIMARY KEY,
	"competition_date"							TIMESTAMP,
	"start_guess"								TIMESTAMP,
	"team1_id"									INT4,
	"team2_id"									INT4,
	"stadium"									VARCHAR(64),
	"referee"									VARCHAR(64),
	"squad1"									TEXT,
	"squad2"									TEXT,
	"is_group_match"							BOOLEAN,
	"r1"										INT4,
	"r2"										INT4,
	"r11"										INT4,
	"r21"										INT4,
	"r12"										INT4,
	"r22"										INT4,
	"win_team"									INT4,
	"status"									VARCHAR(32),
	"is_deleted"								BOOLEAN,
	"create_by"									INT4,
	"create_on"									TIMESTAMP,
	"modify_by"									INT4,
	"modify_on"									TIMESTAMP
);

DROP TABLE IF EXISTS PUBLIC."join";
CREATE TABLE "join"
(
	"id"										SERIAL PRIMARY KEY,
	"team_id"									INT4,
	"statement_id"								INT4,
	"match"										INT4,
	"win"										INT4,
	"due"										INT4,
	"lose"										INT4,
	"goals_for"									INT4,
	"goals_against"								INT4,
	"goal_difference"							INT4,
	"point"										INT4,
	"is_deleted"								BOOLEAN,
	"create_by"									INT4,
	"create_on"									TIMESTAMP,
	"modify_by"									INT4,
	"modify_on"									TIMESTAMP
);

DROP TABLE IF EXISTS PUBLIC."news";
CREATE TABLE "news"
(
	"id"										SERIAL PRIMARY KEY,
	"title"										VARCHAR(256),
	"content"									TEXT,
	"is_deleted"								BOOLEAN,
	"create_by"									INT4,
	"create_on"									TIMESTAMP,
	"modify_by"									INT4,
	"modify_on"									TIMESTAMP
);

DROP TABLE IF EXISTS PUBLIC."bet";
CREATE TABLE "bet"
(
	"id"										SERIAL PRIMARY KEY,
	"calendar_id"								INT4,
	"code"										VARCHAR(64),
	"g11"										INT4,
	"g21"										INT4,
	"g22"										INT4,
	"g31"										INT4,
	"g41"										INT4,
	"amount"									FLOAT8,
	"sub_question"								INT4,
	"status"									VARCHAR(32),
	"user_id"									INT4,
	"is_deleted"								BOOLEAN,
	"create_by"									INT4,
	"create_on"									TIMESTAMP,
	"modify_by"									INT4,
	"modify_on"									TIMESTAMP
);

DROP TABLE IF EXISTS PUBLIC."ratio";
CREATE TABLE "ratio"
(
	"id"										SERIAL PRIMARY KEY,
	"calendar_id"								INT4,
	"code"										VARCHAR(64),
	"r11"										FLOAT8,
	"r12"										FLOAT8,
	"r13"										FLOAT8,
	"r21"										FLOAT8,
	"r22"										FLOAT8,
	"r31"										FLOAT8,
	"r32"										FLOAT8,
	"r33"										FLOAT8,
	"r4"										INT4,
	"status"									VARCHAR(32),
	"is_deleted"								BOOLEAN,
	"create_by"									INT4,
	"create_on"									TIMESTAMP,
	"modify_by"									INT4,
	"modify_on"									TIMESTAMP
);

DROP TABLE IF EXISTS PUBLIC."prize";
CREATE TABLE "prize"
(
	"id"										SERIAL PRIMARY KEY,
	"bet_id"									INT4,
	"total"										FLOAT8,
	"is_deleted"								BOOLEAN,
	"create_by"									INT4,
	"create_on"									TIMESTAMP,
	"modify_by"									INT4,
	"modify_on"									TIMESTAMP
);
DROP TABLE IF EXISTS PUBLIC."guess";
CREATE TABLE "guess"
(
	"id"										SERIAL PRIMARY KEY,
	"champion_id"								INT4,
	"top4_id"									VARCHAR(16),
	"sub_question"								INT4,
	"phone_no"									VARCHAR(16),
	"statement_id"								INT4,
	"status"									VARCHAR(32),
	"create_by"									INT4,
	"create_on"									TIMESTAMP,
	"modify_by"									INT4,
	"modify_on"									TIMESTAMP
);