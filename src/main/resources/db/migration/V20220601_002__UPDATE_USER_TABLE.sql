ALTER TABLE `user`
    ALTER `nickname` DROP DEFAULT;
ALTER TABLE `user`
    CHANGE COLUMN `gender` `gender` VARCHAR(16) NULL COMMENT '性别' AFTER `password`;
