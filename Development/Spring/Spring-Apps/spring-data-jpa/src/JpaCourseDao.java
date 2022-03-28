import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.transaction.annotation.Transactional;


public class JpaCourseDao implements CourseDao {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	@Transactional
	public void store(Course course) {
		entityManager.merge(course);
	}

	@Override
	@Transactional
	public void delete(Long courseId) {
		Course course = entityManager.find(Course.class, courseId);
		entityManager.remove(course);
	}

	@Override
	@Transactional(readOnly=true)
	public Course findById(Long courseId) {
		return entityManager.find(Course.class, courseId);
	}

	@Override
	@Transactional(readOnly=true)
	public List<Course> findAll() {
		TypedQuery<Course> query = entityManager.createQuery("from Course", Course.class);
		return query.getResultList();
	}

}
