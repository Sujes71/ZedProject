CREATE TABLE Account (
    id UUID PRIMARY KEY,
    puuid VARCHAR(255) NOT NULL,
    game_name VARCHAR(255) NOT NULL,
    tag_line VARCHAR(255) NOT NULL
);