package com.windvalley.music.vo;

import com.windvalley.music.common.base.enums.Gender;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class UserVO {
    private String id;

    private Date createTime;

    private Date updateTime;

    private String userName;

    private String nickName;

    private String password;

    private Gender gender;

    private Boolean locked;

    private Boolean enabled;

    private String lastLoginIp;

    private Date lastLoginTime;

    private List<RoleVO> roles;
}
