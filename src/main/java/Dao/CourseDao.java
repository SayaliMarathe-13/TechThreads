package Dao;

import javax.transaction.Transactional;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;
import Model.Course;

@Component
public class CourseDao {
    private final HibernateTemplate hibernateTemplate;

    @Autowired
    public CourseDao(HibernateTemplate hibernateTemplate) {
        this.hibernateTemplate = hibernateTemplate;
    }

    @Transactional
    public Long insert(Course course) {
        Long id = (Long) this.hibernateTemplate.save(course);
        System.out.println("Course added");
        return id;
    }

    public List<Course> getAllCourses() {
        return this.hibernateTemplate.loadAll(Course.class);
    }
    @Transactional
    public boolean deleteCourseById(Long id) {
        try {
            Course course = hibernateTemplate.get(Course.class, id);
            if (course != null) {
                hibernateTemplate.delete(course);
                return true;
            }
            return false;
        } catch (Exception e) {
            // Log the exception
            e.printStackTrace();
            return false;
        }
    }
    public List<Course> loadAll() {

    	return (List<Course>) this.hibernateTemplate.loadAll(Course.class);

    	}
	 @Transactional
    public Course getCourseById(Long courseId) {
        return this.hibernateTemplate.get(Course.class, courseId);
    }
   
}
