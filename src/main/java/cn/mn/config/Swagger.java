package cn.mn.config;

import io.swagger.annotations.Api;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import static springfox.documentation.builders.RequestHandlerSelectors.withClassAnnotation;

/**
 * Created by mengfajin on 2018/2/23.
 */
@Configuration
public class Swagger {
    @Bean
        public Docket docket() {
        return new Docket(DocumentationType.SWAGGER_2)
                .useDefaultResponseMessages(false)
                .apiInfo(myApiInfo())
                .select()
                .apis(withClassAnnotation(Api.class))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo myApiInfo() {
        return new ApiInfoBuilder()
                .title("MONA")
                .description("mona小程序后台API")
                .termsOfServiceUrl("-")
                .version("1.0")
                .build();
    }
}
