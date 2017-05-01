package try_ddd.try_ddd.domain.comic;

import java.util.ArrayList;
import java.util.stream.Collectors;

import org.apache.commons.validator.routines.EmailValidator;



public class Friend extends Person {

	private String emailAddress;
	private ArrayList<Borrow> borrowed = new ArrayList<Borrow>();
	private ArrayList<Borrow> currentlyBorrowed = new ArrayList<Borrow>();
	public static final int ALLOWED_CONCURRENT_BORROWS = 4;
	
	public Friend(String firstName, String lastName, String emailAddress) throws IllegalArgumentException {
		super(firstName, lastName);
		this.setEmailAddress(emailAddress);
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public Friend setEmailAddress(String emailAddress) {
		EmailValidator validator = EmailValidator.getInstance();
		if(!validator.isValid(emailAddress)){
			throw new IllegalArgumentException("Invalid Email Address");
		}
		this.emailAddress = emailAddress;
		return this;
	}
	
	public Friend addBorrow(Borrow borrow){
		if(borrow.getGivenBackDate() == null){
			if(this.canBorrow()){
				throw new TooManyBorrowsException();
			}
			
		}
		
		this.borrowed.add(borrow);
		
		
		
		return this;
	}
	
	public boolean canBorrow(){
		this.updateCurrentlyBorrowed();
		return this.currentlyBorrowed.size()< Friend.ALLOWED_CONCURRENT_BORROWS;
	}
	
	private void updateCurrentlyBorrowed(){
		this.currentlyBorrowed = new ArrayList<Borrow>();
		
		this.currentlyBorrowed = this.borrowed.stream()
		.filter(e -> e.getGivenBackDate() == null)
		.collect(Collectors.toCollection(ArrayList::new))
		;
		
	}
	
	public ArrayList<Borrow> getBorrowed(){
		return this.borrowed;
	}
	
	public ArrayList<Borrow> getCurrentlyBorrowed(){
		this.updateCurrentlyBorrowed();
		return this.borrowed;
	}
	
	
	
	
	

}
