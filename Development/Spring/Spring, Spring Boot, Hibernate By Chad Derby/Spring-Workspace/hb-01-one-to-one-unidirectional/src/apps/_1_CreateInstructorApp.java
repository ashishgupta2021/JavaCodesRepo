package apps;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.entity.Instructor;
import com.entity.InstructorDetail;

public class _1_CreateInstructorApp {

	public static void main(String[] args) {

		createInstructor();
	}

	/* Create Instructor and instructor detail */
	public static void createInstructor() {
		// Create Session

		Session session = SingletonSessionFactory.getSessoinFactory().getCurrentSession();

		try {
			// Create the objects
			Instructor tempInstructor = new Instructor("Niraj", "Gupta", "niraj@gmail.com");
			InstructorDetail tempInstructorDetail = new InstructorDetail("http://www.youtube.com", "Youtube!");

			// Associate the Objects
			tempInstructor.setInstructorDetail(tempInstructorDetail);

			// Start a transaction
			session.beginTransaction();

			// Save the instructor and also it will save the details object because of
			// CasacadeType.ALL

			session.save(tempInstructor);

			// commit Transaction
			session.getTransaction().commit();

			System.out.println("Done!");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}