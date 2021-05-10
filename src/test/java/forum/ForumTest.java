package forum;
import static org.mockito.Mockito.mock;

import java.util.List;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.fullteaching.backend.entry.Entry;
import com.fullteaching.backend.forum.Forum;

class ForumTest {
	
	Forum forum1;
	private List<Entry> entries;
	
	@BeforeEach
	public void testForum() {
		this.forum1 = new Forum (true);
		this.entries = forum1.getEntries();
	}
	
	@Test
	public void testId() {
		assertNotNull(this.forum1.getId());
		long Id = 69;
		this.forum1.setId(Id);
		
		assertEquals(this.forum1.getId(), Id);
	}
	
	@Test
	public void testActivated() {
		assertEquals(this.forum1.isActivated(), true);
	}
	
	@Test
	public void testEntries() {		
		assertEquals(this.forum1.getEntries(), entries);
	}
		
	@Test
	public void testToString() {
		String toString = "Forum[activated: \"" + forum1.isActivated() + "\", #entries: \"" + forum1.getEntries().size() + "\", #comments: \"" + 0 + "\"]";		
		assertEquals(this.forum1.toString(), toString);
	}

}
