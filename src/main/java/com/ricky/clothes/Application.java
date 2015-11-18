package com.ricky.clothes;

import org.springframework.boot.builder.SpringApplicationBuilder;
import com.ricky.clothes.config.AppConfig;

public class Application{

    public static void main(String[] args) {
        new SpringApplicationBuilder()
                .sources(AppConfig.class)
                .showBanner(false)
                .build()
                .run(args);
    }

}
