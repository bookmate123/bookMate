package cn.sbtp.config;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class ResourcesConfig extends WebMvcConfigurerAdapter {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/bookImages/**").addResourceLocations("file:E:\\bookMate\\src\\main\\resources\\images\\bookImages");
        registry.addResourceHandler("/icons/**").addResourceLocations("file:E:\\bookMate\\src\\main\\resources\\images\\icons");
    }
}