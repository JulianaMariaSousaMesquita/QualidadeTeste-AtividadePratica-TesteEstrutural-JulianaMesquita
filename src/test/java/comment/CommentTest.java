package comment;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertNotNull;

import com.fullteaching.backend.comment.Comment;
import com.fullteaching.backend.user.User;


class CommentTest {
	private Comment commentParent;
	private List<Comment> replies;
	private User user;
	private Comment coment1;
	private Comment coment2;
	
	@BeforeEach
	public void testComment() {
		this.user = mock(User.class);
				
		this.coment1 =  new Comment("Lorem ipsum dolor sit amet, consectetur adipiscing elit.", 07052021, this.user);
		this.coment2 =  new Comment("Quisque in lacus vulputate, feugiat odio ultricies, tempus neque.", 07052021, this.user, coment1);
	}
	
	@Test
	public void testId() {
		this.coment1.setId(69);		
		assertEquals(this.coment1.getId(), 69);
	}
	
	@Test
	public void testMessage() {
		this.coment2.setMessage("Mudando msg para teste");
		assertEquals(this.coment2.getMessage(), "Mudando msg para teste");
	}
	
	@Test
	public void testDate() {
		assertEquals(this.coment1.getDate(),this.coment2.getDate());
	}
	
	@Test
	public void testReplies() {		
		Comment reply = new Comment("Testando replies, msg coment2", 07052021, this.user);
		List<Comment> replies = new ArrayList<Comment>();
		replies.add(reply);
		this.coment2.setReplies(replies);
		
		assertEquals(this.coment2.getReplies(), replies);
	}
	
	@Test
	public void testUser() {
		User userNew = mock(User.class);
		this.coment2.setUser(userNew);
		assertEquals(this.coment2.getUser(), userNew);
	}
	
	@Test
	public void testCommentParent(){
		Comment coment3 =  new Comment();
		this.coment2.setCommentParent(coment3);
		assertEquals(this.coment2.getCommentParent(), coment3);
	}
	
	@Test
	public void testToString() {	
		String[] roles = {"TEACHER"};
		User u =  new User("mock", "Pass1234", "mock", null, roles);
		Long date = System.currentTimeMillis();
		String message = "Lorem ipsum dolor sit amet, consectetur adipiscing elit.";
		Comment parent = new Comment(message, date, u);
		
		Comment comment = new Comment();
		comment.setCommentParent(parent);
		assertNotNull(comment.toString(), comment);
	}		
	
}
