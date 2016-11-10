package singleton;

/**
 * Created by Ben Hu on 2016/11/7.
 */
public class Singleton02 {

    private static Singleton02 instance;
    private Singleton02 (){}
    public static synchronized Singleton02 getInstance() {
        if (instance == null) {
            instance = new Singleton02();
        }
        return instance;
    }
}
