package com.springboot;

import com.springboot.component.MyLocalResolver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;

import java.util.Locale;

@SpringBootApplication
public class RestfulcrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(RestfulcrudApplication.class, args);
	}

	@Bean(name = "testViewResolver")
	public ViewResolver myViewResolver() {
		return new MyviewResolver();
	}

	private  static	 class MyviewResolver implements  ViewResolver {
		@Override
		public View resolveViewName(String viewName, Locale locale) throws Exception {
			return null;
		}
	}

}
