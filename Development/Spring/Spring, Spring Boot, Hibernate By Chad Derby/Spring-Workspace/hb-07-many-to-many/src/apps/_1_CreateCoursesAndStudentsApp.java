package apps;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.entity.Course;
import com.entity.Instructor;
import com.entity.InstructorDetail;
import com.entity.Review;
import com.entity.Student;

public class _1_CreateCoursesAndStudentsApp	{

	public static void main(String[] args) {
		createCoursesAndStudents();
	}

	public static void createCoursesAndStudents() {
		
		// Create Session

		Session session = SingletonSessionFactory.getSessoinFactory().getCurrentSession();

		try {
			
			// Start a transaction
			session.beginTransaction();
			
			// Create a course
			Course tempCourse = new Course("Programming Language");
			
			System.out.println("Saving the Course!!!");
			session.save(tempCourse);
			System.out.println("Saved the Course: " + tempCourse);
			
			// Creating the Students
			Student student1 = new Student("Ashish", "Gupta", "ashish@gmail.com");
			Student student2 = new Student("Manish", "Gupta", "manish@gmail.com");
			
			tempCourse.addStudent(student1);
			tempCourse.addStudent(student2);
			
			// Save the Students
			System.out.println("Saving the students ...");
			session.save(student1);
			session.save(student2);
			System.out.println("Saved Students: " + tempCourse.getStudents());
			// commit Transaction
			session.getTransaction().commit();

			System.out.println("Done!");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
