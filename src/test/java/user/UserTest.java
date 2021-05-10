package user;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.fullteaching.backend.course.Course;
import com.fullteaching.backend.user.User;
import com.fullteaching.backend.user.UserRepository;

import static org.mockito.Mockito.mock;

public class UserTest {
	
	private User user;
	private Set<Course> courses;
	
	
	/*public User(String name, String password, String nickName, String picture, String... roles){
		this.name = name;
		this.passwordHash = new BCryptPasswordEncoder().encode(password);
		this.roles = new ArrayList<>(Arrays.asList(roles));
		
		this.nickName = nickName;
		if (picture != null && picture != "") {
			this.picture = picture;
		} else {
			this.picture = "/../assets/images/default_session_image.png";
		}
		this.registrationDate = System.currentTimeMillis();
		this.courses = new HashSet<>();
	}*/
	@BeforeEach
	public void testUser() {
		Course course_qualidade_teste = mock(Course.class);
		
		this.courses = new HashSet<>();
		courses.add(course_qualidade_teste);
		
		this.user = new User("nome", "senha", "nick", "", "admin", "mod");
		this.user.setCourses(courses);
	}
	
	/*public void setId(Long id) {
		this.id = id;
	}*/
	@Test
	public void testId() {
		assertNotNull(this.user.getId());
		long id = (long) 1.111;
		this.user.setId(id);
		assertEquals(this.user.getId(), id);
	}
	
	/*public void setName(String name) {
		this.name = name;
	}*/
	@Test
	public void testName() {
		assertEquals(this.user.getName(), "nome");
	}	
	
    /*public void setPasswordHash(String passwordHash) {
		this.passwordHash = passwordHash;
	}*/
	@Test
	public void testPasswordHash() {
		String passwordOld = this.user.getPasswordHash();
		this.user.setPasswordHash("novaSenha");
		String passwordNew = this.user.getPasswordHash();
		
		assertNotEquals(passwordOld, passwordNew);
		
	}
	
	/*public void setRoles(List<String> roles) {
		this.roles = roles;
	}*/
	@Test
	public void testRoles() {
		List<String> roles = new ArrayList<>(Arrays.asList("admin", "mod"));
		assertEquals(this.user.getRoles(), roles);
		
		roles.add("user");
		this.user.setRoles(roles);
		
		assertEquals(this.user.getRoles(), roles);
	}
	
	/*public void setNickName(String nickName) {
		this.nickName = nickName;
	}*/
	@Test
	public void testNickName() {
		assertEquals(this.user.getNickName(), "nick");
		
		String nickNew = "novoNick";
		this.user.setNickName(nickNew);
		
		assertEquals(this.user.getNickName(), nickNew);
	}
	
	/*public void setPicture(String picture) {
		this.picture = picture;
	}*/
	@Test
	public void testPicture() {
		assertEquals(this.user.getPicture(), "/../images/session_image1.jpg");

		String picUrl = "picture";
		this.usuarioPreenchido.setPicture(picUrl);
		
		assertEquals(this.user.getPicture(), picUrl);
	}
	
	/*public void setRegistrationDate(long registrationDate) {
		this.registrationDate = registrationDate;
	}*/
	@Test
	public void testRegistrationDate() {
		assertNotNull(this.user.getRegistrationDate());
		long date = (long) 10052021;
		this.user.setRegistrationDate(date);
		assertEquals(this.user.getRegistrationDate(),date);
	}
	
	/*public void setCourses(Set<Course> courses) {
		this.courses = courses;
	}*/
	
	void testSetCourses() {
		assertEquals(courses, this.user.getCourses());
		
		courses.add(mock(Course.class));
		this.user.setCourses(courses);
		
		assertEquals(courses, this.user.getCourses());
	}
	@Test
	void testEquals() {
		assertFalse(this.user.equals(null));
		assertFalse(this.user.equals(new Course()));
		
		assertTrue(this.user.equals(this.user));
		assertTrue(this.user.equals(new User("nome", "senha", "nick", "", "admin", "mod")));
	}
	
	@Test
	void testToString() {
		assertEquals(this.user.getNickName(), this.user.toString());
	}

	
}
