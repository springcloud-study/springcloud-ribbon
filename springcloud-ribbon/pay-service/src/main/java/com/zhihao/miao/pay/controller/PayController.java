package com.zhihao.miao.pay.controller;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

@RestController
@RequestMapping("/pay")
public class PayController {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @GetMapping("/queryMoneyByUserName")
    public String queryMoneyByUserName(@RequestParam String username){
        logger.info("userID: "+username);
        return "hi, 您还剩下"+ new Random().nextInt(10000)+"元";
    }
}
