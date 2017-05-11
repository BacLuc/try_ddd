package try_ddd.try_ddd.domain.comic;

import java.util.Vector;

public class Series {
	
	
	
	private String name;
	private Vector<Comic> comics;
	
	public Series(String name){
		this.name = name;
	}
	
	public Series add(Comic e) {
		comics.add(e);
		return this;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	
	

}
