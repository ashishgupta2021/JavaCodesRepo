package com.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.common.JPAUtil;
import com.model.CreditCard;

public class CreditCardDaoImpl {

	public int insert(CreditCard creditCard) {
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(creditCard);
			entityManager.getTransaction().commit();
			return 1;

		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
			return -1;
		} finally {
			entityManager.close();
		}
	}

	public List<CreditCard> getAllCreditCard() {
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		try {
			List<CreditCard> listCreditCard = entityManager.createQuery("from CreditCard").getResultList();
			return listCreditCard;

		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
			return null;
		} finally {
			entityManager.close();
		}
	}

	public int update(Long id) {
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		try {
			entityManager.getTransaction().begin();
			CreditCard creditCard = entityManager.find(CreditCard.class, id);
			creditCard.setExpMonth("28Nov2019");
			entityManager.persist(creditCard);
			entityManager.getTransaction().commit();
			return 1;

		} catch (Exception e) {
			e.printStackTrace();
			entityManager.clear();
			entityManager.getTransaction().rollback();
			return -1;
		} finally {
			entityManager.close();
		}
	}

}
