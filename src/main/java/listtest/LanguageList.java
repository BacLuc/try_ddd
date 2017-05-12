package listtest;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.StringJoiner;

/**
 * Created by lucius on 12.05.17.
 */
public class LanguageList {

    private ArrayList<Language> languageList;

    public LanguageList() {
        this.languageList = new ArrayList<>();
    }

    public boolean add(String name) {
        return languageList.add(new Language(name));
    }

    public void remove(String name){
       Language language = new Language(name);

       for(Language lang : languageList){
           if(lang.equals(language)){
               languageList.remove(lang);
           }
       }
    }

    public void removeWithIterator(String name){
        Language language = new Language(name);


        int size = languageList.size();

        Iterator<Language> iterator= languageList.iterator();

        while(iterator.hasNext()){
            Language lang = iterator.next();
            if(lang.equals(language)){
                languageList.remove(lang);
            }
        }
    }

    public void removeWithIteratorAndIndex(String name){
        Language language = new Language(name);


        Iterator<Language> iterator= languageList.iterator();

        while(iterator.hasNext()){
            Language lang = iterator.next();
            if(lang.equals(language)){
                languageList.remove(languageList.indexOf(lang));
            }
        }
    }

    public void removeWithContains(String name){
        Language language = new Language(name);

        while(languageList.contains(language)){
            languageList.remove(language);
        }
    }

    public void removeWithFor(String name){
        Language language = new Language(name);


        for(int i = 0; i<languageList.size();i++){
            if(language.equals(languageList.get(i))){
                languageList.remove(i);

            }
        }
    }



    public String toString(){


        StringJoiner joiner = new StringJoiner(",");

        languageList.forEach(language -> joiner.add(language.getName()));

        return "["+joiner.toString()+"]";
    }




}
