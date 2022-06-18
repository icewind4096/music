package com.windvalley.music.common.base.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.oas.annotations.EnableOpenApi;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;
import java.util.List;

@Configuration
@EnableOpenApi
public class Swagger3Config {
    //固定产生在 http://localhost:8080/swagger-ui/

    //接口分组，位于swagger-ui.html的左上方下拉列表

    //前台接口
    @Bean
    public Docket webAPIConfig(){
        return new Docket(DocumentationType.OAS_30)
                .groupName("front")
                .apiInfo(webApiInfo()).enable(true)
                .securityContexts(Collections.singletonList(securityContext()))
                .securitySchemes(Collections.singletonList(apiKey()))
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.windvalley.music.controller.front")) // 设置扫描路径
                .paths(PathSelectors.regex("/api/.*"))  //只要api路径下的接口
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
        return new Docket(DocumentationType.OAS_30)
                .groupName("back")
                .apiInfo(adminAPIInfo())
                .securityContexts(Collections.singletonList(securityContext()))
                .securitySchemes(Collections.singletonList(apiKey()))
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.windvalley.music.controller.back")) // 设置扫描路径
                .paths(PathSelectors.regex("/admin/.*"))//只要admin路径下的接口
                .build();
    }

    private ApiKey apiKey() {
        return new ApiKey("JWT", "Authorization", "header");
    }

    private SecurityContext securityContext() {
        return SecurityContext.builder().securityReferences(defaultAuth()).build();
    }

    private List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authorizationScopes = new AuthorizationScope[1];
        authorizationScopes[0] = authorizationScope;
        return Collections.singletonList(new SecurityReference("JWT", authorizationScopes));
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
