package com.common;

import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.model.Bid;
import com.model.Item;


public class MainApp {

	public static void main(String[] args) {

		EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = null;
		try {

			tx = em.getTransaction();
			tx.begin();

			 Item someItem = new Item("Some Item");
	            em.persist(someItem);

	            Bid someBid = new Bid(new BigDecimal("123.00"), someItem);
	            em.persist(someBid);
	            someItem.getBids().put(someBid.getId(), someBid); // Optional...

	            Bid secondBid = new Bid(new BigDecimal("456.00"), someItem);
	            em.persist(secondBid);
	            someItem.getBids().put(secondBid.getId(), secondBid); 

            System.out.println("going to commit");
			tx.commit();
			em.close();
		} finally {
			// tx.rollback();
		}
	}
}
