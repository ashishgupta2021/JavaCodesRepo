package com.manual;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;


public class HibernateCourseDao implements CourseDao {

	private SessionFactory sessionFactory;
	
	public HibernateCourseDao(SessionFactory sessionFactory) {
		// sessionFactory = new Configuration().configure().buildSessionFactory();
		this.sessionFactory = sessionFactory;
	}
	
	@Override
	public void store(Course course) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.beginTransaction();
		try {
			//tx.begin();
			session.saveOrUpdate(course);
			tx.commit();
		} catch (RuntimeException e) {
			tx.rollback();
			throw e;
		}finally {
			session.close();
		}
	}

	@Override
	public void delete(Long courseId) {
		Session session = sessionFactory.openSession();
		Transaction tx = session.getTransaction();
		try {
			tx.begin();
			Course course = session.get(Course.class, courseId);
			session.delete(course);
			tx.commit();
		} catch (RuntimeException e) {
			tx.rollback();
			throw e;
		}finally {
			session.close();
		}
	}

	@Override
	public Course findById(Long courseId) {
		Session session = sessionFactory.openSession();
		try {
			return session.get(Course.class, courseId);
		} finally {
			session.close();
		}
	}

	@Override
	public List<Course> findAll() {
		Session session = sessionFactory.openSession();
		try {
			Query query = session.createQuery("from Course");
			return query.list();
		} finally {
			session.close();
		}
	}

}
