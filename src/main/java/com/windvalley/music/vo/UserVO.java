package com.windvalley.music.vo;

import com.windvalley.music.common.base.enums.Gender;
import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class UserVO {
    private String id;

    private String userName;

    private String nickName;

//    private List<RoleVO> roles;
}
