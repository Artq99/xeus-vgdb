-- =============================================================================
--
-- Lords of the Fallen
--
-- =============================================================================

-- -----------------------------------------------------------------------------
-- Variables for the IDs of the platforms
-- -----------------------------------------------------------------------------

SET @platform_id_mswindows = (
    SELECT platform_id
    FROM t_platform
    WHERE platform_name = 'Microsoft Windows');

SET @platform_id_ps4 = (
    SELECT platform_id
    FROM t_platform
    WHERE platform_name = 'PlayStation 4');

SET @platform_id_xbo = (
    SELECT platform_id
    FROM t_platform
    WHERE platform_name = 'XBox One');

-- -----------------------------------------------------------------------------
-- Variables for the publishers and the developers
-- -----------------------------------------------------------------------------

SET @publisher_id_ci_games = (
    SELECT publisher_id
    FROM t_publisher
    WHERE publisher_name = 'CI Games');

SET @publisher_id_square_enix = (
    SELECT publisher_id
    FROM t_publisher
    WHERE publisher_name = 'Square Enix');

SET @developer_id_ci_games = (
    SELECT developer_id
    FROM t_developer
    WHERE developer_name = 'CI Games');

SET @developer_id_deck13 = (
    SELECT developer_id
    FROM t_developer
    WHERE developer_name = 'Deck13 Interactive');

-- -----------------------------------------------------------------------------
-- Game
-- -----------------------------------------------------------------------------

INSERT INTO t_game (
    title,
    game_description)
VALUES (
    'Lords of the Fallen',
    'Lords of the Fallen is a hardcore action-RPG featuring an advanced combat '
    'systems and robust class skill trees.');

SET @game_id = (
    SELECT game_id
    FROM t_game
    WHERE title = 'Lords of the Fallen');

-- -----------------------------------------------------------------------------
-- Release: 28.10.2014, MSWindows
-- -----------------------------------------------------------------------------

INSERT INTO t_release (
    release_name,
    release_date,
    game_id,
    platform_id)
VALUES (
    'Lords of the Fallen',
    '2014-10-28',
    @game_id,
    @platform_id_mswindows);

SET @rel_id_28_10_2014_msw = (
    SELECT release_id
    FROM t_release
    WHERE game_id = @game_id
        AND platform_id = @platform_id_mswindows
        AND release_date = '2014-10-28');

INSERT INTO t_release_publishing (
    release_id,
    publisher_id)
VALUES (
    @rel_id_28_10_2014_msw,
    @publisher_id_ci_games);

INSERT INTO t_release_publishing (
    release_id,
    publisher_id)
VALUES (
    @rel_id_28_10_2014_msw,
    @publisher_id_square_enix);

INSERT INTO t_release_development (
    release_id,
    developer_id)
VALUES (
    @rel_id_28_10_2014_msw,
    @developer_id_ci_games);

INSERT INTO t_release_development (
    release_id,
    developer_id)
VALUES (
    @rel_id_28_10_2014_msw,
    @developer_id_deck13);

-- -----------------------------------------------------------------------------
-- Release: 28.10.2014, PS4
-- -----------------------------------------------------------------------------

INSERT INTO t_release (
    release_name,
    release_date,
    game_id,
    platform_id)
VALUES (
    'Lords of the Fallen',
    '2014-10-28',
    @game_id,
    @platform_id_ps4);

SET @rel_id_28_10_2014_ps4 = (
    SELECT release_id
    FROM t_release
    WHERE game_id = @game_id
        AND platform_id = @platform_id_ps4
        AND release_date = '2014-10-28');

INSERT INTO t_release_publishing (
    release_id,
    publisher_id)
VALUES (
    @rel_id_28_10_2014_ps4,
    @publisher_id_ci_games);

INSERT INTO t_release_publishing (
    release_id,
    publisher_id)
VALUES (
    @rel_id_28_10_2014_ps4,
    @publisher_id_square_enix);

INSERT INTO t_release_development (
    release_id,
    developer_id)
VALUES (
    @rel_id_28_10_2014_ps4,
    @developer_id_ci_games);

INSERT INTO t_release_development (
    release_id,
    developer_id)
VALUES (
    @rel_id_28_10_2014_ps4,
    @developer_id_deck13);

-- -----------------------------------------------------------------------------
-- Release: 28.10.2014, XBO
-- -----------------------------------------------------------------------------

INSERT INTO t_release (
    release_name,
    release_date,
    game_id,
    platform_id)
VALUES (
    'Lords of the Fallen',
    '2014-10-28',
    @game_id,
    @platform_id_xbo);

SET @rel_id_28_10_2014_xbo = (
    SELECT release_id
    FROM t_release
    WHERE game_id = @game_id
        AND platform_id = @platform_id_xbo
        AND release_date = '2014-10-28');

INSERT INTO t_release_publishing (
    release_id,
    publisher_id)
VALUES (
    @rel_id_28_10_2014_xbo,
    @publisher_id_ci_games);

INSERT INTO t_release_publishing (
    release_id,
    publisher_id)
VALUES (
    @rel_id_28_10_2014_xbo,
    @publisher_id_square_enix);

INSERT INTO t_release_development (
    release_id,
    developer_id)
VALUES (
    @rel_id_28_10_2014_xbo,
    @developer_id_ci_games);

INSERT INTO t_release_development (
    release_id,
    developer_id)
VALUES (
    @rel_id_28_10_2014_xbo,
    @developer_id_deck13);