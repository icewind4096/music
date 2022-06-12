package com.windvalley.music.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@Data
@ApiModel(value="用户查询对象", description="用于用户条件查询")
public class UserQueryVO {
    @ApiModelProperty(value = "用户姓名")
    private String userName;
}
