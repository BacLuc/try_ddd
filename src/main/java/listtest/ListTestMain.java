package listtest;

/**
 * Created by lucius on 12.05.17.
 */
public class ListTestMain {

    public static void main(String[] args){
        LanguageList list = new LanguageList();

        list.add("Java");
        list.add("PHP");
        list.add("Ruby");
        list.add("Pascal");

        System.out.println("First test: "+ list.toString());

        list.remove("Ruby");
        System.out.println("Second test: "+ list.toString());



    }

}
