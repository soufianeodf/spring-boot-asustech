//package com.fst.asustech.primefaces;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.core.Ordered;
//import org.springframework.web.servlet.ViewResolver;
//import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
//import org.springframework.web.servlet.view.InternalResourceViewResolver;
//
//@Configuration
//public class WelcomePageRedirect implements WebMvcConfigurer {
//
//  @Override
//  public void addViewControllers(ViewControllerRegistry registry) {
//    registry.addViewController("/")
//        .setViewName("forward:/WEB-INF/index.xhtml");
//    registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
//  }
//  
//	@Bean
//	public ViewResolver getViewResolver(){
//	    InternalResourceViewResolver resolver = new InternalResourceViewResolver();
//	    resolver.setPrefix("/");
//	    resolver.setSuffix(".xhtml");
//	    return resolver;
//	}
//}