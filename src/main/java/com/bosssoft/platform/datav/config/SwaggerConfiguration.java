package com.bosssoft.platform.datav.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfiguration {
    @Bean
    public Docket createRestApi() {

        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
            .apis(RequestHandlerSelectors.basePackage("com.bosssoft.platform.datav")).paths(PathSelectors.any()).build();

    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("datav 应用接口API").description("datav RESTful API使用文档")
            .termsOfServiceUrl("http://www.bosssoft.com.cn").version("1.0").build();
    }

}
