package com.codestates.order.service;

import com.codestates.coffee.service.CoffeeService;
import com.codestates.exception.BusinessLogicException;
import com.codestates.exception.ExceptionCode;
import com.codestates.member.entity.Member;
import com.codestates.member.repository.MemberRepository;
import com.codestates.member.service.MemberService;
import com.codestates.order.entity.Order;
import com.codestates.order.repository.OrderRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class OrderService {
    private final OrderRepository orderRepository;
    private final MemberService memberService;

    public OrderService(OrderRepository orderRepository, MemberService memberService){
        this.orderRepository = orderRepository;
        this.memberService = memberService;
    }

    public Order createOrder(Order order) {
        memberService.findVerifiedMember(order.getMember().getMemberId());
        return orderRepository.save(order);
    }

    public Order findOrder(long orderId) {
        Order findOrder = findVerifiedOrder(orderId);
        return findOrder;
    }

    public Order updateOrder(Order order) {
        Order findOrder = findVerifiedOrder(order.getOrderId());

        Optional.ofNullable(order.getOrderStatus()).
                ifPresent(orderStatus -> findOrder.setOrderStatus(order.getOrderStatus()));
        findOrder.setModifiedAt(LocalDateTime.now());
        return orderRepository.save(findOrder);
    }

    public Page<Order> findOrders(int page, int size) {
        PageRequest pageRequest = PageRequest.of(page,size, Sort.by("orderId").descending());
        Page<Order> orders = orderRepository.findAll(pageRequest);
        return orders;
    }

    public void cancelOrder(long orderId) {
        Order findOrder = findVerifiedOrder(orderId);
        int step = findOrder.getOrderStatus().getStepNumber();

        if(step >=2){
            throw new BusinessLogicException(ExceptionCode.CANNOT_CHANGE_ORDER);
        }else{
            findOrder.setOrderStatus(Order.OrderStatus.ORDER_CANCEL);
            findOrder.setModifiedAt(LocalDateTime.now());
        }
        orderRepository.save(findOrder);
    }

    private Order findVerifiedOrder(long orderId) {
        Optional<Order> findOrder = orderRepository.findById(orderId);
        Order resultOrder = findOrder.orElseThrow(()-> new BusinessLogicException(ExceptionCode.ORDER_NOT_FOUND));

        return resultOrder;
    }
}
