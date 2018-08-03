package com.e.order.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

/**
 * @program: HystrixController
 * @description:
 * @author: shiqzhang
 * @date: 2018 Aug 02
 */

@RestController
public class HystrixController {

    @GetMapping("/getProductInfoList")
    public String getProductInfoList() {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForObject("http://127.0.0.1:8005/product/listForOrder",
                                    Arrays.asList("157875196366160022"),
                                    String.class);
    }



}
