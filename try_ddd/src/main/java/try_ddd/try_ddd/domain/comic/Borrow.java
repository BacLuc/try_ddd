package try_ddd.try_ddd.domain.comic;

import java.util.Date;

import try_ddd.try_ddd.domain.comic.Copy.States;

public class Borrow {
	private Date startDate;
	private Date endDate;
	private Copy copy;
	private Friend friend;
	
	private Date givenBackDate = null;
	
	private States givenBackInState = null;

	public Borrow(Date startDate, Date endDate, Copy copy, Friend friend) {
		this.startDate = startDate;
		this.endDate = endDate;
		this.copy = copy;
		this.friend = friend;
		
	}

	public Date getStartDate() {
		return startDate;
	}

	

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public Copy getCopy() {
		return copy;
	}


	public Date getGivenBackDate() {
		return givenBackDate;
	}

	public void setGivenBackDate(Date givenBackDate) {
		this.givenBackDate = givenBackDate;
	}

	public States getGivenBackInState() {
		return givenBackInState;
	}

	public void setGivenBackInState(States givenBackInState) {
		this.givenBackInState = givenBackInState;
	}
	
	public Friend getFriend(){
		return this.friend;
	}
	
	
	
	
	

}
