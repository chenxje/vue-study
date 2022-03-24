//package com.example.demo.security.config;
//
//import com.example.demo.mapper.UserMapper;
//import com.example.demo.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.context.annotation.Bean;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//import org.springframework.security.crypto.password.PasswordEncoder;
//
//@EnableWebSecurity
//public class WebSecurityConfiguration extends WebSecurityConfigurerAdapter {
//
//    @Autowired
//    private UserMapper userMapper; //修改了setting>Inspections>Spring>Spring Core>Code>Autowiring for Bean Class>Error=>Waring
//
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }
//
////    @Bean
////    public UserService userService(){ return new }
//
////    @Bean
////    public AuthenticationTokenFilter authenticationTokenFilterBean() throws Exception {
////        return new AuthenticationTokenFilter();
////    }
//}
