//package com.deepsoft.haolifa.config;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
//import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
//import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
//
///**
// * @author zhaozhihong
// * @create 2018-04-27 13:54
// * @desc
// **/
//@Configuration
//public class WebMvcConfig extends WebMvcConfigurerAdapter {
//    public void addInterceptors(InterceptorRegistry registry) {
//        // addPathPatterns 用于添加拦截规则
//        // excludePathPatterns 用户排除拦截
//        registry.addInterceptor(new CustomInterceptor1())
//                .addPathPatterns("/**");
//        registry.addInterceptor(new CustomInterceptor2())
//                .excludePathPatterns("/error1/**")
//                .addPathPatterns("/random2/**");
//        super.addInterceptors(registry);
//    }
////    @Override
////    public void addViewControllers(ViewControllerRegistry registry) {
////        registry.addViewController("/login").setViewName("/login");
////    }
//}
