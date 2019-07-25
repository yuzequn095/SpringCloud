package com.spring.num.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.num.ResultBody;

import lombok.extern.slf4j.Slf4j; 

@Controller
@Slf4j //private  final Logger logger = LoggerFactory.getLogger(XXX.class); 
public class NumDemo {
	
	@Value("${server.port}")
	String port;
	
	@RequestMapping(value = "/getUserId", method = RequestMethod.GET)
	@ResponseBody
	public ResultBody getUserId(@RequestParam String userId){
		ResultBody rb = new ResultBody();
		rb.setValue(userId);
		return rb;
	}
	
	@RequestMapping(value = "/toDemoPage")
	public String toDemoPage(HttpServletRequest request){
		log.info("端口: " + request.getLocalPort());
		return "uindex.html";
	}
	
	@ResponseBody
	@RequestMapping(value = "/toDemoResBody")
	public String toDemoResBody(@RequestParam(value = "name", defaultValue = "zequn") String name){
		return "您好，" + name + ", 您此次访问的web端口为：" + port;
	}
	
	@RequestMapping(value = "/udemo.html")
	public String toDemoPageBydemo(HttpServletRequest request){
		log.info("端口:" + request.getLocalPort());
		return "uindex.html";
	}
	
	@SuppressWarnings("static-access")
	@RequestMapping(value = "/toRibbonDemo")
	public String toRibbonDemo(HttpServletRequest request){
		log.info("端口:" + request.getLocalPort());
		try{
			Thread.currentThread().sleep(10000);
		}catch(InterruptedException e){
			e.printStackTrace();
		}
		log.info("开始跳转：" + request.getLocalPort());
		return "uindex.html";
	}
}
