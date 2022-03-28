package apps;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.entity.Course;
import com.entity.Instructor;
import com.entity.InstructorDetail;
import com.entity.Review;

public class _1_CreateCoursesAndReviewsApp	{

	public static void main(String[] args) {
		createCoursesAndReviews();
	}

	public static void createCoursesAndReviews() {
		// Create Session

		Session session = SingletonSessionFactory.getSessoinFactory().getCurrentSession();

		try {
			
			// Start a transaction
			session.beginTransaction();
			
			// Create a course
			Course tempCourse = new Course("Programming Language");
			
			// Add Some Reviews
			tempCourse.addReview(new Review("Great Course"));
			tempCourse.addReview(new Review("Cool Course"));
			tempCourse.addReview(new Review("Awesome Course"));

			
			// Save the course ... and leverage the cascade all
			System.out.println("Saving the Course");
			System.out.println(tempCourse);
			System.out.println(tempCourse.getReviews());
			session.save(tempCourse);

			// commit Transaction
			session.getTransaction().commit();

			System.out.println("Done!");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
