package com.withtemplate;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.transaction.annotation.Transactional;

public class HibernateCourseDao implements CourseDao {

	private HibernateTemplate hibernateTemplate;
	
	public  HibernateCourseDao(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}
	/*public void setHibernateTemplate(HibernateTemplate hibernateTemplate) {
		this.hibernateTemplate = hibernateTemplate;
	}*/
	
	
	@Override
	@Transactional
	public void store(Course course) {
		hibernateTemplate.saveOrUpdate(course);
	}

	@Override
	@Transactional
	public void delete(Long courseId) {
		Course course = hibernateTemplate.get(Course.class, courseId);
		hibernateTemplate.delete(course);
	}

	@Override
	@Transactional(readOnly= true)
	public Course findById(Long courseId) {
		return (Course) hibernateTemplate.get(Course.class, courseId);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Course> findAll() {
		return (List<Course>) hibernateTemplate.find("from Course");
	}

}
