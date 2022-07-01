package com.codestates.coffee.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;

@Getter
@Setter
@AllArgsConstructor
public class Coffee {
    @Id
    private long coffeeId;
    private String korName;
    private String engName;
    private int price;
    private String coffeeCode; //커피 중복 등록을 체크하기 위한 CoffeeCode 멤버
}
