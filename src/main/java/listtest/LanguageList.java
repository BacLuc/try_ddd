package listtest;

import java.util.ArrayList;
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

        for(int i = 0; i<size;i++){
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
