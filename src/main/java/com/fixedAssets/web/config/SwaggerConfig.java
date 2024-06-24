//package com.fixedAssets.web.config;
//
//import io.swagger.v3.oas.models.OpenAPI;
//import io.swagger.v3.oas.models.info.Info;
//import org.springdoc.core.GroupedOpenApi;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class SwaggerConfig {
//
//    @Bean
//    public GroupedOpenApi api() {
//        return GroupedOpenApi.builder()
//                .group("fixedAssets")
//                .packagesToScan("com.fixedAssets.web.controller")
//                .build();
//    }
//
//    @Bean
//    public OpenAPI customOpenAPI() {
//        return new OpenAPI()
//                .info(new Info()
//                        .title("Fixed Assets API")
//                        .version("1.0")
//                        .description("API documentation for Fixed Assets project"));
//    }
//}
