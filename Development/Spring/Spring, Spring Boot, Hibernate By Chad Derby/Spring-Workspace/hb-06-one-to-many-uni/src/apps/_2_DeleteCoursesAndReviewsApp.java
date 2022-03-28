package apps;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.entity.Course;
import com.entity.Instructor;
import com.entity.InstructorDetail;
import com.entity.Review;

public class _2_DeleteCoursesAndReviewsApp	{

	public static void main(String[] args) {
		deleteCoursesAndReviews();
	}

	public static void deleteCoursesAndReviews() {
		// Create Session

		Session session = SingletonSessionFactory.getSessoinFactory().getCurrentSession();

		try {
			
			// Start a transaction
			session.beginTransaction();
			
			// Get the course 
			int theId = 10;
			Course tempCourse = session.get(Course.class, theId);
				
			// Print the Course
			System.out.println("Deleting Course: " + tempCourse);
			
			// print the course review
			
			System.out.println("Course Review: " + tempCourse.getReviews());

			// Delete the Course
			session.delete(tempCourse);
			
			// commit Transaction
			session.getTransaction().commit();

			System.out.println("Done!");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
