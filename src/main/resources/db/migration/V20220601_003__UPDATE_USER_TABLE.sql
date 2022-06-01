ALTER TABLE `user`
    CHANGE COLUMN `nickname` `nickname` VARCHAR(64) NULL DEFAULT NULL COMMENT '用户昵称' AFTER `username`;
