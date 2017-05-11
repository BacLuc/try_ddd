package try_ddd.try_ddd.domain.comic;

import junit.framework.TestCase;
import try_ddd.try_ddd.domain.comic.Author;
import try_ddd.try_ddd.domain.comic.Comic;
import try_ddd.try_ddd.domain.comic.Person;

public class AuthorTest extends TestCase {
	
	public void testConstruct(){
		//first test if construct works
		String firstName = "test";
		String lastName = "test";
		Person author = null;
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
		Comic comic = new Comic(1, "testComic", 2015);
		
		assertEquals(0, author.getComics().size());
		
		author.addComic(comic);
		
		
		assertEquals(1, author.getComics().size());
		assertEquals(comic,author.getComics().get(0));
		
	}

}
