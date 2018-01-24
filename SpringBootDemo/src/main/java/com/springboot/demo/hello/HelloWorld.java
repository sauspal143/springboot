package com.springboot.demo.hello;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorld {

	@RequestMapping (method=RequestMethod.GET, path="/hello")
	public String sayHi() {
		return "Hi Saurabh !!!";
	}
}
