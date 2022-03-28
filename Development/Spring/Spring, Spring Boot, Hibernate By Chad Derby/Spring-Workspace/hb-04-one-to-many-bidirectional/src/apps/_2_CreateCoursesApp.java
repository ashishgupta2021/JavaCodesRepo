package apps;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.entity.Course;
import com.entity.Instructor;
import com.entity.InstructorDetail;

public class _2_CreateCoursesApp	{

	public static void main(String[] args) {
		createCourses();
	}

	public static void createCourses() {
		// Create Session

		Session session = SingletonSessionFactory.getSessoinFactory().getCurrentSession();
		
		try {
			
			// Start a transaction
			session.beginTransaction();
			
			// Get the instructor from db
			int theId = 1;
			Instructor tempInstructor = session.get(Instructor.class, theId);
			
			// Create some courses
			Course tempCourse1 = new Course("Learn Guitar");
			Course tempCourse2 = new Course("Learn Programming Language");
			
			// Add courses to instructor
			tempInstructor.add(tempCourse1);
			tempInstructor.add(tempCourse2);
			
			// Save the courses
			session.save(tempCourse1);
			session.save(tempCourse2);

			// commit Transaction
			session.getTransaction().commit();

			System.out.println("Done!");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
