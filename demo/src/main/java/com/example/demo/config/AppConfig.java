package com.example.demo.config;

import com.example.demo.service.CourseService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class AppConfig {

    @Bean
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    @Bean
    public CourseService courseService(RestTemplate restTemplate) {
        return new CourseService(restTemplate);
    }


}
