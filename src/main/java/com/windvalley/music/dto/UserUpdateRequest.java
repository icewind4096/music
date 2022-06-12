package com.windvalley.music.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Data
public class UserUpdateRequest {
    @NotBlank(message="用户名不可以为空")
    @Size(min = 6, max = 16, message="用户名长度在6个字符到16个字符之间")
    private String userName;

    private String nickName;

    private String gender;
}
