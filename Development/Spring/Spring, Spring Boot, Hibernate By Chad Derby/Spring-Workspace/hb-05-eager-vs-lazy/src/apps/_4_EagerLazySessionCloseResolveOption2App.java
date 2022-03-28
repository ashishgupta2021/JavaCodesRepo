package apps;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

import com.entity.Course;
import com.entity.Instructor;
import com.entity.InstructorDetail;

public class _4_EagerLazySessionCloseResolveOption2App	{

	public static void main(String[] args) {
		getInstructorCourses();
	}

	public static void getInstructorCourses() {
		// Create Session

		Session session = SingletonSessionFactory.getSessoinFactory().getCurrentSession();

		try {
			
			// Start a transaction
			session.beginTransaction();
			
			// Get the instructor from db
			int theId = 1;

			Query<Instructor> query = session.createQuery("select i from Instructor i "
					+ "JOIN FETCH i.courses "
					+ "where i.id =:theInstructorId", Instructor.class);
			
			// Set parameter on query
			query.setParameter("theInstructorId", theId);
			
			// Execute query and get instructor
			Instructor instructor = query.getSingleResult();
			
			System.out.println("Instructor: " + instructor);			

			// commit Transaction
			session.getTransaction().commit();
			
			// Close the session
			session.close();
			
			// Get course for the instructor
			System.out.println("Courses: " + instructor.getCourses());


			System.out.println("Done!");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
