package com.common;


import java.math.BigDecimal;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.model.Item;
import com.model.Bid;

public class MainApp {
	
	public static void main(String[] args) {
		
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = null;
		try {
			tx = entityManager.getTransaction();
			tx.begin();
			
			Item someItem = new Item("Some Item");	
			entityManager.persist(someItem);

			Bid someBid = new Bid(new BigDecimal("123.00"), someItem);
			Bid someBid2 = new Bid(new BigDecimal("124.00"), someItem);
			
			
			someItem.getBids().add(someBid);
			someItem.getBids().add(someBid2);

			entityManager.persist(someBid);
			entityManager.persist(someBid2);

			
			System.out.println(someItem.getBids().size());
			tx.commit();

		}catch(Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		}
		
	}


}
