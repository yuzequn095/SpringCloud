package com.spring.web.client;

import org.aspectj.apache.bcel.generic.ReturnaddressType;
import org.springframework.stereotype.Component;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class HysClientFallBack implements HysClient{

	@Override
	public String toHystrixTest(String testName){
		log.info("Hystrix接口凉了 Σ( ° △ °|||)︴");
		return "反应太慢了 (°ー°〃)";
	}
	
}
