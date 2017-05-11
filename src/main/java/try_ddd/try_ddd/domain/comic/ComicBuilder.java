package try_ddd.try_ddd.domain.comic;

public class ComicBuilder {
	private Series series;
	private int num;
	private String title;
	private int year;
	
	public ComicBuilder(){}

	public void setSeries(Series series) {
		this.series = series;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setYear(int year) {
		this.year = year;
	}
	
	
	public Comic build(){
		return new Comic(this.num, this.title, this.num);
	}
}
