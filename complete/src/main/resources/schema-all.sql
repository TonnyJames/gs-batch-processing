DROP TABLE IF EXISTS people;
CREATE TABLE people
(
    person_id  SERIAL PRIMARY KEY,
    first_name VARCHAR(20),
    last_name  VARCHAR(20)
);


-- CREATE TABLE people  (
--     person_id BIGINT IDENTITY NOT NULL PRIMARY KEY,
--     first_name VARCHAR(20),
--     last_name VARCHAR(20)
-- );