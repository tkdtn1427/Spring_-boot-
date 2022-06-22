//package com.example.cmarket;
//
//import com.example.cmarket.Order.Order;
//import com.example.cmarket.Order.OrderService;
//import com.example.cmarket.user.User;
//import com.example.cmarket.user.UserGrade;
//import com.example.cmarket.user.UserService;
//import org.springframework.context.ApplicationContext;
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//
//public class OrderApp {
//    public static void main(String[] args) {
//        ApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
//        UserService userService = ac.getBean(UserService.class);
//        OrderService orderService = ac.getBean(OrderService.class);
//
//        Long userId=0L;
//        User user = new User(userId,"kimcoding",UserGrade.GRADE_1);
//        userService.signup(user);
//
//        Order order = orderService.createOrder(userId,"Coffee",5000);
//
//        System.out.println("Order : " + order);
//    }
//}
