package com.common;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.model.Address;
import com.model.Shipment;
import com.model.User;

public class MainApp {
	
	public static void main(String[] args) {
		
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = null;
		try {
			
			 tx = em.getTransaction();
	         tx.begin();
			
	         	User user = new User("johndoe");
	            Address deliveryAddress = new Address("Some Street", "12345", "Some City");
	            user.setShippingAddress(deliveryAddress);
	            em.persist(user);

	            Shipment firstShipment = new Shipment();
	            deliveryAddress.getDeliveries().add(firstShipment);
	            em.persist(firstShipment);

	            Shipment secondShipment = new Shipment();
	            deliveryAddress.getDeliveries().add(secondShipment);
	            em.persist(secondShipment);

	            tx.commit();
	            em.close();

        } finally {
            // tx.rollback();
        }
	}
}
