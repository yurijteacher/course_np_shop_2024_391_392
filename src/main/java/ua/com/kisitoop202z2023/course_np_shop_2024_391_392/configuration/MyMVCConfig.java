package ua.com.kisitoop202z2023.course_np_shop_2024_391_392.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyMVCConfig implements WebMvcConfigurer {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry reg) {
        reg
                .addResourceHandler("/static/**")
                .addResourceLocations("classpath:/static/");
    }
}
