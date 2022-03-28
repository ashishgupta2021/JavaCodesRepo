package apps;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.entity.Course;
import com.entity.Instructor;
import com.entity.InstructorDetail;

public class _1_EagerLazyApp	{

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
			Instructor tempInstructor = session.get(Instructor.class, theId);
			
			System.out.println("Instructor: " + tempInstructor);
			
			// Get course for the instructor
			System.out.println("Courses: " + tempInstructor.getCourses());

			// commit Transaction
			session.getTransaction().commit();

			System.out.println("Done!");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
