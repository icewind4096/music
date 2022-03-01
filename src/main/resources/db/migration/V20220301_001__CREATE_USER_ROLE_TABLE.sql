CREATE TABLE `user_role` (
    `user_id` VARCHAR(32) NOT NULL COMMENT '用户id',
    `role_id` VARCHAR(32) NOT NULL COMMENT '角色id',
    `create_time` DATETIME NOT NULL COMMENT '创建时间',
    `update_time` DATETIME NOT NULL COMMENT '更新时间'
) ENGINE=InnoDB COLLATE='utf8_general_ci' COMMENT '用户角色表';
