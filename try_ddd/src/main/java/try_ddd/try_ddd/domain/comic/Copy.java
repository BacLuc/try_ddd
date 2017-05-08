package try_ddd.try_ddd.domain.comic;

import java.util.Date;
import java.util.ArrayList;

public class Copy {
	private Comic comic;
	private Date boughtAt;
	private ArrayList<Borrow> borrowed = new ArrayList<Borrow>();
	private States state;
	
	public enum States {
		NEW,LITTLE_DAMAGED, DAMAGED, UNUSABLE
	}
	
	public Copy(Comic comic, Date boughtAt) {
		this.comic = comic;
		this.boughtAt = boughtAt;
	}
	
	public Comic getComic(){
		return this.comic;
	}

	public Date getBoughtAt() {
		return boughtAt;
	}

	

	public ArrayList<Borrow> getBorrowed() {
		return borrowed;
	}
	
	public boolean inStock(){
		return this.getBorrowed()
				.stream()
				.filter(borrow -> borrow.getGivenBackDate() == null)
				.count() == 0;
	}

	

	public Copy addBorrow(Borrow e) {
		borrowed.add(e);
		return this;
	}
	
	public States getState(){
		return this.state;
	}
	
	public Copy setState(States state){
		this.state = state;
		return this;
	}

	
	
	
	
	

}
