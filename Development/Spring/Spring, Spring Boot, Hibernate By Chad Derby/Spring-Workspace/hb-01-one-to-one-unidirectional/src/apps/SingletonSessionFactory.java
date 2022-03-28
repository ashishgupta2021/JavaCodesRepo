package apps;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.entity.Instructor;
import com.entity.InstructorDetail;

public class SingletonSessionFactory {

	private static SessionFactory factory;
	
	public static SessionFactory getSessoinFactory() {

		// Create session Factory

		factory = new Configuration().configure("hibernate.cfg.xml")
				.addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.buildSessionFactory();
		return factory;
	}
}
