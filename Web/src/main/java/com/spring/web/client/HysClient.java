package com.spring.web.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name="HYS-SERVER", fallback=HysClientFallBack.class)
public interface HysClient {

	@GetMapping(value = "/toHystrixTest")
	String toHystrixTest(@RequestParam(value = "testName") String testName);
	
}
