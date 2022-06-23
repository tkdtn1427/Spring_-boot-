package com.example.cmarket.Controller;

import com.example.cmarket.Order.Order;
import com.example.cmarket.Order.OrderService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class OrderController {
    private final OrderService orderService;

    public OrderController(OrderService orderService){
        this.orderService = orderService;
    }

    @GetMapping(value = "/order")
    public String Order(){
        Order order = orderService.createOrder(0L,"coffee",12000);
        System.out.println(order.getItemPrice());
        return "주문완료";
    }
}

//실습내용