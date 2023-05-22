SELECT client.NAME, count(project.ID) AS c  FROM client
LEFT JOIN project ON project.client_id =client.ID
GROUP BY client.NAME
having c = 
SELECT max(c) AS project_count FROM (
SELECT client.NAME, count(project.ID) AS c FROM client
LEFT JOIN project ON project.client_id = client.ID
GROUP BY client.NAME)