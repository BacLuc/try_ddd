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


        int size = languageList.size();

        Iterator<Language> iterator= languageList.iterator();

       for(Language lang : languageList){
           if(lang.equals(language)){
               languageList.remove(lang);
           }
       }
    }

    public String toString(){


        StringJoiner joiner = new StringJoiner(",");

        languageList.forEach(language -> joiner.add(language.getName()));

        return "["+joiner.toString()+"]";
    }




}
