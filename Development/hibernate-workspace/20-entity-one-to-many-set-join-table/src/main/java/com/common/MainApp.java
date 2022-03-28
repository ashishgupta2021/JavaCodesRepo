package com.common;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.model.Item;
import com.model.User;

public class MainApp {
	
	public static void main(String[] args) {
		
        EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = null;
		try {
			
			 tx = em.getTransaction();
	         tx.begin();
			
            User someUser = new User("johndoe");
            em.persist(someUser);
            
           
            Item someItem = new Item("Some Item");
            em.persist(someItem);
           
            
           
            Item otherItem = new Item("Other Item");
            em.persist(otherItem);

            
            someUser.getBoughtItems().add(someItem); // Link
            someItem.setBuyer(someUser); // Link
            someUser.getBoughtItems().add(otherItem);
            otherItem.setBuyer(someUser);
            em.persist(someUser);

            Item unsoldItem = new Item("Unsold Item");
            em.persist(unsoldItem);
//
//            tx.commit();
//            em.close();
//
//            Long ITEM_ID = someItem.getId();
//            Long UNSOLD_ITEM_ID = unsoldItem.getId();
//
//            tx.begin();
//            em = JPAUtil.getEntityManagerFactory().createEntityManager();
//
//            Item item = em.find(Item.class, ITEM_ID);
//            System.out.println(item.getBuyer().getUsername() == "johndoe");
//            System.out.println(item.getBuyer().getBoughtItems().contains(item));
//
//            Item item2 = em.find(Item.class, UNSOLD_ITEM_ID);
//            System.out.println(item2.getBuyer());

            tx.commit();
            em.close();

        } finally {
            // tx.rollback();
        }
		
	}


}
