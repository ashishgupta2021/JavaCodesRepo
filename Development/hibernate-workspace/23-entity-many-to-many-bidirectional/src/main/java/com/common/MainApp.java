package com.common;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.model.Category;
import com.model.Item;

public class MainApp {

	public static void main(String[] args) {

		EntityManager em = JPAUtil.getEntityManagerFactory().createEntityManager();
		EntityTransaction tx = null;
		try {

			tx = em.getTransaction();
			tx.begin();

			Category someCategory = new Category("Some Category");
			Category otherCategory = new Category("Other Category");

			Item someItem = new Item("Some Item");
			Item otherItem = new Item("Other Item");

			someCategory.getItems().add(someItem);
			someItem.getCategories().add(someCategory);

			someCategory.getItems().add(otherItem);
			otherItem.getCategories().add(someCategory);

			otherCategory.getItems().add(someItem);
			someItem.getCategories().add(otherCategory);

			em.persist(someCategory);
			em.persist(otherCategory);

			tx.commit();
			em.close();
		} finally {
			// tx.rollback();
		}
	}
}
