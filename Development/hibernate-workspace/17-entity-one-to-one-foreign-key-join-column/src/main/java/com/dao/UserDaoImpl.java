package com.dao;

import javax.persistence.EntityManager;

import com.common.JPAUtil;
import com.model.*;

public class UserDaoImpl {


	
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
