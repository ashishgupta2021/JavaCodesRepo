package code.springframework.service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.BeanFactoryAware;
import org.springframework.beans.factory.BeanNameAware;
import org.springframework.beans.factory.DisposableBean;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class LifeCycleDemoBean implements InitializingBean, DisposableBean, BeanNameAware,
BeanFactoryAware, ApplicationContextAware{

	/*	InitializingBean	*/
	@Override
	public void afterPropertiesSet() throws Exception {
		System.out.println("LifeCycleDemoBean.afterPropertiesSet()");
	}

	/*	DisposableBean	*/
	@Override
	public void destroy() throws Exception {
		System.out.println("LifeCycleDemoBean.destroy()");
		
	}
	
	/*	BeanNameAware	*/
	@Override
	public void setBeanName(String name) {
		System.out.println("LifeCycleDemoBean.setBeanName() : " + name);
	}

	/* BeanFactoryAware	*/
	@Override
	public void setBeanFactory(BeanFactory beanFactory) throws BeansException {
		System.out.println("LifeCycleDemoBean.setBeanFactory()");
	}
	
	/*	ApplicationContextAware	*/
	@Override
	public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
		System.out.println("LifeCycleDemoBean.setApplicationContext()");		
	}
	
	@PostConstruct
	public void postConstruct() {
		System.out.println("LifeCycleDemoBean.postConstruct()");
	}
	
	@PreDestroy
	public void preDestroy() {
		System.out.println("LifeCycleDemoBean.enclosing_method()");
	}
	
	public void beforeInit() {
		System.out.println("enclosing_type.enclosing_method()");
	}
	
	public void afterInit() {
		System.out.println("LifeCycleDemoBean.afterInit()");
	}
}
