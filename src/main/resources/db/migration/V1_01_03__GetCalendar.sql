-- 1. Drop function
DROP FUNCTION IF EXISTS get_calendar();

-- 2. Create function
CREATE OR REPLACE FUNCTION get_calendar(from_date TIMESTAMP, to_date TIMESTAMP)
RETURNS TABLE(competition_date TIMESTAMP, start_guess TIMESTAMP, team1_id INT4,
			  name_1 VARCHAR, logo_1 VARCHAR, team2_id INT4, name_2 VARCHAR,
			  logo_2 VARCHAR, id INT4) AS $BODY$
BEGIN
RETURN QUERY
	SELECT DISTINCT a.competition_date, a.start_guess, a.team1_id, b.name,b.logo, a.team2_id, c.name, c.logo, a.id
	FROM calendar a
	JOIN team b ON a.team1_id = b.id
	JOIN team c ON a.team2_id = c.id
	WHERE a.competition_date BETWEEN from_date AND  to_date
	ORDER BY a.competition_date;
END;
$BODY$

LANGUAGE plpgsql VOLATILE
COST 100
ROWS 1000