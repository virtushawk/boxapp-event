package com.virtushawk.boxappevent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class BoxappEventApplication {

    public static void main(String[] args) {
        SpringApplication.run(BoxappEventApplication.class, args);
    }

}
