-- init File
insert into file(url, type, deleted, created_at, updated_at)
values ('http://1', 'IMAGE', 0, now(), now()),
       ('http://2', 'IMAGE', 0, now(), now()),
       ('http://3', 'IMAGE', 0, now(), now()),
       ('http://4', 'IMAGE', 0, now(), now()),
       ('http://5', 'IMAGE', 0, now(), now()),
       ('http://6', 'IMAGE', 0, now(), now()),
       ('http://7', 'IMAGE', 0, now(), now()),
       ('http://8', 'IMAGE', 0, now(), now()),
       ('http://9', 'IMAGE', 0, now(), now()),
       ('http://10', 'IMAGE', 0, now(), now());

-- init Menu
insert into menu(menu_token, title, ordering, top_menu_id, deleted, created_at, updated_at)
values ('menuToken_1', 'top1', 1, null, 0, now(), now()),
       ('menuToken_2', '1_sub1', 1, 1, 0, now(), now()),
       ('menuToken_3', '1_sub1_sub1', 1, 2, 0, now(), now()),
       ('menuToken_4', '1_sub1_sub2', 2, 2, 0, now(), now()),
       ('menuToken_5', '1_sub2', 2, 1, 0, now(), now()),
       ('menuToken_6', '1_sub3', 3, 1, 0, now(), now()),
       ('menuToken_7', 'top2', 2, null, 0, now(), now()),
       ('menuToken_8', '2_sub1', 1, 5, 0, now(), now()),
       ('menuToken_9', '2_sub2', 2, 5, 0, now(), now()),
       ('menuToken_10', '2_sub3', 3, 5, 0, now(), now()),
       ('menuToken_11', '2_sub4', 4, 5, 0, now(), now());

-- init Banner
insert into banner(ordering, menu_id, file_id, deleted, created_at, updated_at)
values (1, 1, 1, 0, now(), now()),
       (2, 1, 2, 0, now(), now()),
       (3, 1, 3, 0, now(), now());