package FactoryPattern;

/**
 * Author: Ben Hu
 * Date: 2016/10/3 at 10:32
 */
public class Square implements Shape{
    @Override
    public void draw() {
        System.out.println("Inside Square::draw() method.");
    }
}
