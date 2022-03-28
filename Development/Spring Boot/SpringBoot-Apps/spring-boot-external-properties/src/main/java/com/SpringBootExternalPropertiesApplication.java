package com;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import com.model.FakeDataSource;
import com.model.FakeJmsSource;
import com.model.User;

@SpringBootApplication
public class SpringBootExternalPropertiesApplication {

	
	
	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(SpringBootExternalPropertiesApplication.class, args);

		FakeDataSource fakeDataSource = context.getBean(FakeDataSource.class);
		System.out.println(
				fakeDataSource.getUsername() + " " + fakeDataSource.getPassword() + " " + fakeDataSource.getUrl());

		FakeJmsSource fakeJmsSource = context.getBean(FakeJmsSource.class);
		System.out.println(fakeJmsSource.getUsername() + " " + fakeJmsSource.getPassword());
		
		User user = context.getBean(User.class);
		System.out.println("userName: " + user.getUsername());
	}
}
