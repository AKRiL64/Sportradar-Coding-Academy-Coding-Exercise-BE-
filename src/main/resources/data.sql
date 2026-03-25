INSERT INTO sport (name) VALUES ('Football');
INSERT INTO sport (name) VALUES ('Basketball');

INSERT INTO country (name, code) VALUES ('Country1', 'CO1');
INSERT INTO country (name, code) VALUES ('Country2', 'CO2');

INSERT INTO stadium (name, _id_country) VALUES ('Stadium1', 1);
INSERT INTO stadium (name, _id_country) VALUES ('Stadium2', 2);

INSERT INTO event_status (name) VALUES ('Scheduled');
INSERT INTO event_status (name) VALUES ('Live');
INSERT INTO event_status (name) VALUES ('Finished');

INSERT INTO participation_role (name) VALUES ('Home');
INSERT INTO participation_role (name) VALUES ('Away');

INSERT INTO team (official_name, _id_sport, _id_country) VALUES ('Team1', 1, 1);
INSERT INTO team (official_name, _id_sport, _id_country) VALUES ('Team2', 1, 1);
INSERT INTO team (official_name, _id_sport, _id_country) VALUES ('Team3', 1, 2);

INSERT INTO event (date, season, timeutc, _id_event_status, _id_stadium) VALUES ('2026-03-25', 2026, 1830, 1, 1);
INSERT INTO event (date, season, timeutc, _id_event_status, _id_stadium) VALUES ('2026-03-26', 2026, 2100, 2, 2);

-- Participations
-- Match 1: Team A (Home) - Team B (Away)
INSERT INTO participation (_id_event, _id_team, _id_participation_role) VALUES (1, 1, 1);
INSERT INTO participation (_id_event, _id_team, _id_participation_role) VALUES (1, 2, 2);

-- Match 2: Team C (Home) - none TBA
INSERT INTO participation (_id_event, _id_team, _id_participation_role) VALUES (2, 3, 1);