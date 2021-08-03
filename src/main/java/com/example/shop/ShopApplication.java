package com.example.shop;

import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class ShopApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(ShopApplication.class)
                .headless(false)
                .web(WebApplicationType.NONE)
                .run(args);
    }
}