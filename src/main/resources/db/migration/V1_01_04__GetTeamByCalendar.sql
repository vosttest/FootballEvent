-- 1. Drop function
DROP FUNCTION IF EXISTS get_team_by_cal();

-- 2. Create function
CREATE OR REPLACE FUNCTION get_team_by_cal(INT4)
RETURNS TABLE(id INT4, name VARCHAR, logo VARCHAR) AS $BODY$ 
BEGIN
RETURN QUERY
	SELECT team.id, team.name, team.logo
	FROM team
	WHERE (team.id = (SELECT calendar.team1_id FROM calendar WHERE calendar.id= $1))
	UNION ALL
	SELECT team.id, team.name, team.logo
	FROM team
	WHERE (team.id = (SELECT calendar.team2_id FROM calendar WHERE calendar.id= $1));
END;
$BODY$

LANGUAGE plpgsql VOLATILE
COST 100
ROWS 1000