package com.windvalley.music.vo;

import com.windvalley.music.common.base.enums.Gender;
import lombok.Data;

import java.util.List;

@Data
public class UserVO {
    private String id;

    private String userName;

    private String nickName;

    private Gender Gender;

    private Boolean locked;

    private Boolean enabled;

    private List<RoleVO> roles;
}
