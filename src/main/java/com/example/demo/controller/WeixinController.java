package com.example.demo.controller;

import lombok.extern.slf4j.Slf4j;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/weixin")
@Slf4j
//public class WeixinController {
//    @GetMapping("/auth")
//    public void auth(){
//        log.info("进入auth方法");
//    }
//}
public class WeixinController {
    @GetMapping("/auth")
    public void auth(@RequestParam("code") String code){
        log.info("进入auth方法");
        log.info("code{}:",code);
        String url = "https://api.weixin.qq.com/sns/oauth2/access_token?appid=wx76a2010f27403be7&secret=d33b9a13d05a9f0617c4796d9c6bba5a&code="+code+"&grant_type=authorization_code";
        RestTemplate restTemplate = new RestTemplate();
        String response = restTemplate.getForObject(url,String.class);
        log.info("response={}",response);
    }
}
