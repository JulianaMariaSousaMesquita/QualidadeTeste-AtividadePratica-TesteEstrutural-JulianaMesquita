package comment;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

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
		Comment comentario;
		Comment comentario2;
		Comment comentario3;
		
		assertThat(comentario2.getId(), notNullValue());
		assertThat(comentario2.getDate(), equalTo(202020L));
		assertThat(comentario2.getMessage(), containsString("Mensagem 1 - ola mundo"));
		assertThat(comentario3.getCommentParent(), equalTo(comentario2));
		assertThat(comentario3.getReplies(), notNullValue());
		assertThat(comentario, instanceOf(Comment.class));
		
		String toString = "Comment[message: \"null\", author: \"\", parent: \"null\", #replies: 0date: \"0\"]";
		String toString2 = "Comment[message: \"Mensagem 1 - ola mundo\", author: \"null\", parent: \"null\", #replies: 0date: \"202020\"]";
		String toString3 = "Comment[message: \"Mensagem 2\", author: \"null\", parent: \"Mensagem 1 - ola mundo\", #replies: 0date: \"20805\"]";

		assertEquals(comentario.toString(), toString);
		assertEquals(comentario2.toString(), toString2);
		assertEquals(comentario3.toString(), toString3);
	}		
	
}
