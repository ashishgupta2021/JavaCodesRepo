package com.common;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.model.CategorizedItem;
import com.model.Category;
import com.model.Item;
import com.model.User;

public class MainApp {

	public static void main(String[] args) {

		EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = null;
		try {

			tx = em.getTransaction();
			tx.begin();

			Category someCategory = new Category("Some Category");
            Category otherCategory = new Category("Other Category");
            em.persist(someCategory);
            em.persist(otherCategory);

            Item someItem = new Item("Some Item");
            Item otherItem = new Item("Other Item");
            em.persist(someItem);
            em.persist(otherItem);

            User someUser = new User("johndoe");
            em.persist(someUser);

            CategorizedItem linkOne = new CategorizedItem(
                someUser, someItem
            );
            someCategory.getCategorizedItems().add(linkOne);

            CategorizedItem linkTwo = new CategorizedItem(
                someUser, otherItem
            );
            someCategory.getCategorizedItems().add(linkTwo);

            CategorizedItem linkThree = new CategorizedItem(
                someUser, someItem
            );
            otherCategory.getCategorizedItems().add(linkThree);

            System.out.println("going to commit");
			tx.commit();
			em.close();
		} finally {
			// tx.rollback();
		}
	}
}
