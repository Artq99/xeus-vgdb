CREATE TABLE t_platform (
    platform_id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    created_on DATETIME DEFAULT CURRENT_TIMESTAMP,
    modified_on DATETIME ON UPDATE CURRENT_TIMESTAMP,
    version BIGINT UNSIGNED DEFAULT 0,
    platform_name VARCHAR(255),
    PRIMARY KEY (platform_id));

CREATE TABLE t_game (
    game_id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    created_on DATETIME DEFAULT CURRENT_TIMESTAMP,
    modified_on DATETIME ON UPDATE CURRENT_TIMESTAMP,
    version BIGINT UNSIGNED DEFAULT 0,
    title VARCHAR(255),
    game_description TEXT,
    PRIMARY KEY (game_id));

CREATE TABLE t_expansion (
    expansion_id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    created_on DATETIME DEFAULT CURRENT_TIMESTAMP,
    modified_on DATETIME ON UPDATE CURRENT_TIMESTAMP,
    version BIGINT UNSIGNED DEFAULT 0,
    title VARCHAR(255),
    expansion_description TEXT,
    game_id BIGINT UNSIGNED NOT NULL,
    PRIMARY KEY (expansion_id),
    CONSTRAINT fk_t_expansion_t_game_game_id
        FOREIGN KEY (game_id)
        REFERENCES t_game(game_id)
        ON DELETE CASCADE);

CREATE TABLE t_publisher (
    publisher_id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    created_on DATETIME DEFAULT CURRENT_TIMESTAMP,
    modified_on DATETIME ON UPDATE CURRENT_TIMESTAMP,
    version BIGINT UNSIGNED DEFAULT 0,
    publisher_name VARCHAR(255),
    PRIMARY KEY (publisher_id));

CREATE TABLE t_developer (
    developer_id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    created_on DATETIME DEFAULT CURRENT_TIMESTAMP,
    modified_on DATETIME ON UPDATE CURRENT_TIMESTAMP,
    version BIGINT UNSIGNED DEFAULT 0,
    developer_name VARCHAR(255),
    PRIMARY KEY (developer_id));

CREATE TABLE t_release (
    release_id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    created_on DATETIME DEFAULT CURRENT_TIMESTAMP,
    modified_on DATETIME ON UPDATE CURRENT_TIMESTAMP,
    version BIGINT UNSIGNED DEFAULT 0,
    release_name VARCHAR(255),
    release_date DATE,
    release_region VARCHAR(255),
    release_description TEXT,
    game_id BIGINT UNSIGNED,
    platform_id BIGINT UNSIGNED,
    PRIMARY KEY (release_id),
    CONSTRAINT fk_t_release_t_game_game_id
        FOREIGN KEY (game_id)
        REFERENCES t_game(game_id)
        ON DELETE CASCADE,
    CONSTRAINT fk_t_release_t_platform_platform_id
        FOREIGN KEY (platform_id)
        REFERENCES t_platform(platform_id)
        ON DELETE CASCADE);

CREATE TABLE t_expansion_release (
    expansion_release_id BIGINT UNSIGNED NOT NULL AUTO_INCREMENT,
    created_on DATETIME DEFAULT CURRENT_TIMESTAMP,
    modified_on DATETIME ON UPDATE CURRENT_TIMESTAMP,
    version BIGINT UNSIGNED DEFAULT 0,
    release_name VARCHAR(255),
    release_date DATE,
    release_region VARCHAR(255),
    release_description TEXT,
    expansion_id BIGINT UNSIGNED,
    platform_id BIGINT UNSIGNED,
    PRIMARY KEY (expansion_release_id),
    CONSTRAINT fk_t_expansion_release_t_expansion_expansion_id
        FOREIGN KEY (expansion_id)
        REFERENCES t_expansion(expansion_id)
        ON DELETE CASCADE,
    CONSTRAINT fk_t_expansion_release_t_platform_platform_id
        FOREIGN KEY (platform_id)
        REFERENCES t_platform(platform_id)
        ON DELETE CASCADE);

CREATE TABLE t_release_publishing (
    release_id BIGINT UNSIGNED NOT NULL,
    publisher_id BIGINT UNSIGNED NOT NULL,
    CONSTRAINT fk_t_release_publishing_t_release_release_id
        FOREIGN KEY (release_id)
        REFERENCES t_release(release_id)
        ON DELETE CASCADE,
    CONSTRAINT fk_t_release_publishing_t_publisher_publisher_id
        FOREIGN KEY (publisher_id)
        REFERENCES t_publisher(publisher_id)
        ON DELETE CASCADE);

CREATE TABLE t_expansion_release_publishing (
    expansion_release_id BIGINT UNSIGNED NOT NULL,
    publisher_id BIGINT UNSIGNED NOT NULL,
    CONSTRAINT fk_t_exp_release_publishing_t_exp_release_expansion_release_id
        FOREIGN KEY (expansion_release_id)
        REFERENCES t_expansion_release(expansion_release_id)
        ON DELETE CASCADE,
    CONSTRAINT fk_t_exp_release_publishing_t_publisher_publisher_id
        FOREIGN KEY (publisher_id)
        REFERENCES t_publisher(publisher_id)
        ON DELETE CASCADE);

CREATE TABLE t_release_development (
    release_id BIGINT UNSIGNED NOT NULL,
    developer_id BIGINT UNSIGNED NOT NULL,
    CONSTRAINT fk_t_release_development_t_release_release_id
        FOREIGN KEY (release_id)
        REFERENCES t_release(release_id)
        ON DELETE CASCADE,
    CONSTRAINT fk_t_release_development_t_developer_developer_id
        FOREIGN KEY (developer_id)
        REFERENCES t_developer(developer_id)
        ON DELETE CASCADE);

CREATE TABLE t_expansion_release_development (
    expansion_release_id BIGINT UNSIGNED NOT NULL,
    developer_id BIGINT UNSIGNED NOT NULL,
    CONSTRAINT fk_t_exp_release_development_t_exp_release_expansion_release_id
        FOREIGN KEY (expansion_release_id)
        REFERENCES t_expansion_release(expansion_release_id)
        ON DELETE CASCADE,
    CONSTRAINT fk_t_expansion_release_development_t_developer_developer_id
        FOREIGN KEY (developer_id)
        REFERENCES t_developer(developer_id)
        ON DELETE CASCADE);

CREATE TABLE t_release_additional_content (
    release_id BIGINT UNSIGNED NOT NULL,
    expansion_id BIGINT UNSIGNED NOT NULL,
    CONSTRAINT fk_t_rel_add_cont_t_release_release_id
        FOREIGN KEY (release_id)
        REFERENCES t_release(release_id)
        ON DELETE CASCADE,
    CONSTRAINT tk_t_rel_add_cont_t_expansion_expansion_id
        FOREIGN KEY (expansion_id)
        REFERENCES t_expansion(expansion_id)
        ON DELETE CASCADE);

CREATE VIEW game_list_data AS
    SELECT
        t_game.title AS 'Title',
        COUNT(t_release.release_id) AS 'Releases',
        MIN(t_release.release_date) AS 'First release'
    FROM t_release
    LEFT JOIN t_game USING(game_id)
    GROUP BY game_id;