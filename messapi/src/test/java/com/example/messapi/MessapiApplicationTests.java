package com.example.messapi;

import com.example.messapi.domain.Message;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.util.Assert;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
class MessapiApplicationTests {
	@Autowired
	RestTemplate restTemplate;
	@Test
	void contextLoads() {
		Message tMessage = restTemplate.getForObject("https://dog.ceo/api/breeds/list/all", Message.class);
		Message aMessage = restTemplate.getForObject("http://localhost:8080/api/breeds/list/all", Message.class);
		Assert.isTrue(aMessage.equals(tMessage),"success");
	}

}
