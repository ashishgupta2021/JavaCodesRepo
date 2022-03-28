package apps;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.entity.Course;
import com.entity.Instructor;
import com.entity.InstructorDetail;
import com.entity.Review;
import com.entity.Student;

public class _5_GetCoursesForStudentsApp	{

	private static SessionFactory factory;

	static {

		// Create session Factory

		factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Instructor.class)
				.addAnnotatedClass(InstructorDetail.class)
				.addAnnotatedClass(Course.class)
				.addAnnotatedClass(Review.class)
				.addAnnotatedClass(Student.class)
				.buildSessionFactory();
	}

	public static void main(String[] args) {
		getCoursesForStudents();
	}

	public static void getCoursesForStudents() {
		
		// Create Session

		Session session = factory.getCurrentSession();

		try {
			
			// Start a transaction
			session.beginTransaction();
			
			// Get the students from database
			int studentId = 2;
			Student tempStudent = session.get(Student.class, studentId);
			
			System.out.println("Loaded Student: " + tempStudent);
			System.out.println("Courses: " + tempStudent.getCourses());
			
			
			// commit Transaction
			session.getTransaction().commit();

			System.out.println("Done!");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
