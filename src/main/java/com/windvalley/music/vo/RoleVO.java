package com.windvalley.music.vo;

import lombok.Data;

import java.util.Date;

@Data
public class RoleVO {
    private String id;

    private Date createTime;

    private Date updateTime;

    private String name;

    private String title;
}
