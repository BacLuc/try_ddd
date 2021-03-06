package try_ddd.try_ddd.domain.comic;

public class Person {

	private String firstName;
	private String lastName;

	public Person(String firstName, String lastName) throws IllegalArgumentException {
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

	public String toString() {
		return String.format("%s %s", this.getFirstName(), this.getLastName());
	}

}