package com.goebuy.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger.web.UiConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by luodejin on 2018/10/14.
 */
@EnableSwagger2
@Configuration
public class SwaggerConfig {
    @Bean
    public Docket getApiInfo() {
        return new Docket(DocumentationType.SWAGGER_2) /*指定swagger版本*/
                .groupName("goebuy api")
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .apiInfo(outApiInfo());

    }

    private ApiInfo outApiInfo() {
        return new ApiInfo(
                "GoEBuy", // title 标题
                "API接口文档", // description 描述 标题下
                "1.0.0", // version 版本号 自定义
                "https://www.cnblogs.com/linhai-free/", // termsOfServiceUrl 许可人URL
                new Contact("luodejn","https://www.cnblogs.com/linhai-free/","luodejin2011@163.com"), // contact 联系方式实体类
                "Apache 2.0", // licence 许可证
                "http://www.apache.org/licenses/LICENSE-2.0.html" // licence url 许可URL
        );

    }

    @Bean
    public UiConfiguration getUiConfig() {
        return new UiConfiguration(
                null,// url,暂不用
                "none",       // docExpansion          => none | list
                "alpha",      // apiSorter             => alpha
                "schema",     // defaultModelRendering => schema
                UiConfiguration.Constants.DEFAULT_SUBMIT_METHODS,
                false,        // enableJsonEditor      => true | false
                true);        // showRequestHeaders    => true | false
    }


}
