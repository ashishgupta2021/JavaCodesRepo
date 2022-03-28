package com.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.common.JPAUtil;
import com.model.*;

public class AddressDaoImpl {

	public List<Address> getAllAddress()	{
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		try {
			entityManager.getTransaction().begin();
			List<Address> listAddress = entityManager.createQuery("from Address").getResultList();
			return listAddress;
		}catch(Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
			return null;
		}finally {
			entityManager.close();
		}
	}
	
	public int insert(Address address) {
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(address);
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
