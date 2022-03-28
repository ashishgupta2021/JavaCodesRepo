package apps;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.entity.Course;
import com.entity.Instructor;
import com.entity.InstructorDetail;
import com.entity.Review;
import com.entity.Student;

public class _2_CreateMoreCoursesForStudentsApp	{

	public static void main(String[] args) {
		createMoreCoursesForStudents();
	}

	public static void createMoreCoursesForStudents() {
		// Create Session

		Session session = SingletonSessionFactory.getSessoinFactory().getCurrentSession();

		try {
			
			// Start a transaction
			session.beginTransaction();
			
			// Get the student having id = 2 from database
			int studentId = 2;
			Student tempStudent = session.get(Student.class, studentId);
			
			System.out.println("Loaded Student: " + tempStudent);
			System.out.println("Courses : " + tempStudent.getCourses());
			
			// Create More courses
			Course tempCourse1 = new Course("Mobile Development");
			Course tempCourse2 = new Course("Game Development");
			
			// Add Student to Courses
			tempCourse1.addStudent(tempStudent);
			tempCourse2.addStudent(tempStudent);
			
			// Save the Courses
			
			System.out.println("Saving the courses");
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
