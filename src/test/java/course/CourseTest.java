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
		long id = course_programacao.getId();
		assertEquals(course_programacao.getId(),id);
	}
	
	@Test
	public void testTitle() {		
		assertEquals(course_qualidade_teste.getTitle(),"qualidade e teste");
	}
	
	@Test
	public void testImage() {		
		assertEquals(course_qualidade_teste.getImage(),"quali.jpg");
		assertEquals(course_qualidade_teste.getImage(),"prog.jpg");
		assertEquals(course_programacao.getImage(),"prog.jpg");
		assertEquals(course_programacao.getImage(),"quali.jpg");
	}
	
	@Test
	public void testTeacher() {	
		assertEquals(course_qualidade_teste.getTeacher(),course_programacao.getTeacher());
	}
	
	@Test
	public void testCourseDetails() {	
		assertEquals(course_qualidade_teste.getCourseDetails(),course_programacao.getCourseDetails());
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
	
	@Test
	public void testEquals() {
		assertEquals(course_qualidade_teste.equals(user_teacher), true);
	}
	
	/*public String toString() {
		return "Course[title: \"" + this.title + "\", teacher: \"" + this.teacher.getNickName() + "\", #attenders: " + this.attenders.size() + ", #sessions: " + this.sessions.size() + "]";
	}*/
	@Test
	public void testtToString() {
		assertEquals(course_qualidade_teste.toString(),this.course_qualidade_teste);
	}
	
}
