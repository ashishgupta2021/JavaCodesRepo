package com.schedule;

import java.util.List;

import org.quartz.spi.TriggerFiredBundle;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.AutowireCapableBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.scheduling.quartz.SpringBeanJobFactory;

public class AutowiringSpringBeanJobFacotry  extends SpringBeanJobFactory implements ApplicationContextAware {

	private transient AutowireCapableBeanFactory beanFactory;
	
	@Override
	public void setApplicationContext(final ApplicationContext context) throws BeansException {
		System.out.println("AutowiringSpringBeanJobFacotry.setApplicationContext()");
		for(String beanValue : context.getBeanDefinitionNames())
		System.out.println(beanValue);
		beanFactory = context.getAutowireCapableBeanFactory();
	}

	@Override
	protected Object createJobInstance(final TriggerFiredBundle bundle) throws Exception {
		System.out.println("AutowiringSpringBeanJobFacotry.createJobInstance()");
		Object job = super.createJobInstance(bundle);
		beanFactory.autowireBean(job);		
		return job;
	}
}
