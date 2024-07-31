package Model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Entity
@Component
public class Course {
	 @Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
	    private Long id;
	    private String courseName;
	    private String courseImage;
	    private String courseDescription;
	    @DateTimeFormat(pattern = "yyyy-MM-dd")
	    private Date creationDate;

		public Long getId() {
			return id;
		}
		public void setId(Long id) {
			this.id = id;
		}
		public String getCourseName() {
			return courseName;
		}
		public void setCourseName(String courseName) {
			this.courseName = courseName;
		}
		public String getCourseImage() {
			return courseImage;
		}
		public void setCourseImage(String courseImage) {
			this.courseImage = courseImage;
		}
		public String getCourseDescription() {
			return courseDescription;
		}
		public void setCourseDescription(String courseDescription) {
			this.courseDescription = courseDescription;
		}
		public Date getCreationDate() {
			return creationDate;
		}
		public void setCreationDate(Date creationDate) {
			this.creationDate = creationDate;
		}
		public Course(Long id, String courseName, String courseImage, String courseDescription, Date creationDate) {
			super();
			this.id = id;
			this.courseName = courseName;
			this.courseImage = courseImage;
			this.courseDescription = courseDescription;
			this.creationDate = creationDate;
		}
		public Course() {
			super();
		}
	    
	    
}
