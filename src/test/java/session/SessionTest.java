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
		session1.setDescription("Por mais que se planeje a construÃ§Ã£o de um software, erros sÃ£o passÃ­veis de ocorrer. Pode ser um bug num game, uma falha que feche um programa ou um erro que impossibilite vocÃª salvar um arquivo.");
		session1.setCourse(course_qualidade_teste);		
	}
	
	@Test
	public void testId() {
		assertNotNull(this.session1.getId());
		int id = 123;
		this.session1.setId(id);		
		assertEquals(this.session1.getCourse(), id);
	}
	
	@Test
	public void testTitle() {
		assertNotNull(this.session1.getTitle());
		String title = "Qualidade e teste session";
		this.session1.setTitle(title);		
		assertEquals(this.session1.getTitle(), title);
	}
	
	@Test
	public void testDescription() {
		assertNotNull(this.session1.getDescription());
		String description = "Por mais que se planeje";
		this.session1.setDescription(description);		
		assertEquals(this.session1.getDescription(), description);
	}
	
	@Test
	public void testDate() {
		assertNotNull(this.session1.getDate());
		long date = 07052021;
		this.session1.setDate(date);		
		assertEquals(this.session1.getDate(), date);
	}
	
	@Test
	public void testCourse() {
		assertNotNull(this.session1.getCourse());
		Course course = course_qualidade_teste;
		this.session1.setCourse(course);		
		assertEquals(this.session1.getCourse(), course);
	}
	
	@Test	
	public void testEquals() {
		assertNotNull(this.session1.getCourse());
		
		this.session1.setCourse(null);
		assertEquals(this.session1.getCourse(), null);//if (other == null) return false;
		
		Course course = course_qualidade_teste;
		this.session1.setCourse(course);		
		assertEquals(this.session1.getCourse(), course);
	}
	
	@Test
	public void testToString() {
		String session2 = "Session[title: \"" + this.session1.getTitle() + "\", description: \"" + this.session1.getDescription() + "\", date: \"" + this.session1.getDate() + "\"]";
		assertEquals(this.session1.toString(), session2);
	}
}
