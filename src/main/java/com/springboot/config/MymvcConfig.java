package com.springboot.config;

import com.springboot.component.MyLocalResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * Created by zhang_htao on 2019/6/6.
 */
@Configuration
//@EnableWebMvc 注意在加下这个注解后springboot应用的自动配置会失效，这代表着这个类会全面接管springboot应用的webmvc自动配置
public class MymvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/test").setViewName("success");
    }

    @Bean
    public WebMvcConfigurer getSpringbootWebMvcConfig() {
        return new WebMvcConfigurer() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/login").setViewName("login");
            }

        };
    }

    @Bean
    public LocaleResolver localeResolver() {
        return new MyLocalResolver();
    }
}
