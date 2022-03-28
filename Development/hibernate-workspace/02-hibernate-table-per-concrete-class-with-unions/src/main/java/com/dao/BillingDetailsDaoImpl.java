package com.dao;

import java.util.List;
import javax.persistence.EntityManager;
import com.common.JPAUtil;
import com.model.BillingDetails;

public class BillingDetailsDaoImpl {
	
	public List<BillingDetails> getAllBillingDetails()	{
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		try {
			List<BillingDetails> listBillingDetails = entityManager.createQuery("from BillingDetails").getResultList();
			System.out.println(listBillingDetails);
			return listBillingDetails;

		} catch (Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
			return null;
		} finally {
			entityManager.close();
		}
	}

}
