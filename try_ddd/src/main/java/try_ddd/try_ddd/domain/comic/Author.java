package try_ddd.try_ddd.domain.comic;

import java.util.Vector;

public class Author {
	
	

	private String firstName;
	private String lastName;
	private Vector<Comic> comics = new Vector<Comic>();
	
	public Author(String firstName, String lastName) throws IllegalArgumentException{
		
		
		this.setFirstName(firstName);
		this.setLastName(lastName);
	}
	
	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		if(firstName == null){
			throw new IllegalArgumentException("First and Lastname have to be set");
		}
		if(firstName.length() == 0){
			throw new IllegalArgumentException("First and Lastname need a stringlength > 0");
		}
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		if( lastName == null){
			throw new IllegalArgumentException("First and Lastname have to be set");
		}
		if( lastName.length() == 0){
			throw new IllegalArgumentException("First and Lastname need a stringlength > 0");
		}
		this.lastName = lastName;
	}
	
	public Author addComic(Comic comic){
		this.comics.addElement(comic);
		
		return this;
	}
	
	public Vector<Comic> getComics(){
		return this.comics;
	}
	

}
