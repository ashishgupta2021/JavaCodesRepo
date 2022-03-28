package apps;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.entity.Instructor;
import com.entity.InstructorDetail;

public class _1_DeleteInstructorDetailOnlyApp	{

	public static void main(String[] args) {
		deleteInstructorDetailOnly();
	}

	/* Delete Instructor and instructor detail */
	public static void deleteInstructorDetailOnly() {
		// Create Session

		Session session = SingletonSessionFactory.getSessoinFactory().getCurrentSession();

		try {

			// Start a transaction
			session.beginTransaction();

			// Get the instructor detail object
			int theInstructorDetailId = 3;

			InstructorDetail tempInstructorDetail = session.get(InstructorDetail.class, theInstructorDetailId);

			System.out.println("tempInstructorDetail: " + tempInstructorDetail);

			System.out.println("the associated instructor: " + tempInstructorDetail.getInstructor());

			// Delete the instructor detail
			System.out.println("Deleting tempInstructorDetail: " + tempInstructorDetail);
			
			// Remove the associated object reference (break bi-directional link)
			tempInstructorDetail.getInstructor().setInstructorDetail(null);
			session.delete(tempInstructorDetail);

			// commit Transaction
			session.getTransaction().commit();

			System.out.println("Done!");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
