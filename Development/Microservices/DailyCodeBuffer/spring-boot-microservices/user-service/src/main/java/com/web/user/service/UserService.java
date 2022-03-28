package com.web.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.web.user.User;
import com.web.user.ValueObject.Department;
import com.web.user.ValueObject.ResponseTemplateVO;
import com.web.user.entity.UserRepository;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private RestTemplate restTemplate;

	public User saveUser(User user) {
		log.info("UserService saveUser()");
		return userRepository.save(user);
	}

	public ResponseTemplateVO getUserWithDepartment(Long userId) {
		// final String departmentUrl = "http://localhost:9001/departments/";
		/* localhost replaced with DEPARTMENT-SERVICE. We need to tell the 
		 * RestTemplate as we have connected to service registry 
		 * so you need to load balance your request with using @LoadBalanced in RestTemplate
		*/
		final String departmentUrl = "http://DEPARTMENT-SERVICE:9001/departments/";
		log.info("UserService getUserWithDepartment()");
		ResponseTemplateVO vo = new ResponseTemplateVO();
		User user = userRepository.findByUserId(userId);
		
		// Calling the department service using resttemplate
		Department department = restTemplate.getForObject(departmentUrl + user.getDepartmentId(), Department.class);
		// Setting the user & department to the Value object
		vo.setUser(user);
		vo.setDepartment(department);
		return vo;
	}
}
