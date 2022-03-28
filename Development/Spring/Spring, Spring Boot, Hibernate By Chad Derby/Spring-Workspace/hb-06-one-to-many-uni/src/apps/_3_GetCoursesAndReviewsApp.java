package apps;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.entity.Course;
import com.entity.Instructor;
import com.entity.InstructorDetail;
import com.entity.Review;

public class _3_GetCoursesAndReviewsApp	{

	public static void main(String[] args) {
		getCoursesAndReviews();
	}

	public static void getCoursesAndReviews() {
		// Create Session

		Session session = SingletonSessionFactory.getSessoinFactory().getCurrentSession();

		try {
			
			// Start a transaction
			session.beginTransaction();
			
			// Get the course 
			int theId = 11;
			Course tempCourse = session.get(Course.class, theId);
						
			System.out.println("Courses: " + tempCourse);
			
			// print the course review
			
			System.out.println("Course Review: " + tempCourse.getReviews());

			// commit Transaction
			session.getTransaction().commit();

			System.out.println("Done!");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
