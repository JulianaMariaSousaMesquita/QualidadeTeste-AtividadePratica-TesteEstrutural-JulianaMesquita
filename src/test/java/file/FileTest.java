package file;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.fullteaching.backend.course.Course;
import com.fullteaching.backend.file.File;

class FileTest {
	
	File file1;
	File file2;
	File file3;
	
	@BeforeEach
	public void testFile() {
		this.file1 = new File(0,"file1_web-link.url");
		this.file2 = new File(1,"file2_pdf.pdf","www.fullteaching/file2.pdf");
		this.file3 = new File(2,"file3_video.mp4","www.fullteaching/file3.mp4",2);
	}
	
	
	@Test
	public void testId() {
		assertNotNull(this.file1.getId());
		long Id = 69;
		this.file1.setId(Id);
		
		assertEquals(this.file1.getId(), Id);
	}
	
	@Test
	public void testType() {
		int web = 0; //0: web-link | 1: pdf | 2: video
		int pdf = 1;
		int video = 2;
		
		assertEquals(this.file1.getType(), web);
		
		assertEquals(this.file2.getType(), pdf);
		
		assertEquals(this.file3.getType(), video);		
	}
	
	@Test
	public void testName() {
		assertNotNull(this.file2.getName());
		String name = "file2.pdf";
		this.file2.setName(name);		
		assertEquals(this.file2.getName(), name);
	}
	
	@Test
	public void testNameIdent() {
		assertNotNull(this.file3.getNameIdent());
		String name = "arquivo de video - file 3";
		this.file3.setNameIdent(name);		
		assertEquals(this.file3.getNameIdent(), name);
	}
	
	@Test
	public void testLink() {
		assertNotNull(this.file3.getLink());
		String link = "https://localhost:5000/file3.mp4";
		this.file3.setLink(link);		
		assertEquals(this.file3.getLink(), link);
	}
	
	@Test
	public void testIndexOrder() {
		assertNotNull(this.file3.getIndexOrder());
		int index = 0;
		this.file3.setIndexOrder(index);;		
		assertEquals(this.file3.getIndexOrder(), index);
	}
	
	@Test
	public void testEquals() {
		assertFalse(this.file1.equals(null));
		assertTrue(this.file1.equals(new File()));
		
		File copyId = new File();
		copyId.setId(this.file1.getId());
		
		assertTrue(this.file1.equals(copyId));
	    assertTrue(this.file1.equals(this.file1));
	}
	
	@Test
	public void testToString() {
		String toString = "File[name: \"file3_video.mp4\", id: \"arquivo de video - file 3\", link: \"www.fullteaching/file3.mp4\", indexOrder: 0]";
		assertEquals(this.file3.toString(), toString);
	}

}
