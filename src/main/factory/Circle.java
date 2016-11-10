package factory;

/**
 * Author: Ben Hu
 * Date: 2016/10/3 at 10:49
 */
public class Circle implements Shape {

    @Override
    public void draw() {
        System.out.println("Inside Circle::draw() method.");
    }
}