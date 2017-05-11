package java.try_ddd.try_ddd.domain.comic;

/**
 * Created by lucius on 11.05.17.
 */
public class test {
    private static test ourInstance = new test();

    public static test getInstance() {
        return ourInstance;
    }

    private test() {
    }
}
