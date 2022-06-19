INSERT INTO `role` (id, name, title, create_time, update_time)
VALUES ('1533058450739773442', 'ROLE_USER', '普通用户', '2022-06-19', '2022-06-19');

INSERT INTO `role` (id, name, title, create_time, update_time)
VALUES ('1533058450739773443', 'ROLE_ADMIN', '超级管理员', '2022-06-19', '2022-06-19');

INSERT INTO `user` (`id`, `username`, `nickname`, `password`, `gender`, `locked`, `enabled`, `last_login_ip`, `last_login_time`, `create_time`, `update_time`)
VALUES ('1533058450739773443', 'icewind4096', 'icewind', 'dd132bb9b886e673c7bcbc847e66bdcf', '', 0, 1, '', '2022-06-19', '2022-06-19', '2022-06-19');

INSERT INTO `user_role` (`user_id`, `role_id`, `create_time`, `update_time`)
VALUES ('1533058450739773442', '1533058450739773443', '2022-06-19', '2022-06-19');

INSERT INTO `user_role` (`user_id`, `role_id`, `create_time`, `update_time`)
VALUES ('1533058450739773443', '1533058450739773442', '2022-06-19', '2022-06-19');