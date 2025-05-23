package com.kh.reactbackend.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/uploadFile/**")
                .addResourceLocations("file:C:\\workspace\\11_SpringBoot\\reactbackend\\src\\main\\resources\\static\\uploadFile\\");
    }
}
