package try_ddd.try_ddd.domain.comic;

import java.util.Vector;

import junit.framework.TestCase;

public class AuthorTest extends TestCase {
	
	public void testConstruct(){
		//first test if construct works
		String firstName = "test";
		String lastName = "test";
		Author author = null;
		try{
			author = new Author(firstName, lastName);
		}catch(IllegalArgumentException e){
			fail("constructor of Author should not throw an IllegalArgumentException, if first and lastName are passed");
		}
		assertEquals(firstName, author.getFirstName());
		assertEquals(lastName, author.getLastName());
		
		try{
			author = new Author("", "");
			fail("constructor of Author should throw an IllegalArgumentException, if first and lastName are empty or null");
		}catch(IllegalArgumentException e){
			
		}
		
		try{
			author = new Author(null, null);
			fail("constructor of Author should throw an IllegalArgumentException, if first and lastName are empty or null");
		}catch(IllegalArgumentException e){
			
		}
		
		
	}
	
	public void testAddComic(){
		Author author = new Author("test", "test");
		Comic comic = new Comic();
		
		assertEquals(0, author.getComics().size());
		
		author.addComic(comic);
		
		assertEquals(1, author.getComics().size());
		assertEquals(comic,author.getComics().get(0));
		
	}

}
