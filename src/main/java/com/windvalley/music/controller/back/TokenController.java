package com.windvalley.music.controller.back;

import com.windvalley.music.dto.TokenCreateRequest;
import com.windvalley.music.service.IUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(description = "获得token")
@RequestMapping("/tokens")
@CrossOrigin
@Slf4j
public class TokenController {
    @Autowired
    IUserService userService;

    @ApiOperation("根据用户名和密码获得token")
    @PostMapping("")
    public String create(@Validated @ApiParam(value = "用户登录信息", required = true) @RequestBody TokenCreateRequest tokenCreateRequest){
        return userService.createToken(tokenCreateRequest.getUserName(), tokenCreateRequest.getPassword());
    }
}
