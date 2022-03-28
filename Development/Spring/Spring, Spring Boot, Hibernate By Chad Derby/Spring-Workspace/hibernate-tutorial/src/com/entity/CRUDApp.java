package com.entity;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class CRUDApp {

	private static SessionFactory factory;

	static {

		// Create session Factory

		factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student.class)
				.buildSessionFactory();
	}

	public static void main(String[] args) {

		// create();
		// read();
		// queryStudent();
		// update();
		// updateEmailForAllStudents();
		// delete();
		deleteStudent();
	}

	public static void create() {
		// Create Session

		Session session = factory.getCurrentSession();

		try {
			// Create a Student object
			System.out.println("Creating new Student object...");
			Student tempStudent = new Student("Manish", "Gupta", "ashish041989@yahoo.com");

			// Start a transaction
			session.beginTransaction();

			// Save the student object
			// insert into student (email, first_name, last_name, id) values (?, ?, ?, ?)
			System.out.println("Saving the student...");
			session.save(tempStudent);

			// commit Transaction
			session.getTransaction().commit();

			System.out.println("Done!");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void read() {
		// Create Session

		Session session = factory.getCurrentSession();

		try {
			// Start a transaction
			session.beginTransaction();

			// Hibernate: select student0_.id as id1_0_0_, student0_.email as email2_0_0_,
			// student0_.first_name as first_na3_0_0_, student0_.last_name as last_nam4_0_0_
			// from student student0_ where student0_.id=?
			Student student = session.get(Student.class, 1);

			System.out.println("student : " + student);

			// commit Transaction
			session.getTransaction().commit();

			System.out.println("Done!");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void queryStudent() {

		// Create Session
		Session session = factory.getCurrentSession();

		try {
			// Start a transaction
			session.beginTransaction();

			// query Students
			// select student0_.id as id1_0_, student0_.email as email2_0_,
			// student0_.first_name as first_na3_0_, student0_.last_name as last_nam4_0_
			// from student student0_
			List<Student> listStudents = session.createQuery("from Student").list();

			// display the students
			listStudents.forEach(System.out::println);

			// query Students : firstName='Ashish'
			listStudents = session.createQuery("from Student s where s.firstName = 'Ashish'").list();

			// display the students
			listStudents.forEach(System.out::println);

			// query Students: firstName='Ashish' OR lastName = 'Sinha'
			listStudents = session.createQuery("from Student s where s.firstName = 'Ashish' OR s.lastName = 'Sinha'")
					.list();

			// display the students
			listStudents.forEach(System.out::println);

			// query Students: where email LIKE '%gmail.com'
			listStudents = session.createQuery("from Student s where s.email like '%gmail.com' ").list();

			// display the students
			listStudents.forEach(System.out::println);

			// commit Transaction
			session.getTransaction().commit();

			System.out.println("Done!");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void update() {

		int studentId = 1;
		try {

			// Get a new session and start a transaction
			Session session = factory.getCurrentSession();
			session.beginTransaction();

			// Retrieve student based on the id: primary key
			System.out.println("Getting student with id: " + studentId);
			Student student = session.get(Student.class, studentId);

			System.out.println("Updating Student...");
			student.setFirstName("Raj");

			// commit Transaction
			session.getTransaction().commit();

			System.out.println("Done!");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void updateEmailForAllStudents() {

		try {
			// Get a new session and starts a transaction
			Session session = factory.getCurrentSession();
			session.beginTransaction();

			System.out.println("Update email for all students");

			session.createQuery("update Student set email = 'test@gmail.com'").executeUpdate();

			// commit Transaction
			session.getTransaction().commit();

			System.out.println("Done!");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void delete() {

		int studentId = 1;
		try {

			// Get a new session and start a transaction
			Session session = factory.getCurrentSession();
			session.beginTransaction();

			// Retrieve student based on the id: primary key
			System.out.println("Getting student with id: " + studentId);
			Student student = session.get(Student.class, studentId);

			// Delete a student
			System.out.println("Deleting Student : " + studentId);
			session.delete(student);
			
			// commit Transaction
			session.getTransaction().commit();

			System.out.println("Done!");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void deleteStudent() {

		try {
			// Get a new session and starts a transaction
			Session session = factory.getCurrentSession();
			session.beginTransaction();

			session.createQuery("delete from Student where id = 2").executeUpdate();

			// commit Transaction
			session.getTransaction().commit(); 

			System.out.println("Done!");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}


}
