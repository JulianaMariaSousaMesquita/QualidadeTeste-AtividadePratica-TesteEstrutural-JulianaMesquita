package course;

import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.fullteaching.backend.course.Course;
import com.fullteaching.backend.coursedetails.CourseDetails;
import com.fullteaching.backend.session.Session;
import com.fullteaching.backend.user.User;

class CourseTest {	
	private Set<Session> sessions;
	private Session session;
	
	private User user_teacher;
	private User user;
	private Set<User> attenders;
		
	private CourseDetails courseDetails;
	private Course course_programacao;
	private Course course_qualidade_teste;
	
	@BeforeEach
	public void testCourse() {
		this.user = mock(User.class);
		this.user_teacher = mock(User.class);
		this.session = mock(Session.class);
		this.courseDetails = mock(CourseDetails.class);
		
		this.sessions = new HashSet<Session>();
		this.attenders = new HashSet<User>();
		
		this.course_programacao = new Course("programacao POO", "prog.jpg", this.user_teacher);
		this.course_qualidade_teste= new Course("qualidade e teste", "quali.jpg", this.user_teacher, this.courseDetails);
	}

	@Test
	public void testId() {		
		assertNotNull(this.course_qualidade_teste.getId());
		long id = 0500000;
		this.course_qualidade_teste.setId(id);		
		assertEquals(this.course_qualidade_teste.getId(), id);
	}
	
	@Test
	public void testTitle() {		
		assertEquals(course_qualidade_teste.getTitle(),"qualidade e teste");
	}
	
	@Test
	public void testImage() {	
		assertNotNull(this.course_qualidade_teste.getImage());
		String image = "quali.jpg";
		this.course_qualidade_teste.setImage(image);		
		assertEquals(this.course_qualidade_teste.getImage(), image);
	}
	
	@Test
	public void testTeacher() {	
		assertEquals(course_qualidade_teste.getTeacher(),course_programacao.getTeacher());
	}
	
	@Test
	public void testCourseDetails() {	
		assertNotNull(this.course_programacao.getCourseDetails());
		
		CourseDetails novoCourseDetails = mock(CourseDetails.class);
		this.course_programacao.setCourseDetails(novoCourseDetails);
		
		assertEquals(this.course_programacao.getCourseDetails(), novoCourseDetails);
		
	}
	
	@Test
	public void testAttenders() {
		assertEquals(course_qualidade_teste.getAttenders(),course_programacao.getAttenders());
	}
	
	/*public Set<Session> getSessions() {
		return sessions;
	}*/
	@Test
	public void testSessions() {		
		assertEquals(course_qualidade_teste.getSessions(),course_programacao.getSessions());
	}
	
	/*public boolean equals(Object other){
	    if (other == null) return false;
	    if (other == this) return true;
	    if (!(other instanceof Course))return false;
	    Course otherCourse = (Course)other;
	    return (otherCourse.id == this.id);
	}*/
	@Test
	public void testEquals() {
		assertFalse(this.course_qualidade_teste.equals(null));
		assertFalse(this.course_qualidade_teste.equals(new User()));
		assertTrue(this.course_qualidade_teste.equals(new Course()));
		
		Course copyId = new Course();
		copyId.setId(this.course_qualidade_teste.getId());
		
		assertTrue(this.course_qualidade_teste.equals(copyId));
	    	assertTrue(this.course_qualidade_teste.equals(this.course_qualidade_teste));
	}
	
	@Test
	public void testtToString() {
		String toString = "Course[title: \"" + this.course_programacao.getTitle() + "\", teacher: \"" + this.course_programacao.getTeacher().getNickName() + "\", #attenders: " + this.course_programacao.getAttenders().size() + ", #sessions: " + this.course_programacao.getSessions().size() + "]";
		assertEquals(this.course_programacao.toString(), toString);
	}
	
}
