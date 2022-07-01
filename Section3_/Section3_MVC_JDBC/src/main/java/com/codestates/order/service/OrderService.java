package com.codestates.order.service;

import com.codestates.coffee.repository.CoffeeRepository;
import com.codestates.coffee.service.CoffeeService;
import com.codestates.exception.BusinessLogicException;
import com.codestates.exception.ExceptionCode;
import com.codestates.member.repository.MemberRepository;
import com.codestates.member.service.MemberService;
import com.codestates.order.entity.Order;
import com.codestates.order.repository.OrderRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    final private OrderRepository orderRepository;
    final private CoffeeService coffeeService;
    final private MemberService memberService;

    public OrderService(OrderRepository orderRepository, CoffeeService coffeeService, MemberService memberService){
        this.orderRepository = orderRepository;
        this.coffeeService = coffeeService;
        this.memberService = memberService;
    }
    public Order createOrder(Order order) {
        memberService.findVerifiedMember(order.getMemberId().getId());

        order.getOrderCoffees().stream()
                .forEach(coffeeRef -> coffeeService.findVerifiedCoffee(coffeeRef.getCoffeeId()));

        return orderRepository.save(order);
    }

    public Order findOrder(long orderId) {
        return findVerifiedOrder(orderId);
    }

    // TODO 주문 상태 수정 메서드는 JPA 학습에서 추가됩니다.

    public List<Order> findOrders() {
        return (List<Order>) orderRepository.findAll();
    }

    public void cancelOrder(long orderId) {
        Order findOrder = findVerifiedOrder(orderId);
        int step = findOrder.getOrderStatus().getStepNumber();

        if(step >= 2){
            throw new BusinessLogicException(ExceptionCode.CANNOT_CHANGE_ORDER);
        }

        findOrder.setOrderStatus(Order.OrderStatus.ORDER_CANCEL);
        orderRepository.save(findOrder);
    }

    private Order findVerifiedOrder(long orderId){
        Optional<Order> findOrder = orderRepository.findById(orderId);
//        if(findOrder.isEmpty()){
//            throw new BusinessLogicException(ExceptionCode.ORDER_NOT_FOUND);
//        }
//
//        return findOrder.get();
        Order order = findOrder.orElseThrow(()->new BusinessLogicException(ExceptionCode.ORDER_NOT_FOUND));
        return order;
    }
}
