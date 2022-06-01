ALTER TABLE `user`
    ALTER `nickname` DROP DEFAULT;
ALTER TABLE `user`
    CHANGE COLUMN `nickname` `nickname` VARCHAR(64) NULL COMMENT '用户昵称' AFTER `username`;
