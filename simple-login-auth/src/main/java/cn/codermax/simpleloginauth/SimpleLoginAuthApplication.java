package cn.codermax.simpleloginauth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;

@SpringBootApplication
public class SimpleLoginAuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(SimpleLoginAuthApplication.class, args);
    }

}
