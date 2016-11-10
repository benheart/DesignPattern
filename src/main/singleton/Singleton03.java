package singleton;

/**
 * Created by Ben Hu on 2016/11/7.
 */
public class Singleton03 {

    private static Singleton03 instance = new Singleton03();
    private Singleton03 (){}
    public static Singleton03 getInstance() {
        return instance;
    }
}
