package com.spring.web.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.web.ResultBody;

@FeignClient(name = "NUM-SERVER")
public interface NumClient {

	@ResponseBody
	@RequestMapping(value = "/getUserId", method = RequestMethod.GET)
	
	ResultBody getUserId(@RequestParam(value="userId") String userId);
}
