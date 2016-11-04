package singleton_pattern;

/**
 * Created by Ben Hu on 2016/11/4.
 */
public class TestDemo {

    public static void main(String[] args) {
        AppConfig appConfig = AppConfig.getInstance();

        // set variable
        appConfig.setPath("path");
        // print variable
        System.out.println(appConfig.getPath());

        // print constant
        System.out.println(AppConfig.NAME);
    }
}
