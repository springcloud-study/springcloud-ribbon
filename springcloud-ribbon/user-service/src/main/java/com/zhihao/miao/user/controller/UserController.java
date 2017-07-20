package com.zhihao.miao.user.controller;

import com.zhihao.miao.user.bean.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;


@RestController
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private DiscoveryClient client;

    @RequestMapping(value="/user",method = RequestMethod.GET)
    public String index(){
        ServiceInstance instance = client.getLocalServiceInstance();
        logger.info("/user,host:"+instance.getHost()+",service id:"+instance.getServiceId()+",port:"+instance.getPort());
        return "hello user, local time="+ LocalDateTime.now();
    }
}
