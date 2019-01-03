-- =============================================================================
--
-- The Elder Scrolls V: Skyrim
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

SET @platform_id_ps3 = (
    SELECT platform_id
    FROM t_platform
    WHERE platform_name = 'PlayStation 3');

SET @platform_id_xbo = (
    SELECT platform_id
    FROM t_platform
    WHERE platform_name = 'XBox One');

SET @platform_id_x360 = (
    SELECT platform_id
    FROM t_platform
    WHERE platform_name = 'XBox 360');

-- -----------------------------------------------------------------------------
-- Variables for the publisher and the developer
-- -----------------------------------------------------------------------------

SET @publisher_id_bethesda = (
    SELECT publisher_id
    FROM t_publisher
    WHERE publisher_name = 'Bethesda Softworks');

SET @developer_id_bethesda = (
    SELECT developer_id
    FROM t_developer
    WHERE developer_name = 'Bethesda Game Studios');

-- -----------------------------------------------------------------------------
-- Game
-- -----------------------------------------------------------------------------

INSERT INTO t_game (
    title,
    game_description)
VALUES (
    'The Elder Scrolls V: Skyrim',
    'The Elder Scrolls V: Skyrim is an open-world action role-playing game '
    'developed by Bethesda Game Studios.');

SET @game_id = (
    SELECT game_id
    FROM t_game
    WHERE title = 'The Elder Scrolls V: Skyrim');

-- -----------------------------------------------------------------------------
-- Release: 11.11.2011, worldwide, MSWindows
-- -----------------------------------------------------------------------------

INSERT INTO t_release (
    release_name,
    release_date,
    release_region,
    release_description,
    game_id,
    platform_id)
VALUES (
    'The Elder Scrolls V: Skyrim',
    '2011-11-11',
    'Worldwide',
    'The first MS Windows release.',
    @game_id,
    @platform_id_mswindows);

SET @rel_id_11_11_2011_msw = (
    SELECT release_id
    FROM t_release
    WHERE game_id = @game_id
        AND platform_id = @platform_id_mswindows
        AND release_date = '2011-11-11'
        AND release_region = 'Worldwide');

INSERT INTO t_release_publishing (
    release_id,
    publisher_id)
VALUES (
    @rel_id_11_11_2011_msw,
    @publisher_id_bethesda);

INSERT INTO t_release_development (
    release_id,
    developer_id)
VALUES (
    @rel_id_11_11_2011_msw,
    @developer_id_bethesda);

-- -----------------------------------------------------------------------------
-- Release: 11.11.2011, worldwide, PS3
-- -----------------------------------------------------------------------------

INSERT INTO t_release (
    release_name,
    release_date,
    release_region,
    release_description,
    game_id,
    platform_id)
VALUES (
    'The Elder Scrolls V: Skyrim',
    '2011-11-11',
    'Worldwide',
    'The first PS3 release.',
    @game_id,
    @platform_id_ps3);

SET @rel_id_11_11_2011_ps3 = (
    SELECT release_id
    FROM t_release
    WHERE game_id = @game_id
        AND platform_id = @platform_id_ps3
        AND release_date = '2011-11-11'
        AND release_region = 'Worldwide');

INSERT INTO t_release_publishing (
    release_id,
    publisher_id)
VALUES (
    @rel_id_11_11_2011_ps3,
    @publisher_id_bethesda);

INSERT INTO t_release_development (
    release_id,
    developer_id)
VALUES (
    @rel_id_11_11_2011_ps3,
    @developer_id_bethesda);

-- -----------------------------------------------------------------------------
-- Release: 11.11.2011, worldwide, X360
-- -----------------------------------------------------------------------------

INSERT INTO t_release (
    release_name,
    release_date,
    release_region,
    release_description,
    game_id,
    platform_id)
VALUES (
    'The Elder Scrolls V: Skyrim',
    '2011-11-11',
    'Worldwide',
    'The first X360 release.',
    @game_id,
    @platform_id_x360);

SET @rel_id_11_11_2011_x360 = (
    SELECT release_id
    FROM t_release
    WHERE game_id = @game_id
        AND platform_id = @platform_id_x360
        AND release_date = '2011-11-11'
        AND release_region = 'Worldwide');

INSERT INTO t_release_publishing (
    release_id,
    publisher_id)
VALUES (
    @rel_id_11_11_2011_x360,
    @publisher_id_bethesda);

INSERT INTO t_release_development (
    release_id,
    developer_id)
VALUES (
    @rel_id_11_11_2011_x360,
    @developer_id_bethesda);

-- -----------------------------------------------------------------------------
-- Expansion: Dawnguard
-- -----------------------------------------------------------------------------

INSERT INTO t_expansion (
    title,
    expansion_description,
    game_id)
VALUES (
    'Dawnguard',
    'The Elder Scrolls V: Skyrim – Dawnguard is a downloadable content add-on '
	'for the action role-playing open world video game The Elder Scrolls V: '
	'Skyrim. It was developed by Bethesda Game Studios and published by '
	'Bethesda Softworks.',
    @game_id);

SET @ex_id_dawnguard = (
    SELECT expansion_id
    FROM t_expansion
    WHERE game_id = @game_id
        AND title = 'Dawnguard');

-- -----------------------------------------------------------------------------
-- Expansion release: Dawnguard, 26.06.2012, worldwide, X360
-- -----------------------------------------------------------------------------

INSERT INTO t_expansion_release (
    release_name,
    release_date,
    release_region,
    release_description,
    expansion_id,
    platform_id)
VALUES (
    'Dawnguard',
    '2012-06-26',
    'Worldwide',
    'The first X360 release.',
    @ex_id_dawnguard,
    @platform_id_x360);

SET @ex_rel_id_26_06_2012_x360 = (
    SELECT expansion_release_id
    FROM t_expansion_release
    WHERE expansion_id = @ex_id_dawnguard 
        AND platform_id = @platform_id_x360
        AND release_date = '2012-06-26'
        AND release_region = 'Worldwide');

INSERT INTO t_expansion_release_publishing (
    expansion_release_id,
    publisher_id)
VALUES (
    @ex_rel_id_26_06_2012_x360,
    @publisher_id_bethesda);

INSERT INTO t_expansion_release_development (
    expansion_release_id,
    developer_id)
VALUES (
    @ex_rel_id_26_06_2012_x360,
    @developer_id_bethesda);

-- -----------------------------------------------------------------------------
-- Expansion release: Dawnguard, 02.08.2012, worldwide, MS Windows
-- -----------------------------------------------------------------------------

INSERT INTO t_expansion_release (
    release_name,
    release_date,
    release_region,
    release_description,
    expansion_id,
    platform_id)
VALUES (
    'Dawnguard',
    '2012-08-02',
    'Worldwide',
    'The first MS Windows release.',
    @ex_id_dawnguard,
    @platform_id_mswindows);

SET @ex_rel_id_02_08_2012_msw = (
    SELECT expansion_release_id
    FROM t_expansion_release
    WHERE expansion_id = @ex_id_dawnguard 
        AND platform_id = @platform_id_mswindows
        AND release_date = '2012-08-02'
        AND release_region = 'Worldwide');

INSERT INTO t_expansion_release_publishing (
    expansion_release_id,
    publisher_id)
VALUES (
    @ex_rel_id_02_08_2012_msw,
    @publisher_id_bethesda);

INSERT INTO t_expansion_release_development (
    expansion_release_id,
    developer_id)
VALUES (
    @ex_rel_id_02_08_2012_msw,
    @developer_id_bethesda);

-- -----------------------------------------------------------------------------
-- Expansion release: Dawnguard, 26.02.2013, North America, PS3
-- -----------------------------------------------------------------------------

INSERT INTO t_expansion_release (
    release_name,
    release_date,
    release_region,
    release_description,
    expansion_id,
    platform_id)
VALUES (
    'Dawnguard',
    '2013-02-26',
    'North America',
    'The first PS3 release in North America.',
    @ex_id_dawnguard,
    @platform_id_ps3);

SET @ex_rel_26_02_2013_ps3_na = (
    SELECT expansion_release_id
    FROM t_expansion_release
    WHERE expansion_id = @ex_id_dawnguard
        AND platform_id = @platform_id_ps3
        AND release_date = '2013-02-26'
        AND release_region = 'North America');

INSERT INTO t_expansion_release_publishing (
    expansion_release_id,
    publisher_id)
VALUES (
    @ex_rel_26_02_2013_ps3_na,
    @publisher_id_bethesda);

INSERT INTO t_expansion_release_development (
    expansion_release_id,
    developer_id)
VALUES (
    @ex_rel_26_02_2013_ps3_na,
    @developer_id_bethesda);

-- -----------------------------------------------------------------------------
-- Expansion release: Dawnguard, 27.02.2012, Europe, PS3
-- -----------------------------------------------------------------------------

INSERT INTO t_expansion_release (
    release_name,
    release_date,
    release_region,
    release_description,
    expansion_id,
    platform_id)
VALUES (
    'Dawnguard',
    '2013-02-27',
    'Europe',
    'The first PS3 release in Europe.',
    @ex_id_dawnguard,
    @platform_id_ps3);

SET @ex_rel_27_02_2013_ps3_eu = (
    SELECT expansion_release_id
    FROM t_expansion_release
    WHERE expansion_id = @ex_id_dawnguard
        AND platform_id = @platform_id_ps3
        AND release_date = '2013-02-27'
        AND release_region = 'Europe');

INSERT INTO t_expansion_release_publishing (
    expansion_release_id,
    publisher_id)
VALUES (
    @ex_rel_27_02_2013_ps3_eu,
    @publisher_id_bethesda);

INSERT INTO t_expansion_release_development (
    expansion_release_id,
    developer_id)
VALUES (
    @ex_rel_27_02_2013_ps3_eu,
    @developer_id_bethesda);

-- -----------------------------------------------------------------------------
-- Expansion: Hearthfire
-- -----------------------------------------------------------------------------

INSERT INTO t_expansion (
    title,
    expansion_description,
    game_id)
VALUES (
    'Hearthfire',
    'Hearthfire is the second downloadable content add-on for the action '
    'role-playing open world video game The Elder Scrolls V: Skyrim.',
    @game_id);

SET @ex_id_hearthfire = (
    SELECT expansion_id
    FROM t_expansion
    WHERE game_id = @game_id
        AND title = 'Hearthfire');

-- -----------------------------------------------------------------------------
-- Expansion release: Hearthfire, 04.09.2012, worldwide, X360
-- -----------------------------------------------------------------------------

INSERT INTO t_expansion_release (
    release_name,
    release_date,
    release_region,
    release_description,
    expansion_id,
    platform_id)
VALUES (
    'Hearthfire',
    '2012-09-04',
    'Worldwide',
    'The first X360 release.',
    @ex_id_hearthfire,
    @platform_id_x360);

SET @ex_rel_04_09_2012_x360 = (
    SELECT expansion_release_id
    FROM t_expansion_release
    WHERE expansion_id = @ex_id_hearthfire
        AND platform_id = @platform_id_x360
        AND release_date = '2012-09-04'
        AND release_region = 'Worldwide');

INSERT INTO t_expansion_release_publishing (
    expansion_release_id,
    publisher_id)
VALUES (
    @ex_rel_04_09_2012_x360,
    @publisher_id_bethesda);

INSERT INTO t_expansion_release_development (
    expansion_release_id,
    developer_id)
VALUES (
    @ex_rel_04_09_2012_x360,
    @developer_id_bethesda);

-- -----------------------------------------------------------------------------
-- Expansion release: Hearthfire, 05.10.2012, worldwide, MSWindows
-- -----------------------------------------------------------------------------

INSERT INTO t_expansion_release (
    release_name,
    release_date,
    release_region,
    release_description,
    expansion_id,
    platform_id)
VALUES (
    'Hearthfire',
    '2012-10-05',
    'Worldwide',
    'The first MS Windows release.',
    @ex_id_hearthfire,
    @platform_id_mswindows);

SET @ex_rel_05_10_2012_msw = (
    SELECT expansion_release_id
    FROM t_expansion_release
    WHERE expansion_id = @ex_id_hearthfire
        AND platform_id = @platform_id_mswindows
        AND release_date = '2012-10-05'
        AND release_region = 'Worldwide');

INSERT INTO t_expansion_release_publishing (
    expansion_release_id,
    publisher_id)
VALUES (
    @ex_rel_05_10_2012_msw,
    @publisher_id_bethesda);

INSERT INTO t_expansion_release_development (
    expansion_release_id,
    developer_id)
VALUES (
    @ex_rel_05_10_2012_msw,
    @developer_id_bethesda);

-- -----------------------------------------------------------------------------
-- Expansion release: Hearthfire, 19.02.2013, North America, PS3
-- -----------------------------------------------------------------------------

INSERT INTO t_expansion_release (
    release_name,
    release_date,
    release_region,
    release_description,
    expansion_id,
    platform_id)
VALUES (
    'Hearthfire',
    '2013-02-19',
    'North America',
    'The first PS3 release in North America.',
    @ex_id_hearthfire,
    @platform_id_ps3);

SET @ex_rel_19_02_2013_ps3_na = (
    SELECT expansion_release_id
    FROM t_expansion_release
    WHERE expansion_id = @ex_id_hearthfire
        AND platform_id = @platform_id_ps3
        AND release_date = '2013-02-19'
        AND release_region = 'North America');

INSERT INTO t_expansion_release_publishing (
    expansion_release_id,
    publisher_id)
VALUES (
    @ex_rel_19_02_2013_ps3_na,
    @publisher_id_bethesda);

INSERT INTO t_expansion_release_development (
    expansion_release_id,
    developer_id)
VALUES (
    @ex_rel_19_02_2013_ps3_na,
    @developer_id_bethesda);

-- -----------------------------------------------------------------------------
-- Expansion release: Hearthfire, 20.02.2013, Europe, PS3
-- -----------------------------------------------------------------------------

INSERT INTO t_expansion_release (
    release_name,
    release_date,
    release_region,
    release_description,
    expansion_id,
    platform_id)
VALUES (
    'Hearthfire',
    '2013-02-20',
    'Europe',
    'The first PS3 release in Europe.',
    @ex_id_hearthfire,
    @platform_id_ps3);

SET @ex_rel_20_02_2013_ps3_eu = (
    SELECT expansion_release_id
    FROM t_expansion_release
    WHERE expansion_id = @ex_id_hearthfire
        AND platform_id = @platform_id_ps3
        AND release_date = '2013-02-20'
        AND release_region = 'Europe');

INSERT INTO t_expansion_release_publishing (
    expansion_release_id,
    publisher_id)
VALUES (
    @ex_rel_20_02_2013_ps3_eu,
    @publisher_id_bethesda);

INSERT INTO t_expansion_release_development (
    expansion_release_id,
    developer_id)
VALUES (
    @ex_rel_20_02_2013_ps3_eu,
    @developer_id_bethesda);

-- -----------------------------------------------------------------------------
-- Expansion: Dragonborn
-- -----------------------------------------------------------------------------

INSERT INTO t_expansion (
    title,
    expansion_description,
    game_id)
VALUES (
    'Dragonborn',
    'Dragonborn is the third add-on for the action role-playing open world '
    'video game The Elder Scrolls V: Skyrim.',
    @game_id);
    
SET @ex_id_dragonborn = (
    SELECT expansion_id
    FROM t_expansion
    WHERE game_id = @game_id
        AND title = 'Dragonborn');

-- -----------------------------------------------------------------------------
-- Expansion release: Dragonborn, 04.12.2012, worldwide, X360
-- -----------------------------------------------------------------------------

INSERT INTO t_expansion_release (
    release_name,
    release_date,
    release_region,
    release_description,
    expansion_id,
    platform_id)
VALUES (
    'Dragonborn',
    '2012-12-04',
    'Worldwide',
    'The first X360 release.',
    @ex_id_dragonborn,
    @platform_id_x360);

SET @ex_rel_04_12_2012_x360 = (
    SELECT expansion_release_id
    FROM t_expansion_release
    WHERE expansion_id = @ex_id_dragonborn
        AND platform_id = @platform_id_x360
        AND release_date = '2012-12-04'
        AND release_region = 'Worldwide');

INSERT INTO t_expansion_release_publishing (
    expansion_release_id,
    publisher_id)
VALUES (
    @ex_rel_04_12_2012_x360,
    @publisher_id_bethesda);

INSERT INTO t_expansion_release_development (
    expansion_release_id,
    developer_id)
VALUES (
    @ex_rel_04_12_2012_x360,
    @developer_id_bethesda);

-- -----------------------------------------------------------------------------
-- Expansion release: Dragonborn, 05.02.2013, worldwide, MSWindows
-- -----------------------------------------------------------------------------

INSERT INTO t_expansion_release (
    release_name,
    release_date,
    release_region,
    release_description,
    expansion_id,
    platform_id)
VALUES (
    'Dragonborn',
    '2013-02-05',
    'Worldwide',
    'The first MS Windows release.',
    @ex_id_dragonborn,
    @platform_id_mswindows);

SET @ex_rel_05_02_2013_msw = (
    SELECT expansion_release_id
    FROM t_expansion_release
    WHERE expansion_id = @ex_id_dragonborn
        AND platform_id = @platform_id_mswindows
        AND release_date = '2013-02-05'
        AND release_region = 'Worldwide');

INSERT INTO t_expansion_release_publishing (
    expansion_release_id,
    publisher_id)
VALUES (
    @ex_rel_05_02_2013_msw,
    @publisher_id_bethesda);

INSERT INTO t_expansion_release_development (
    expansion_release_id,
    developer_id)
VALUES (
    @ex_rel_05_02_2013_msw,
    @developer_id_bethesda);

-- -----------------------------------------------------------------------------
-- Expansion release: Dragonborn, 12.02.2013, North America, PS3
-- -----------------------------------------------------------------------------

INSERT INTO t_expansion_release (
    release_name,
    release_date,
    release_region,
    release_description,
    expansion_id,
    platform_id)
VALUES (
    'Dragonborn',
    '2013-02-12',
    'North America',
    'The first PS3 release in North America.',
    @ex_id_dragonborn,
    @platform_id_ps3);

SET @ex_rel_12_02_2013_ps3_na = (
    SELECT expansion_release_id
    FROM t_expansion_release
    WHERE expansion_id = @ex_id_dragonborn
        AND platform_id = @platform_id_ps3
        AND release_date = '2013-02-12'
        AND release_region = 'North America');

INSERT INTO t_expansion_release_publishing (
    expansion_release_id,
    publisher_id)
VALUES (
    @ex_rel_12_02_2013_ps3_na,
    @publisher_id_bethesda);

INSERT INTO t_expansion_release_development (
    expansion_release_id,
    developer_id)
VALUES (
    @ex_rel_12_02_2013_ps3_na,
    @developer_id_bethesda);

-- -----------------------------------------------------------------------------
-- Expansion release: Dragonborn, 13.02.2013, Europe, PS3
-- -----------------------------------------------------------------------------

INSERT INTO t_expansion_release (
    release_name,
    release_date,
    release_region,
    release_description,
    expansion_id,
    platform_id)
VALUES (
    'Dragonborn',
    '2013-02-13',
    'Europe',
    'The first PS3 release in Europe.',
    @ex_id_dragonborn,
    @platform_id_ps3);

SET @ex_rel_13_02_2013_ps3_eu = (
    SELECT expansion_release_id
    FROM t_expansion_release
    WHERE expansion_id = @ex_id_dragonborn
        AND platform_id = @platform_id_ps3
        AND release_date = '2013-02-13'
        AND release_region = 'Europe');

INSERT INTO t_expansion_release_publishing (
    expansion_release_id,
    publisher_id)
VALUES (
    @ex_rel_13_02_2013_ps3_eu,
    @publisher_id_bethesda);

INSERT INTO t_expansion_release_development (
    expansion_release_id,
    developer_id)
VALUES (
    @ex_rel_13_02_2013_ps3_eu,
    @developer_id_bethesda);

-- -----------------------------------------------------------------------------
-- Release: Legendary Edition, 04.06.2013, worldwide, MSWindows
-- -----------------------------------------------------------------------------

INSERT INTO t_release (
    release_name,
    release_date,
    release_region,
    release_description,
    game_id,
    platform_id)
VALUES (
    'The Elder Scrolls V: Skyrim - Legendary Edition',
    '2013-06-04',
    'Worldwide',
    'A compilation package called The Elder Scrolls V: Skyrim '
    '– Legendary Edition was released on June 4, 2013. It contains '
    'the version 1.9 patch and the three expansions, along with the main game.',
    @game_id,
    @platform_id_mswindows);

SET @rel_id_le_msw = (
    SELECT release_id
    FROM t_release
    WHERE game_id = @game_id
        AND platform_id = @platform_id_mswindows
        AND release_date = '2013-06-04'
        AND release_region = 'Worldwide');

INSERT INTO t_release_publishing (
    release_id,
    publisher_id)
VALUES (
    @rel_id_le_msw,
    @publisher_id_bethesda);

INSERT INTO t_release_development (
    release_id,
    developer_id)
VALUES (
    @rel_id_le_msw,
    @developer_id_bethesda);

INSERT INTO t_release_additional_content (
    release_id,
    expansion_id)
VALUES (
    @rel_id_le_msw,
    @ex_id_dawnguard);

INSERT INTO t_release_additional_content (
    release_id,
    expansion_id)
VALUES (
    @rel_id_le_msw,
    @ex_id_hearthfire);

INSERT INTO t_release_additional_content (
    release_id,
    expansion_id)
VALUES (
    @rel_id_le_msw,
    @ex_id_dawnguard);

-- -----------------------------------------------------------------------------
-- Release: Legendary Edition, 04.06.2013, worldwide, PS3
-- -----------------------------------------------------------------------------

INSERT INTO t_release (
    release_name,
    release_date,
    release_region,
    release_description,
    game_id,
    platform_id)
VALUES (
    'The Elder Scrolls V: Skyrim - Legendary Edition',
    '2013-06-04',
    'Worldwide',
    'A compilation package called The Elder Scrolls V: Skyrim '
    '– Legendary Edition was released on June 4, 2013. It contains '
    'the version 1.9 patch and the three expansions, along with the main game.',
    @game_id,
    @platform_id_ps3);

SET @rel_id_le_ps3 = (
    SELECT release_id
    FROM t_release
    WHERE game_id = @game_id
        AND platform_id = @platform_id_ps3
        AND release_date = '2013-06-04'
        AND release_region = 'Worldwide');

INSERT INTO t_release_publishing (
    release_id,
    publisher_id)
VALUES (
    @rel_id_le_ps3,
    @publisher_id_bethesda);

INSERT INTO t_release_development (
    release_id,
    developer_id)
VALUES (
    @rel_id_le_ps3,
    @developer_id_bethesda);

INSERT INTO t_release_additional_content (
    release_id,
    expansion_id)
VALUES (
    @rel_id_le_ps3,
    @ex_id_dawnguard);

INSERT INTO t_release_additional_content (
    release_id,
    expansion_id)
VALUES (
    @rel_id_le_ps3,
    @ex_id_hearthfire);

INSERT INTO t_release_additional_content (
    release_id,
    expansion_id)
VALUES (
    @rel_id_le_ps3,
    @ex_id_dragonborn);

-- -----------------------------------------------------------------------------
-- Release: Legendary Edition, 04.06.2013, worldwide, X360
-- -----------------------------------------------------------------------------

INSERT INTO t_release (
    release_name,
    release_date,
    release_region,
    release_description,
    game_id,
    platform_id)
VALUES (
    'The Elder Scrolls V: Skyrim - Legendary Edition',
    '2013-06-04',
    'Worldwide',
    'A compilation package called The Elder Scrolls V: Skyrim '
    '– Legendary Edition was released on June 4, 2013. It contains '
    'the version 1.9 patch and the three expansions, along with the main game.',
    @game_id,
    @platform_id_x360);

SET @rel_id_le_x360 = (
    SELECT release_id
    FROM t_release
    WHERE game_id = @game_id
        AND platform_id = @platform_id_x360
        AND release_date = '2013-06-04'
        AND release_region = 'Worldwide');

INSERT INTO t_release_publishing (
    release_id,
    publisher_id)
VALUES (
    @rel_id_le_x360,
    @publisher_id_bethesda);

INSERT INTO t_release_development (
    release_id,
    developer_id)
VALUES (
    @rel_id_le_x360,
    @developer_id_bethesda);

INSERT INTO t_release_additional_content (
    release_id,
    expansion_id)
VALUES (
    @rel_id_le_x360,
    @ex_id_dawnguard);

INSERT INTO t_release_additional_content (
    release_id,
    expansion_id)
VALUES (
    @rel_id_le_x360,
    @ex_id_hearthfire);

INSERT INTO t_release_additional_content (
    release_id,
    expansion_id)
VALUES (
    @rel_id_le_x360,
    @ex_id_dragonborn);

-- -----------------------------------------------------------------------------
-- Release: Special Edition, 28-10-2016, worldwide, MSWindows
-- -----------------------------------------------------------------------------

INSERT INTO t_release (
    release_name,
    release_date,
    release_region,
    release_description,
    game_id,
    platform_id)
VALUES (
    'The Elder Scrolls V: Skyrim - Special Edition',
    '2016-10-28',
    'Worldwide',
    'The Elder Scrolls V: Skyrim – Special Edition, a remaster for PlayStation '
	'4, Xbox One and Windows. It was released on October 28, 2016. Windows '
	'players who owned the original game and all of its downloadable content '
	'on Steam were offered the Special Edition for free.',
    @game_id,
    @platform_id_mswindows);

SET @rel_id_se_msw = (
    SELECT release_id
    FROM t_release
    WHERE game_id = @game_id
        AND platform_id = @platform_id_mswindows
        AND release_date = '2016-10-28'
        AND release_region = 'Worldwide');

INSERT INTO t_release_publishing (
    release_id,
    publisher_id)
VALUES (
    @rel_id_se_msw,
    @publisher_id_bethesda);

INSERT INTO t_release_development (
    release_id,
    developer_id)
VALUES (
    @rel_id_se_msw,
    @developer_id_bethesda);

INSERT INTO t_release_additional_content (
    release_id,
    expansion_id)
VALUES (
    @rel_id_se_msw,
    @ex_id_dawnguard);

INSERT INTO t_release_additional_content (
    release_id,
    expansion_id)
VALUES (
    @rel_id_se_msw,
    @ex_id_hearthfire);

INSERT INTO t_release_additional_content (
    release_id,
    expansion_id)
VALUES (
    @rel_id_se_msw,
    @ex_id_dragonborn);

-- -----------------------------------------------------------------------------
-- Release: Special Edition, 28-10-2016, worldwide, PS4
-- -----------------------------------------------------------------------------

INSERT INTO t_release (
    release_name,
    release_date,
    release_region,
    release_description,
    game_id,
    platform_id)
VALUES (
    'The Elder Scrolls V: Skyrim - Special Edition',
    '2016-10-28',
    'Worldwide',
    'The Elder Scrolls V: Skyrim – Special Edition, a remaster for PlayStation '
	'4, Xbox One and Windows. It was released on October 28, 2016. Windows '
	'players who owned the original game and all of its downloadable content '
	'on Steam were offered the Special Edition for free.',
    @game_id,
    @platform_id_ps4);

SET @rel_id_se_ps4 = (
    SELECT release_id
    FROM t_release
    WHERE game_id = @game_id
        AND platform_id = @platform_id_ps4
        AND release_date = '2016-10-28'
        AND release_region = 'Worldwide');

INSERT INTO t_release_publishing (
    release_id,
    publisher_id)
VALUES (
    @rel_id_se_ps4,
    @publisher_id_bethesda);

INSERT INTO t_release_development (
    release_id,
    developer_id)
VALUES (
    @rel_id_se_ps4,
    @developer_id_bethesda);

INSERT INTO t_release_additional_content (
    release_id,
    expansion_id)
VALUES (
    @rel_id_se_ps4,
    @ex_id_dawnguard);

INSERT INTO t_release_additional_content (
    release_id,
    expansion_id)
VALUES (
    @rel_id_se_ps4,
    @ex_id_hearthfire);

INSERT INTO t_release_additional_content (
    release_id,
    expansion_id)
VALUES (
    @rel_id_se_ps4,
    @ex_id_dragonborn);

-- -----------------------------------------------------------------------------
-- Release: Special Edition, 28-10-2016, worldwide, XBO
-- -----------------------------------------------------------------------------

INSERT INTO t_release (
    release_name,
    release_date,
    release_region,
    release_description,
    game_id,
    platform_id)
VALUES (
    'The Elder Scrolls V: Skyrim - Special Edition',
    '2016-10-28',
    'Worldwide',
    'The Elder Scrolls V: Skyrim – Special Edition, a remaster for PlayStation '
	'4, Xbox One and Windows. It was released on October 28, 2016. Windows '
	'players who owned the original game and all of its downloadable content '
	'on Steam were offered the Special Edition for free.',
    @game_id,
    @platform_id_xbo);

SET @rel_id_se_xbo = (
    SELECT release_id
    FROM t_release
    WHERE game_id = @game_id
        AND platform_id = @platform_id_xbo
        AND release_date = '2016-10-28'
        AND release_region = 'Worldwide');

INSERT INTO t_release_publishing (
    release_id,
    publisher_id)
VALUES (
    @rel_id_se_xbo,
    @publisher_id_bethesda);

INSERT INTO t_release_development (
    release_id,
    developer_id)
VALUES (
    @rel_id_se_xbo,
    @developer_id_bethesda);

INSERT INTO t_release_additional_content (
    release_id,
    expansion_id)
VALUES (
    @rel_id_se_xbo,
    @ex_id_dawnguard);

INSERT INTO t_release_additional_content (
    release_id,
    expansion_id)
VALUES (
    @rel_id_se_xbo,
    @ex_id_hearthfire);

INSERT INTO t_release_additional_content (
    release_id,
    expansion_id)
VALUES (
    @rel_id_se_xbo,
    @ex_id_dragonborn);