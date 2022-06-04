package com.windvalley.music.common.base.config;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableSwagger2
public class Swagger2Config {
    //固定产生在 http://localhost:8080/swagger-ui.html

    //接口分组，位于swagger-ui.html的左上方下拉列表

    //前台接口
    @Bean
    public Docket webAPIConfig(){
        List<Parameter> parameters = new ArrayList<>();
        //给springsecurity框架做配套，要不在测试的时候，头部缺JWT的认证字符串，导致无法测试
        parameters.add(new ParameterBuilder()
                .name("Authorization")
                .description("认证")
                .modelRef(new ModelRef("string"))
                .parameterType("header")
                .required(false)
                .build());
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("webAPI")
                //文档标题 文档介绍 作者 版本
                .apiInfo(webApiInfo())
                .globalOperationParameters(parameters)
                .select()
                .paths(Predicates.and(PathSelectors.regex("/api/.*"))) //只要api路径下的接口
                .build();
    }

    private ApiInfo webApiInfo() {
        return new ApiInfoBuilder()
                .title("网站API文档")
                .description("文档描述了网站的前台API接口定义")
                .version("1.00")
                .contact(new Contact("wangjian", "windvalley.com", "wangjian@outlook.com"))
                .build();
    }

    //后台接口
    @Bean
    public Docket adminAPIConfig(){
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("admin")
                .apiInfo(adminAPIInfo())
                .select()
                .paths(Predicates.and(PathSelectors.regex("/admin/.*")))//只要admin路径下的接口
                .build();
    }

    private ApiInfo adminAPIInfo() {
        return new ApiInfoBuilder()
                .title("网站后台管理系统文档")
                .description("文档描述了网站的后台接口定义")
                .version("1.00")
                .contact(new Contact("wangjian", "windvalley.com", "wangjian@outlook.com"))
                .build();
    }
}
