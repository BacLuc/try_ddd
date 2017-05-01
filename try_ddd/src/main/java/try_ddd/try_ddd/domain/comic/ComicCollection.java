package try_ddd.try_ddd.domain.comic;

import java.util.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import try_ddd.try_ddd.domain.comic.Copy.States;

public class ComicCollection {
	private ArrayList<Copy> copies = new ArrayList<>();
	
	private ArrayList<Friend> friends = new ArrayList<>();
	
	private ArrayList<Comic> comics = new ArrayList<>();
	
	public void addFriend(String firstName, String lastName, String emailAddress){
		Friend friend = new Friend(firstName, lastName, emailAddress);
		this.friends.add(friend);
	}
	
	public void addCopy(String title, int num, int year, Date boughtAt){
		
		Comic comic = new Comic(num, title, year);
		
		this.addCopy(comic, boughtAt);
		
	}
	
	public void addCopy(Comic comic, Date boughtAt){
		Copy copy = new Copy( comic, boughtAt);
		this.copies.add(copy);
	}
	
	public void borrow(Date startDate, Date endDate,Copy copy, Friend friend){
		Borrow borrow = new Borrow(startDate, endDate, copy, friend);
		friend.addBorrow(borrow);
		copy.addBorrow(borrow);
	}
	
	public void bringBack(Borrow borrow){
		Date date = new Date();
		borrow.setGivenBackDate(date);
		bringBackSameState(borrow);
	}
	
	public void bringBack(Borrow borrow, Date bringBackDate){
		borrow.setGivenBackDate(bringBackDate);
		bringBackSameState(borrow);
	}
	
	public void bringBack(Borrow borrow, States bringBackState){
		bringBack(borrow);
		borrow.setGivenBackInState(bringBackState);
	}
	
	public void bringBack(Borrow borrow, Date bringBackDate, States bringBackState){
		borrow.setGivenBackDate(bringBackDate);
		borrow.setGivenBackInState(bringBackState);
	}

	private void bringBackSameState(Borrow borrow) {
		borrow.setGivenBackInState(borrow.getCopy().getState());
	}
	
	
	public ArrayList<Friend> getFriends(){
		return this.friends;
	}
	
	public ArrayList<Copy> getCopies(){
		return this.copies;
	}
	
	public Map<Comic,List<Copy>> getAllComics(){
		return this.getCopies().stream()
				.collect(Collectors.groupingBy(Copy::getComic))
				;
	}
	
	
	public Map<Comic,List<Copy>> getAvailableComics(){
		return this.getCopies().stream()
				.filter(copy -> copy.inStock())
				.collect(Collectors.groupingBy(Copy::getComic))
				;
	}
	
	

}
