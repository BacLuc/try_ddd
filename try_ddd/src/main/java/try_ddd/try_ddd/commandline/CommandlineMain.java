package try_ddd.try_ddd.commandline;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import try_ddd.try_ddd.domain.comic.Comic;
import try_ddd.try_ddd.domain.comic.ComicBuilder;
import try_ddd.try_ddd.domain.comic.ComicCollection;
import try_ddd.try_ddd.domain.comic.Copy;
import try_ddd.try_ddd.domain.comic.testdata.ComicGenerator;

public class CommandlineMain {
	
	public static ComicCollection collection;
	
	public static final String[] START_OPTIONS = new String[]{
			"Manage Borrows"
			,"Add Copy"
			,"Manage Comics"
			,"Manage Friends"
	};
	
	public static final String[] COMIC_OPTIONS = new String[]{
			"Add Comic"
	};
	
	public static BufferedReader reader;
	
	
	
	

	public static void main(String[] args) throws IOException, ParseException {
		collection = new ComicCollection();
		collection = ComicGenerator.fillWithCopies(collection);
		reader = new BufferedReader(new InputStreamReader(System.in));
		
		System.out.println("Welcome to the command line interface of the Comiccollection.");
		System.out.println("To go back to the main menu, you can always type btm when input is required");
		
		while(true){
			try{
		
				System.out.println("What do you want to do?");
				printOptions(CommandlineMain.START_OPTIONS);
				
				String input = reader.readLine();
				
				try{
					int chosen = Integer.parseInt(input);
					switch(chosen){
						case 0:
							
							break;
						case 1:
							addCopy();					
							break;
						case 2:
							
							break;
						case 3:
							manageComics();
							break;
						default:
							throw new NumberFormatException();
					}
				}catch(NumberFormatException e){
					System.out.println("You typed an invalid Option, please type a Number in the specified range");
				}
			}catch(ResetException e){
				
			}
		}
		
		
		

	}
	
	private static void addCopy() throws IOException, ResetException {
		
		Map<Comic,List<Copy>> comicList = collection.getAllComics();
		
		ArrayList optionsList = comicList.entrySet()
				.stream()
				.map( 
							k -> {
							Comic key = k.getKey();
							return String.format("%s", key.getTitle());
						}
					)
				.collect(Collectors.toCollection(ArrayList::new));
				;
		optionsList.add("Create new");
		final String[] options = (String[]) optionsList.toArray(new String[optionsList.size()]);
		
		
		
		int chosen = -1;
		do{
			System.out.println("Choose an existing comic or create a new one");
			printOptions(options);
			String input = reader.readLine();
			checkCancel(input);
			try{
				chosen = Integer.parseInt(input);
				
				if(chosen <0 || chosen >= options.length){
					throw new NumberFormatException();
				}
				
			}catch(NumberFormatException e){
				System.out.println("You didn't type a number");
				
			}
		}while(chosen == -1);
		
		
		final int realchosen = chosen;
		Comic comic = null;
		if(chosen == options.length-1){
			 ComicBuilder comicbuilder = buildComic();
			 comic = comicbuilder.build();
		}else{
			Optional<Comic> comicOptional = comicList.keySet().stream()
					.filter(e -> e.getTitle().equals(options[realchosen]) )
					.findFirst();
			;
			if(comicOptional.isPresent()){
				comic = comicOptional.get();
			}else{
				 ComicBuilder comicbuilder = buildComic();
				 comic = comicbuilder.build();
			}
			
		}
		chosen = -1;
		Date date = new Date();
		do{
			
			System.out.println("Now enter the Date the Copy was bought:");
			String input = reader.readLine();
			checkCancel(input);
			try{
				DateFormat isoformat = new SimpleDateFormat("yyyy-mm-dd");
				date = isoformat.parse(input);
				
				
				chosen = 1;
				
				
			}catch(ParseException e){
				System.out.println("You didn't type a date");
				
			}
		}while(chosen == -1);
		
		
		collection.addCopy(comic, date);
		
	}

	public static void printOptions(String[] options){
		int counter = 0;
		for(String option:options){
			System.out.println(String.format("%d : %s", counter++, option));
		}

		System.out.print(String.format("Choose an option between 0 and %d: ",counter-1));
	}
	
	
	public static void manageComics() throws IOException, ResetException{
		System.out.println("You want to Manage Comics. Choose your further option:");
		printOptions(COMIC_OPTIONS);
		String input = reader.readLine();
		
		try{
			int chosen = Integer.parseInt(input);
			switch(chosen){
				case 0:
					buildComic();
					break;
				case 1:
										
					break;
				case 2:
					
					break;
				case 3:
					
					break;
				default:
					throw new NumberFormatException();
			}
		}catch(NumberFormatException e){
			System.out.println("You typed an invalid Option, please type a Number in the specified range");
		}
	}
	
	public static ComicBuilder buildComic() throws IOException, ResetException{
		//System.out.println("You want to add a comic, first type the name of the series:");
		
		ComicBuilder builder = new ComicBuilder();
		int chosen = -1;
		do{
			
			System.out.println("You want to add a comic, first type the number:");
			String input = reader.readLine();
			checkCancel(input);
			try{
				chosen = Integer.parseInt(input);
				builder.setNum(chosen);
				
			}catch(NumberFormatException e){
				System.out.println("You didn't type a number");
				
			}
		}while(chosen == -1);
		chosen = -1;
		do{
			
			System.out.println("You want to add a comic, now type the title with at least 4 characters:");
			String input = reader.readLine();
			checkCancel(input);
			
			if(input.length() > 4){
				chosen = 1;
				builder.setTitle(input);
				
			}else{
				System.out.println("Please write a valid title with at least 4 characters");
			}
		}while(chosen == -1);
		
		
		chosen = -1;
		do{
			
			System.out.println("You want to add a comic, now type the year with 4 digits:");
			String input = reader.readLine();
			checkCancel(input);
			try{
				if(input.length() == 4){
					chosen = Integer.parseInt(input);
					builder.setYear(chosen);
				}else{
					throw new NumberFormatException();
				}
				
			}catch(NumberFormatException e){
				System.out.println("You didn't type a number");
				
			}
		}while(chosen == -1);
		
		return builder;
		
		
	}
	
	public static void checkCancel(String input) throws ResetException{
		if(input.equals("btw")){
			throw new ResetException();
		}
	}
	

}
