package com.dao;

import java.util.List;

import javax.persistence.EntityManager;

import com.common.JPAUtil;
import com.model.BankAccount;

public class BankAccountDaoImpl {

	public int insert(BankAccount bankAccount) {
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		try {
			entityManager.getTransaction().begin();
			entityManager.persist(bankAccount);
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

	public List<BankAccount> getAllBankAccount() {
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		try {
			List<BankAccount> listBankAccount = entityManager.createQuery("from BankAccount").getResultList();
			System.out.println(listBankAccount);
			return listBankAccount;

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
			BankAccount bankAccount = entityManager.find(BankAccount.class, id);
			bankAccount.setAccount("1234567");

			entityManager.persist(bankAccount);
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

}
