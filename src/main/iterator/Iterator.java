package iterator;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ben Hu on 2016/11/8.
 */
public class Iterator {

    public static void main(String[] args) {

        List<String> strings = new ArrayList<>();

        strings.add("M");
        strings.add("O");
        strings.add("D");
        strings.add("E");

        java.util.Iterator<String> stringIterator = strings.iterator();
        while (stringIterator.hasNext()) {
            System.out.println(stringIterator.next());
        }

//        for (String string : strings) {
//            System.out.println(string);
//        }

//        strings.forEach(System.out::println);
    }
}
