package com.Yuriel;

import javax.servlet.Filter;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;

import com.Yuriel.filter.SampleFilter;

// SpringBoot용 Application 실행 파일

@SpringBootApplication
@MapperScan(value = {"com.Yuriel.mapper"} )
public class BootApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootApplication.class, args);
	}
	
	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Bean
	public FilterRegistrationBean someFilterRegistration() {
		FilterRegistrationBean registration = new FilterRegistrationBean<>();
		registration.setFilter(getFilter());
		registration.addUrlPatterns("/test/*");
		
		registration.setName("sampleFilter");
		return registration;
	}
	public Filter getFilter() {
		return new SampleFilter();
	}


}
