package try_ddd.try_ddd.domain.comic;

import java.util.Enumeration;
import java.util.ArrayList;

public class Comic {
	
	private int num;
	private String title;
	private int year;
	private ArrayList<Author> authors;
	private Series series;
	public Comic(int num, String title, int year) {
		this.num = num;
		this.title = title;
		this.year = year;
	}
	public int getNum() {
		return num;
	}
	public void setNum(int num) {
		this.num = num;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public Series getSeries() {
		return series;
	}
	public void setSeries(Series series) {
		this.series = series;
	}
	public ArrayList<Author> elements() {
		return this.authors;
	}
	public Comic add(Author e) {
		
		this.authors.add(e);
		return this;
	}
	
	
	
	

}
