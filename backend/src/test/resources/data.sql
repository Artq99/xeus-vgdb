-- Test platform #1
INSERT INTO t_platform (
        platform_id,
        platform_name)
    VALUES (
        1,
        'platform1');

-- Test game with 1 release
INSERT INTO t_game (
        game_id,
        title,
        game_description)
    VALUES (
        1,
        'title1',
        'description1');

INSERT INTO t_release (
        release_id,
        release_name,
        release_date,
        release_region,
        release_description,
        game_id,
        platform_id)
    VALUES (
        1,
        'rel_name1',
        '2010-01-01',
        'rel_region1',
        'rel_description1',
        1,
        1);

-- Test game with 2 releases
INSERT INTO t_game (
        game_id,
        title,
        game_description)
    VALUES (
        2,
        'title2',
        'description2');

INSERT INTO t_release (
        release_id,
        release_name,
        release_date,
        release_region,
        release_description,
        game_id,
        platform_id)
    VALUES (
        2,
        'rel_name2',
        '2010-01-01',
        'rel_region2',
        'rel_description2',
        2,
        1);

INSERT INTO t_release (
        release_id,
        release_name,
        release_date,
        release_region,
        release_description,
        game_id,
        platform_id)
    VALUES (
        3,
        'rel_name3',
        '2010-01-01',
        'rel_region3',
        'rel_description3',
        2,
        1);

-- Test game with no releases
INSERT INTO t_game (
        game_id,
        title,
        game_description)
    VALUES (
        3,
        'title3',
        'description3');
