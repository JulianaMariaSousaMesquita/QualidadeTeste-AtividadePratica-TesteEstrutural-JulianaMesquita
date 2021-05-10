package session;

import static org.mockito.Mockito.mock;

import java.util.HashSet;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.fullteaching.backend.course.Course;
import com.fullteaching.backend.session.Session;
import com.fullteaching.backend.user.User;

class SessionTest {
	
	private Course course_qualidade_teste;
	private Set<Course> courses;
	private Session session1;
		
	@BeforeEach
	public void testSession() {
		Course course_qualidade_teste = mock(Course.class);	
		session1 = mock(Session.class);
		this.courses = new HashSet<>();
		
		courses.add(course_qualidade_teste);		
		session1.setDate(07052021);
		session1.setTitle("Qualidade e teste");
		session1.setDescription("Por mais que se planeje a construção de um software, erros são passíveis de ocorrer. Pode ser um bug num game, uma falha que feche um programa ou um erro que impossibilite você salvar um arquivo.");
		session1.setCourse(course_qualidade_teste);		
	}
	
	@Test
	public void testId() {
		long id = session1.getId();
		assertEquals(session1.getId(),id);		
	}
	
	@Test
	public void testTitle() {
		assertEquals(session1.getTitle(),"Qualidade e teste");
	}
	
	@Test
	public void testDescription() {
		assertEquals(session1.getDescription(),"Por mais que se planeje a construção de um software, erros são passíveis de ocorrer. Pode ser um bug num game, uma falha que feche um programa ou um erro que impossibilite você salvar um arquivo.");
	}
	
	@Test
	public void testDate() {
		assertEquals(session1.getDate(),07052021);
	}
	
	@Test
	public void testCourse() {
		assertEquals(session1.getCourse(),course_qualidade_teste);
	}
	
	@Test	
	public void testEquals() {
		boolean id = session1.equals(course_qualidade_teste);
		assertEquals(true,id);
	}
	
	@Test
	public void testToString() {
		Session session2 = session1;
		assertEquals(this.session1, session2);
	}
}
