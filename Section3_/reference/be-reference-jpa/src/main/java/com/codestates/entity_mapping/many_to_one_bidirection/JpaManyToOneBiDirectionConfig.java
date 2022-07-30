package com.codestates.entity_mapping.many_to_one_bidirection;

import org.aspectj.weaver.ast.Or;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.util.List;

@Profile("many-to-one-bi")
@EntityScan(basePackageClasses = {JpaManyToOneBiDirectionConfig.class})
@Configuration
public class JpaManyToOneBiDirectionConfig {
    private EntityManager em;
    private EntityTransaction tx;

    @Bean
    public CommandLineRunner testJpaManyToOneRunner(EntityManagerFactory emFactory) {
        this.em = emFactory.createEntityManager();
        this.tx = em.getTransaction();
        System.out.println("# Active Profile: many-to-one-bi");

        return args -> {
//            mappingManyToOneBiDirection();
            fetchTest();
        };
    }

    private void mappingManyToOneBiDirection() {
        tx.begin();
        Member member = new Member("hgd@gmail.com", "Hong Gil Dong",
                "010-1111-1111");
        Order order = new Order();
        member.addOrder(order);
        order.addMember(member);

        em.persist(member);

        System.out.println("member persisted: -------------------------------");


        em.persist(order);

        System.out.println("order persisted: ------------------------------");

        tx.commit();

        System.out.println("committed: ------------------------------");

        Member findMember = em.find(Member.class, 1L);

        // 이제 주문한 회원의 회원 정보를 통해 주문 정보를 가져올 수 있다.
        findMember
                .getOrders()
                .stream()
                .forEach(findOrder -> {
                    System.out.println("findOrder: " +
                            findOrder.getOrderId() + ", "
                            + findOrder.getOrderStatus());
                });

    }

    public void fetchTest() throws InterruptedException{
        tx.begin();
        Member member = new Member("hgd@gmail.com","Saongsoo", "010-2006-1825");
        Order order = new Order();
        member.addOrder(order);

        order.addMember(member);

        em.persist(member);
        em.persist(order);

        tx.commit();

        em.clear();

        Member findMember = em.find(Member.class, member.getMemberId());

        List<Order> orders = findMember.getOrders();

        System.out.println("=====================");
        Thread.sleep(5000L);

        orders.stream().forEach(order1 -> System.out.println(order1.getOrderId()));
    }
}

