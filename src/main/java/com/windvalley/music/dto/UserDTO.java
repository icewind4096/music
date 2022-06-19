package com.windvalley.music.dto;

import com.windvalley.music.common.base.enums.Gender;
import lombok.Data;

import java.util.Date;

@Data
public class UserDTO {
    private String id;

    private String userName;

    private String nickName;

    private String password;

    private Gender gender;

    private Boolean locked;

    private Boolean enabled;

    private String lastLoginIp;

    private Date lastLoginTime;

//    private List<RoleVO> roles;
}
