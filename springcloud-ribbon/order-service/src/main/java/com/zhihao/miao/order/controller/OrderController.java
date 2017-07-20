package com.zhihao.miao.order.controller;

import com.zhihao.miao.order.bean.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.converter.FormHttpMessageConverter;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import java.net.URI;
import java.util.*;

@RestController
@RequestMapping("/order")
public class OrderController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Value("${user.service.url}")
    private String userService;

    @Value("${pay.service.url}")
    private String payService;

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/user")
    public String user(@RequestParam String userId){
        String userresponse = restTemplate.getForEntity(userService+"/user",String.class).getBody();
        System.out.println(userresponse);
        return userresponse;
    }

    @GetMapping("/pay/queryMoneyByUserName")
    public String pay(@RequestParam String username){
        String payresponse = restTemplate.getForEntity(payService+"/pay/queryMoneyByUserName?username={1}",String.class,new Object[]{username}).getBody();
        System.out.println(payresponse);
        return payresponse;
    }








}
