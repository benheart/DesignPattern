package singleton;

/**
 * Created by Ben Hu on 2016/11/7.
 */
public class Singleton {

    private static Singleton instance = new Singleton();
    private Singleton(){}
    public static Singleton getInstance() {
        return instance;
    }
}
