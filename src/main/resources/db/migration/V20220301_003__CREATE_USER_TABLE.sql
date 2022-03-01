CREATE TABLE `user` (
    `id` VARCHAR(32) NOT NULL COMMENT '用户id',
    `username` VARCHAR(64) NOT NULL COMMENT '用户名',
    `nickname` VARCHAR(64) NOT NULL COMMENT '用户昵称',
    `password` VARCHAR(64) NOT NULL COMMENT '密码',
    `gender` VARCHAR(255) NOT NULL COMMENT '性别',
    `locked` TINYINT(4) NOT NULL DEFAULT '0' COMMENT '是否锁定 1-是 0 - 否',
    `enabled` TINYINT(4) NOT NULL DEFAULT '0' COMMENT '是否可用 1-是 0 - 否',
    `last_login_ip` VARCHAR(64) NULL DEFAULT NULL COMMENT '最后登录IP',
    `last_login_time` DATETIME NULL DEFAULT NULL COMMENT '最后登录IP',
    `create_time` DATETIME NOT NULL COMMENT '创建时间',
    `update_time` DATETIME NOT NULL COMMENT '更新时间',
    PRIMARY KEY (`id`),
    UNIQUE INDEX `username` (`username`)
) ENGINE=InnoDB COLLATE='utf8_general_ci' COMMENT '用户表';
