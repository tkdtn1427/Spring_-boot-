package com.codestates.coffee;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

//@RestController
//@RequestMapping(value = "/v1/coffees", produces = {MediaType.APPLICATION_JSON_VALUE})
//public class CoffeeController {
//    @PostMapping
//    public String postCoffee(@RequestParam("endName") String endName,
//                             @RequestParam("korName") String korName,
//                             @RequestParam("price") long price){
//        System.out.println("# endName : " + endName);
//        System.out.println("# korName : " + korName);
//        System.out.println("# price : " + price);
//
//        String response =
//                "{\"" +
//                        "email\":\""+endName+"\"," +
//                        "\"name\":\""+korName+"\",\"" +
//                        "phone\":\"" + price+
//                        "\"}";
//
//        return response;
//    }
//
//    @GetMapping("/{coffee-id}")
//    public String getCoffee(@PathVariable("coffee-id") long coffeeId){
//        System.out.println("# coffeeId : " + coffeeId);
//
//        return null;
//    }
//
//    @GetMapping
//    public String getCoffees(){
//        System.out.println("# get Coffees");
//
//        return null;
//    }
//}
//==============================================================================


@RestController
@RequestMapping(value = "/v1/coffees")
public class CoffeeController {
    @PostMapping
    public ResponseEntity postCoffee(@RequestParam("endName") String endName,
                                     @RequestParam("korName") String korName,
                                     @RequestParam("price") Long price){
        Map<String, Object> map = new HashMap<>();
        map.put("endName",endName);
        map.put("korName",korName);
        map.put("price",price);

        return new ResponseEntity<>(map, HttpStatus.CREATED);
    }

    @GetMapping("/{coffee-id}")
    public ResponseEntity getCoffee(@PathVariable("coffee-id") long coffeeId){
        System.out.println("# coffeeId : " + coffeeId);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity getCoffees(){
        System.out.println("# get Coffees");

        return new ResponseEntity<>(HttpStatus.OK);
    }
}