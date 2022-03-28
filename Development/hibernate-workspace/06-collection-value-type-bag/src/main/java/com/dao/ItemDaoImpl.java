package com.dao;

import java.util.Collection;
import java.util.List;

import javax.persistence.EntityManager;

import com.common.JPAUtil;
import com.model.Item;

public class ItemDaoImpl {

	public Collection<Item> getAllItem()	{
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		try {
			entityManager.getTransaction().begin();
			Collection<Item> listItem = entityManager.createQuery("from Item").getResultList();
			return listItem;
		}catch(Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
			return null;
		}finally {
			entityManager.close();
		}
	}
	
	public int insert(Item item) {
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(item);
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
