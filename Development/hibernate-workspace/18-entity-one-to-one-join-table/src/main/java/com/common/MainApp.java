package com.common;


import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.model.Item;
import com.model.Shipment;

public class MainApp {
	
	public static void main(String[] args) {
		
		EntityManager entityManager = JPAUtil.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = null;
		try {
			tx = entityManager.getTransaction();
			tx.begin();
			Item someItem = new Item("Some Item");	
	
			entityManager.persist(someItem);

			Shipment auctionShipment = new Shipment(someItem);

			entityManager.persist(auctionShipment);
			
			System.out.println(entityManager.getTransaction());
			tx.commit();

		}catch(Exception e) {
			e.printStackTrace();
			entityManager.getTransaction().rollback();
		}
		
	}


}
