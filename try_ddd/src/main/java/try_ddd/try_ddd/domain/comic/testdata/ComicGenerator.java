package try_ddd.try_ddd.domain.comic.testdata;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import try_ddd.try_ddd.domain.comic.ComicCollection;

public class ComicGenerator {

	public static ComicCollection fillWithCopies(ComicCollection comiccollection) throws ParseException{
		DateFormat isoformat = new SimpleDateFormat("yyyy-mm-dd");
		comiccollection.addCopy("MyComic1", 1, 2010, isoformat.parse("2016-01-01"));
		comiccollection.addCopy("MyComic6", 1, 2010, isoformat.parse("2016-01-01"));
		comiccollection.addCopy("MyComic2", 1, 2010, isoformat.parse("2016-01-01"));
		comiccollection.addCopy("MyComic3", 1, 2010, isoformat.parse("2016-01-01"));
		comiccollection.addCopy("MyComic4", 1, 2010, isoformat.parse("2016-01-01"));
		comiccollection.addCopy("MyComic5", 1, 2010, isoformat.parse("2016-01-01"));
		
		
		return comiccollection;
	}
}
