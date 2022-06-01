package com.windvalley.music;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@SpringBootApplication(exclude = {SecurityAutoConfiguration.class})
public class MusicApplication {

    public static void main(String[] args) {
        SpringApplication.run(MusicApplication.class, args);
    }

}
