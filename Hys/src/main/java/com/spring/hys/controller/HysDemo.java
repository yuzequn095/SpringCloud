package com.spring.hys.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.hys.ResultBody;

import lombok.extern.slf4j.Slf4j; 

@Controller
@Slf4j //private  final Logger logger = LoggerFactory.getLogger(XXX.class); 
public class HysDemo {
	
	@RequestMapping(value = "/toHystrixTest", method=RequestMethod.GET)
	public String toHystrixTest(@RequestParam String testName){
		log.info("收到请求，开始阻塞 ヽ(✿ﾟ▽ﾟ)ノ");
		
		try{
			Thread.sleep(10000);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		
		log.info("完成阻塞，返回请求 ╰(*°▽°*)╯");
		return "你好，" + testName + "。我是API HystrixTest，Hystrix监控中 (๑•̀ㅂ•́)و✧";
	}
	
}
