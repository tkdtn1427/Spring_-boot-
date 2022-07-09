package com.codestates.coffee.repository;

import com.codestates.coffee.entity.Coffee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.Optional;

public interface CoffeeRepository extends JpaRepository<Coffee, Long> {
    Optional<Coffee> findByCoffeeCode(String coffeeCode);

//    @Query(value = "FROM Coffee c WHERE c.coffeeId = :coffeeId")  // (2-1)
//    @Query(value = "SELECT * FROM COFFEE WHERE coffee_Id = :coffeeId", (2-2)

    @Query(value = "SELECT c FROM Coffee c WHERE c.coffeeID = :coffeeId")
    Optional<Coffee> findByCoffee(long coffeeId);
}
