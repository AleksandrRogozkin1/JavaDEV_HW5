INSERT INTO worker  (name, birthday, level, salary) VALUES
    ('Messi','1995-05-08','Senior',6600),
    ('Ronaldo','1992-12-11','Senior',7500),
    ('Yarmolenko','2000-01-01','Trainee',250),
    ('Welback','2005-03-22','Trainee',377),
    ('Rashford','1979-08-15','Junior',1234),
    ('Sterling','1995-02-02','Junior',1277),
    ('Haaland','1999-06-17','Middle',3000),
    ('Mbape','2001-09-23','Middle',3333),
    ('Dybala','1997-11-29','Trainee',600),
    ('Barzagli','1977-09-04','Junior',359);

INSERT INTO client (name) VALUES ('Chelsea'), ('DZK'), ('Arsenal'), ('Lvi na Jeepe'), ('Ubisoft');

INSERT INTO project (client_id, start_date, finish_date) VALUES
       (SELECT id FROM client WHERE name = 'Chelsea', '2022-02-03', '2023-07-20'),
       (SELECT id FROM client WHERE name = 'Chelsea', '2021-01-12', '2022-11-25'),
       (SELECT id FROM client WHERE name = 'DZK', '2020-12-04', '2021-12-28'),
       (SELECT id FROM client WHERE name = 'Arsenal', '2020-01-10', '2025-08-28'),
       (SELECT id FROM client WHERE name = 'Lvi na Jeepe', '2019-01-09', '2030-11-21'),
       (SELECT id FROM client WHERE name = 'Ubisoft', '2020-01-12', '2022-09-12'),
       (SELECT id FROM client WHERE name = 'Ubisoft', '2018-01-11', '2021-10-10'),
       (SELECT id FROM client WHERE name = 'Ubisoft', '2022-11-11', '2024-10-19'),
       (SELECT id FROM client WHERE name = 'Lvi na Jeepe', '2020-01-10', '2025-10-01'),
       (SELECT id FROM client WHERE name = 'Arsenal', '2022-06-23', '2026-01-11'),
       (SELECT id FROM client WHERE name = 'DZK', '2026-12-11', '2027-11-12');

INSERT INTO project_worker SELECT (SELECT id FROM project LIMIT 1 OFFSET 0), id FROM worker ORDER BY RAND() LIMIT (1);
INSERT INTO project_worker SELECT (SELECT id FROM project LIMIT 1 OFFSET 2), id FROM worker ORDER BY RAND() LIMIT (2);
INSERT INTO project_worker SELECT (SELECT id FROM project LIMIT 1 OFFSET 7), id FROM worker ORDER BY RAND() LIMIT (3);
INSERT INTO project_worker SELECT (SELECT id FROM project LIMIT 1 OFFSET 4), id FROM worker ORDER BY RAND() LIMIT (4);
INSERT INTO project_worker SELECT (SELECT id FROM project LIMIT 1 OFFSET 5), id FROM worker ORDER BY RAND() LIMIT (5);
INSERT INTO project_worker SELECT (SELECT id FROM project LIMIT 1 OFFSET 6), id FROM worker ORDER BY RAND() LIMIT (1);
INSERT INTO project_worker SELECT (SELECT id FROM project LIMIT 1 OFFSET 3), id FROM worker ORDER BY RAND() LIMIT (2);
INSERT INTO project_worker SELECT (SELECT id FROM project LIMIT 1 OFFSET 8), id FROM worker ORDER BY RAND() LIMIT (3);
INSERT INTO project_worker SELECT (SELECT id FROM project LIMIT 1 OFFSET 1), id FROM worker ORDER BY RAND() LIMIT (4);
INSERT INTO project_worker SELECT (SELECT id FROM project LIMIT 1 OFFSET 9), id FROM worker ORDER BY RAND() LIMIT (5);