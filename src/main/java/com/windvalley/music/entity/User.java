package com.windvalley.music.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.windvalley.music.common.base.enums.Gender;
import com.windvalley.music.common.base.model.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("user")
@ApiModel(value="user对象", description="用户")
public class User extends BaseEntity {
    @ApiModelProperty(value = "用户名称")
    @TableField(value = "username")
    private String userName;

    @ApiModelProperty(value = "用户名称")
    @TableField(value = "nickname")
    private String nickName;

    @ApiModelProperty(value = "密码")
    private String password;

    @ApiModelProperty(value = "性别")
    @Enumerated(EnumType.STRING)        //虽然是枚举，但是保存到数据库里面是以枚举的字符串保存
    private Gender gender;

    @ApiModelProperty(value = "锁定")
    private Boolean locked;

    @ApiModelProperty(value = "是否可用")
    private Boolean enabled;

    @ApiModelProperty(value = "最后登录IP")
    private String lastLoginIp;

    @ApiModelProperty(value = "最后登录时间", example = "2022-3-6")
    @JsonFormat(timezone = "GMT+8", pattern = "yyyy-MM-dd")
    private Date lastLoginTime;
}
