package com.spring.web.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.web.ResultBody;


@FeignClient(name = "USER-SERVER")
public interface UserClient {
	
	@ResponseBody
	@RequestMapping(value = "/getUserName", method = RequestMethod.GET)
	
	ResultBody getUserName(@RequestParam(value="userName") String userName);
	
}
