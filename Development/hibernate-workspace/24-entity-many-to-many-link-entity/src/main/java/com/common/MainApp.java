package com.common;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import com.model.CategorizedItem;
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
			em.persist(someCategory);
			em.persist(otherCategory);

			Item someItem = new Item("Some Item");
			Item otherItem = new Item("Other Item");
			em.persist(someItem);
			em.persist(otherItem);

			CategorizedItem linkOne = new CategorizedItem("johndoe", someCategory, someItem);

			CategorizedItem linkTwo = new CategorizedItem("johndoe", someCategory, otherItem);

			CategorizedItem linkThree = new CategorizedItem("johndoe", otherCategory, someItem);

			em.persist(linkOne);
			em.persist(linkTwo);
			em.persist(linkThree);

			tx.commit();
			em.close();
		} finally {
			// tx.rollback();
		}
	}
}
