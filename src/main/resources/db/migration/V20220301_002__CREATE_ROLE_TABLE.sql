CREATE TABLE `role` (
    `id` VARCHAR(32) NOT NULL COMMENT '角色ID',
    `name` VARCHAR(128) NOT NULL COMMENT '角色名称',
    `title` VARCHAR(128) NOT NULL COMMENT '角色标识',
    `create_time` DATETIME NOT NULL COMMENT '创建时间',
    `update_time` DATETIME NOT NULL COMMENT '修改时间',
    PRIMARY KEY (`id`)
) ENGINE=InnoDB COLLATE='utf8_general_ci' COMMENT='角色表';
