package com.chiste.novel;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;
import tk.mybatis.spring.annotation.MapperScan;

@SpringBootApplication(exclude = {
        org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class
},scanBasePackages={"com.chiste.novel"})
@MapperScan({"com.chiste.novel.mapper"})
@EnableSwagger2
public class NovelApplication {

    public static void main(String[] args) {
        SpringApplication.run(NovelApplication.class, args);
    }

}
