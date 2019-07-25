package com.spring.web.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.web.client.HysClient;
import com.spring.web.client.NumClient;
import com.spring.web.client.UserClient;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j // private final Logger logger = LoggerFactory.getLogger(XXX.class);
public class WebDemo {

	@Resource
	private UserClient user;
	
	@Resource
	private NumClient num;
	
	@Resource
	private HysClient hys;
	
	@Value("${server.port}")
	String port;

	@RequestMapping(value = "/toTestPage", method = RequestMethod.GET)
	@ResponseBody
	public String toTestPage(@RequestParam(value = "testName") String testName) {
		return hys.toHystrixTest(testName);
	}
	
	@RequestMapping(value = "/toDemoPage")
	public String toDemoPage(HttpServletRequest request) {
		log.info("端口: " + request.getLocalPort());
		return "index.html";
	}

	@GetMapping(value = "/toDemoResBody")
	@ResponseBody
	public String toDemoResBody(@RequestParam(value = "userName") String userName, @RequestParam(value = "userId") String userId) {
		return "您好, " + port + ", 您此次访问的web端口为：" + port + "。 我从服务器请求到的结果是: 姓名-" + user.getUserName(userName).getName() + " 编号-" + num.getUserId(userId).getValue();
	}

	@RequestMapping(value = "/demo.html")
	public String toDemoPageBydemo(HttpServletRequest request) {
		log.info("端口:" + request.getLocalPort());
		return "index.html";
	}

	@RequestMapping(value = "/toRibbonDemo")
	public String toRibbonDemo(HttpServletRequest request) {
		log.info("端口:" + request.getLocalPort());
		try {
			Thread.currentThread().sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		log.info("开始跳转：" + request.getLocalPort());
		return "index.html";
	}
}
