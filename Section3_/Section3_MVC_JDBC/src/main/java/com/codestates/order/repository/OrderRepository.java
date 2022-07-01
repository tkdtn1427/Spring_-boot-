package com.codestates.order.repository;

import com.codestates.order.entity.Order;
import org.springframework.data.repository.CrudRepository;

import javax.swing.text.html.Option;
import java.util.Optional;

public interface OrderRepository extends CrudRepository<Order, Long> {
}
