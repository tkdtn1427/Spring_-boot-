//package com.example.cmarket;
//
//import com.example.cmarket.singleton.SingletonService;
//import com.example.cmarket.user.UserService;
//import org.springframework.context.annotation.*;
//
//public class SingletonApp {
////    static AppConfig appConfig = new AppConfig();
//    static AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
//
////    static SingletonService singletonService1 = SingletonService.getInstance();
////    static SingletonService signletonService2 = SingletonService.getInstance();
//
////    static  UserService userService1 = appConfig.userService();
////    static  UserService userService2 = appConfig.userService();
//
//    static UserService userService1 = ac.getBean("userService",UserService.class);
//    static UserService userService2 = ac.getBean("userService",UserService.class);
//
//    public static void main(String[] args){
//        System.out.println("userService1 : " + userService1);
//        System.out.println("userService2 : " + userService2);
//    }
//}