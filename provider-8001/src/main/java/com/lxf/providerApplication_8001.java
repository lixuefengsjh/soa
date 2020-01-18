package com.lxf;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.jms.annotation.EnableJms;

@SpringBootApplication
@EnableJms
public class providerApplication_8001 {

    public static void main(String[] args) {
        SpringApplication.run(providerApplication_8001.class, args);
    }
}
