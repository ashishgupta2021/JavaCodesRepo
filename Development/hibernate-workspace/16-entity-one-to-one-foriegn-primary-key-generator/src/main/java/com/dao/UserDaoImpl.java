package com.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.common.JPAUtil;
import com.model.*;

public class UserDaoImpl {

	public List<User> getAllUser()	{
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		try {
			entityManager.getTransaction().begin();
			List<User> listuser = entityManager.createQuery("from User").getResultList();
			return listuser;
		}catch(Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
			return null;
		}finally {
			entityManager.close();
		}
	}
	
	public int insert(User user) {
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(user);
			entityManager.getTransaction().commit();
			return 1;
		}catch(Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
			return -1;
		}finally {
			entityManager.close();
		}
	}
}
