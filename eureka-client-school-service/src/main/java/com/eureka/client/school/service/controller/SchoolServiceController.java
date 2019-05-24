package com.eureka.client.school.service.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;


@RestController
public class SchoolServiceController {
	@Autowired
	RestTemplate restTemplate;
	
	@GetMapping("/getStudentName/{schoolName}")
	public String getStudents(@PathVariable("schoolName") String schoolName){
		String response = restTemplate.exchange("http://eureka-client-service/getStudent/{schoolname}",
                HttpMethod.GET, null, new ParameterizedTypeReference<String>() {}, schoolName).getBody();
		return "School Name: "+schoolName+"\n Student Details: "+response;
	}
	@Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
