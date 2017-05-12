package listtest;

/**
 * Created by lucius on 12.05.17.
 */
public class ListTestMain {
    private static String[] languages = new String[]{
            "Java", "Ruby", "Pascal", "C++", "C#", "Javascript", "Go", "Groovy", "PHP", "ObjectiveC", "Perl", "Python", "Scala", "R", "Fritz", "Hans"
    };

    public static void main(String[] args){
        long starttime;

        int repetitions = 10000;



        LanguageList list = new LanguageList();

        list.add("Java");
        list.add("PHP");
        list.add("Ruby");
        list.add("Pascal");
//        list.add("test");
//        list.add("Passetecal");
//        list.add("set");

        System.out.println("First test: "+ list.toString());

        list.remove("Ruby");
        System.out.println("Second test: "+ list.toString());





        starttime = System.currentTimeMillis();

        for(int i=0;i<repetitions;i++) {

            //first test foreach
             list = getFilledList();

            list.removeWithFor("Ruby");
        }



        System.out.println(String.format("Test with removeWithFor remove took: %s",System.currentTimeMillis()-starttime));


//
//        starttime = System.currentTimeMillis();
//
//        for(int i=0;i<repetitions;i++) {
//
//            //first test foreach
//            LanguageList list = getFilledList();
//
//            list.remove("Ruby");
//        }
//
//
//
//        System.out.println(String.format("Test with forEach remove took: %s",System.currentTimeMillis()-starttime));



//        starttime = System.currentTimeMillis();
//
//        for(int i=0;i<repetitions;i++) {
//
//            LanguageList list = getFilledList();
//
//            list.removeWithIterator("Ruby");
//        }
//
//
//
//        System.out.println(String.format("Test with removeWithIterator took: %s",System.currentTimeMillis()-starttime));


//        starttime = System.currentTimeMillis();
//
//        for(int i=0;i<repetitions;i++) {
//
//            //first test foreach
//            LanguageList list = getFilledList();
//
//            list.removeWithIteratorAndIndex("Ruby");
//        }
//
//
//
//        System.out.println(String.format("Test with normal removeWithIteratorAndIndex took: %s",System.currentTimeMillis()-starttime));
//

        starttime = System.currentTimeMillis();

        for(int i=0;i<repetitions;i++) {

            //first test foreach
             list = getFilledList();

            list.removeWithContains("Ruby");
        }



        System.out.println(String.format("Test with normal removeWithContains took: %s",System.currentTimeMillis()-starttime));










    }


    public static LanguageList getFilledList(){
        LanguageList list = new LanguageList();
        for(int i=0; i<1;i++){
            for(String name : languages){
                list.add(name);
            }
        }
        return list;
    }

}
