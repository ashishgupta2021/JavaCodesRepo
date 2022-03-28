package apps;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.entity.Instructor;
import com.entity.InstructorDetail;

public class _2_DeleteInstructorApp {

	public static void main(String[] args) {

		deleteInstructor();

	}

	/* Delete Instructor and instructor detail */
	public static void deleteInstructor() {
		// Create Session

		Session session = SingletonSessionFactory.getSessoinFactory().getCurrentSession();

		try {

			// Start a transaction
			session.beginTransaction();

			// Get instructor by primary key / id
			int instructorId = 1;
			Instructor tempInstructor = session.get(Instructor.class, instructorId);

			if (tempInstructor != null) {
				System.out.println("Deleting: " + tempInstructor);

				// Note this will also delete associated "instructor detail" object beacuse of
				// CascadeType.ALL
				session.delete(tempInstructor);
			} else {
				System.out.println("Not Deleted!!!");
			}
			// commit Transaction
			session.getTransaction().commit();

			System.out.println("Done!");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
