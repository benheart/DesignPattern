package singleton;

/**
 * Created by Ben Hu on 2016/11/7.
 */
public class Singleton05 {

    private static class SingletonHolder {
        private static final Singleton05 INSTANCE = new Singleton05();
    }
    private Singleton05 (){}
    public static final Singleton05 getInstance() {
        return SingletonHolder.INSTANCE;
    }
}
