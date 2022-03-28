package apps;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.entity.Course;
import com.entity.Instructor;
import com.entity.InstructorDetail;

public class _3_DeleteCourseApp	{

	public static void main(String[] args) {
		deleteCourse();
	}

	public static void deleteCourse() {
		// Create Session

		Session session = SingletonSessionFactory.getSessoinFactory().getCurrentSession();
		
		try {
			
			// Start a transaction
			session.beginTransaction();
			
			// Get a Course
			int theId = 10;
			Course tempCourse = session.get(Course.class, theId);
			
			// Delete Course
			System.out.println("Deleting Course: " + tempCourse);
			
			session.delete(tempCourse);
			

			// commit Transaction
			session.getTransaction().commit();

			System.out.println("Done!");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
