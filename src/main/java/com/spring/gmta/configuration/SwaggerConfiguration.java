//package com.spring.gmta.configuration;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import springfox.documentation.builders.ApiInfoBuilder;
//import springfox.documentation.builders.PathSelectors;
//import springfox.documentation.builders.RequestHandlerSelectors;
//import springfox.documentation.spi.DocumentationType;
//import springfox.documentation.spring.web.plugins.ApiSelectorBuilder;
//import springfox.documentation.spring.web.plugins.Docket;
//import springfox.documentation.swagger2.annotations.EnableSwagger2;
//
//@Configuration
//@EnableSwagger2
//// swagger를 사용할 수 있게 선언을 해줍니다.
//public class SwaggerConfiguration {
//
//    @Bean
//    public Docket docket(){
//        ApiInfoBuilder apiInfo = new ApiInfoBuilder();
//        apiInfo.title("API 서버"); // swagger 적용 시 상단의 제목부분
//        apiInfo.description("API 서버 문서"); // swagger 적용 시 상단의 내용부분
//
//        Docket docket = new Docket(DocumentationType.SWAGGER_2);
//        docket.apiInfo(apiInfo.build());
//
//        ApiSelectorBuilder apis = docket.select().apis(RequestHandlerSelectors.basePackage("com.spring.gmta.mvc.controller"));
//        apis.paths(PathSelectors.ant("/**"));
//
//        return apis.build();
//
//    }
//
//}
