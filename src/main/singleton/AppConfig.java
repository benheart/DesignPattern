package singleton;

/**
 * Created by Ben Hu on 2016/11/4.
 */
public class AppConfig {

    private static AppConfig instance = new AppConfig();
    // constant
    public static final String NAME = "name";
    // variable
    private String path;

    /** Don't let anyone else instantiate this class */
    private AppConfig(){}

    /** Get appConfig Singleton */
    public static AppConfig getInstance() {
        return instance;
    }

    // getter and setter
    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
