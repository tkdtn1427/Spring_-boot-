package com.codestates.order.entity;

import com.codestates.coffee.entity.CoffeeRef;
import com.codestates.member.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.jdbc.core.mapping.AggregateReference;
import org.springframework.data.relational.core.mapping.MappedCollection;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;
import java.util.LinkedHashSet;
import java.util.Set;

// TODO V10
@Getter
@Setter
//@AllArgsConstructor
//Set을 통해 기본생성자에서 각 필드에 값 주입
@Table("ORDERS")
public class Order {
    @Id
    private long orderId;

    // 테이블 외래키처럼 memberId를 추가해서 참조하도록 한다.
    private AggregateReference<Member, Long> memberId;

    @MappedCollection(idColumn = "ORDER_ID")
    private Set<CoffeeRef> orderCoffees = new LinkedHashSet<>(); //두 애그리거트 루트간의 정보를 이어주는 CoffeeRef 엔티티

    private OrderStatus orderStatus = OrderStatus.ORDER_REQUEST; //기본값으로 설정
    private LocalDateTime createdAt;

    public enum OrderStatus {
        ORDER_REQUEST(1, "주문 요청"),
        ORDER_CONFIRM(2, "주문 확정"),
        ORDER_COMPLETE(3, "주문 완료"),
        ORDER_CANCEL(4, "주문 취소");

        @Getter
        private int stepNumber;

        @Getter
        private String stepDescription;

        OrderStatus(int stepNumber, String stepDescription) {
            this.stepNumber = stepNumber;
            this.stepDescription = stepDescription;
        }
    }
}

