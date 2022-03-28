package apps;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.entity.Course;
import com.entity.Instructor;
import com.entity.InstructorDetail;
import com.entity.Review;
import com.entity.Student;

public class _3_DeleteCoursesApp	{

	public static void main(String[] args) {
		deleteCourses();
	}

	public static void deleteCourses() {
		
		// Create Session

		Session session = SingletonSessionFactory.getSessoinFactory().getCurrentSession();

		try {
			
			// Start a transaction
			session.beginTransaction();
			
			// Get the course from database
			int courseId = 10;
			Course tempCourse = session.get(Course.class, courseId);
			
			System.out.println("Deleting Course");
			session.delete(tempCourse);
			
			// commit Transaction
			session.getTransaction().commit();

			System.out.println("Done!");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
