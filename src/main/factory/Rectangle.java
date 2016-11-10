package factory;

/**
 * Author: Ben Hu
 * Date: 2016/10/3 at 10:30
 */
public class Rectangle implements Shape {

    @Override
    public void draw() {
        System.out.println("Inside Rectangle::draw() method.");
    }
}
