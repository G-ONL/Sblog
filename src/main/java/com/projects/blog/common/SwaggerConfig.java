package com.projects.blog.common;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

  @Bean
  public Docket api() {
    Docket docket = new Docket(DocumentationType.SWAGGER_2) //SWAGGER2의 도켓을 만드는 것
        .pathMapping("/") //맵핑 주소
        .useDefaultResponseMessages(false); //Default 응답 값 설정 여부

    docket = docket
        .select()
        .apis(RequestHandlerSelectors.any())//적용될 패키지 정보 (any=> 모든 컨트롤러 패키지에 적용)
        .paths(PathSelectors.ant("/**")) //어떤 패스 정보에 적용 => /**  모든 정보
        .build();

    return docket;
  }
}
