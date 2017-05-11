package try_ddd.try_ddd.domain.comic;

import java.util.ArrayList;

public class Author extends Person {
	
	

	private ArrayList<Comic> comics = new ArrayList<Comic>();
	
	public Author(String firstName, String lastName) throws IllegalArgumentException{
		
		
		super(firstName, lastName);
	}
	
	public Author addComic(Comic comic){
		this.comics.add(comic);
		
		return this;
	}
	
	public ArrayList<Comic> getComics(){
		return this.comics;
	}
	

}
