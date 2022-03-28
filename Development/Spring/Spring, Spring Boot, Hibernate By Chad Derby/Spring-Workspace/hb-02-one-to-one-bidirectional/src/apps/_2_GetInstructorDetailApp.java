package apps;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.entity.Instructor;
import com.entity.InstructorDetail;

public class _2_GetInstructorDetailApp {

	public static void main(String[] args) {

		getInstructorDetail();
	}

	/* Create Instructor and instructor detail */
	public static void getInstructorDetail() {
		// Create Session

		Session session = SingletonSessionFactory.getSessoinFactory().getCurrentSession();

		try {

			// Start a transaction
			session.beginTransaction();

			// Get the instructor detail object
			int theInstructorDetailId = 2;

			InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, theInstructorDetailId);

			System.out.println("tempInstructorDetail: " + tempInstructorDetail);

			System.out.println("the associated instructor: " + tempInstructorDetail.getInstructor());

			// commit Transaction
			session.getTransaction().commit();

			System.out.println("Done!");

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			session.close();
		}
	}
}