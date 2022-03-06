package com.windvalley.music.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.windvalley.music.common.base.model.BaseEntity;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
@TableName("role")
@ApiModel(value="role对象", description="规则")
public class Role extends BaseEntity {
    @ApiModelProperty(value = "角色实例")
    private String name;

    @ApiModelProperty(value = "角色标识")
    private String title;
}
