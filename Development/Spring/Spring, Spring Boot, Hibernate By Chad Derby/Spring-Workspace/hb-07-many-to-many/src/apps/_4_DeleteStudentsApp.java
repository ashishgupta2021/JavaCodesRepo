package apps;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.entity.Course;
import com.entity.Instructor;
import com.entity.InstructorDetail;
import com.entity.Review;
import com.entity.Student;

public class _4_DeleteStudentsApp	{

	public static void main(String[] args) {
		deleteStudents();
	}

	public static void deleteStudents() {
		
		// Create Session

		Session session = SingletonSessionFactory.getSessoinFactory().getCurrentSession();

		try {
			
			// Start a transaction
			session.beginTransaction();
			
			// Get the course from database
			int studentId = 1;
			Student tempStudent = session.get(Student.class, studentId);
			
			System.out.println("Deleting Student");
			session.delete(tempStudent);
			
			// commit Transaction
			session.getTransaction().commit();

			System.out.println("Done!");

		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
