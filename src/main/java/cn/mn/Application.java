package cn.mn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.support.SpringBootServletInitializer;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by mengfajin on 2018/3/8.
 */
@SpringBootApplication
@EnableSwagger2
public class Application extends SpringBootServletInitializer {
    public static void main(String[] args)  {
        SpringApplication.run(Application.class,args);
    }
}
