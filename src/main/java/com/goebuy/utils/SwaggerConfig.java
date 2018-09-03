//package com.goebuy.utils;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.EnableWebMvc;
//import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
//
//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.builders.PathSelectors;
//import  springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.service.ApiInfo;
//import springfox.documentation.service.Contact;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
//
//@Configuration
//@EnableSwagger2
//@EnableWebMvc
////@ComponentScan(basePackages = {"com.foriseland.fsoa.pay.controller"})
//public class SwaggerConfig extends WebMvcConfigurationSupport {
//	 @Bean
//	    public Docket productApi() {
//	        return new Docket(DocumentationType.SWAGGER_2)
//	                .select()
//	                .apis(RequestHandlerSelectors.basePackage("guru.springframework.controllers"))
////	                .paths(regex("/product.*"))
//	                .build()
//	                .apiInfo(metaData());
//	    }
//	    private ApiInfo metaData() {
//	        return new ApiInfoBuilder()
//	                .title("Spring Boot REST API")
//	                .description("\"Spring Boot REST API for Online Store\"")
//	                .version("1.0.0")
//	                .license("Apache License Version 2.0")
//	                .licenseUrl("https://www.apache.org/licenses/LICENSE-2.0\"")
//	                .contact(new Contact("John Thompson", "https://springframework.guru/about/", "john@springfrmework.guru"))
//	                .build();
//	    }
//	    @Override
//	    protected void addResourceHandlers(ResourceHandlerRegistry registry) {
//	        registry.addResourceHandler("swagger-ui.html")
//	                .addResourceLocations("classpath:/META-INF/resources/");
//
//	        registry.addResourceHandler("/webjars/**")
//	                .addResourceLocations("classpath:/META-INF/resources/webjars/");
//	    }
////	 @Bean
////	    public Docket customDocket() {
////	        return new Docket(DocumentationType.SWAGGER_2)
////	                .apiInfo(apiInfo())      
////	                .select()
////	                .apis(RequestHandlerSelectors.any())
////	                .paths(PathSelectors.any())
////	                .build();
////	    }
//// 
////	    private ApiInfo apiInfo() {
////	        Contact contact = new Contact("支付组", "", "");
////	        return new ApiInfoBuilder()
////	                .title("支付API接口")
////	                .description("支付API接口")
////	                .contact(contact)
////	                .version("1.1.0")
////	                .build();
////	    }
//}