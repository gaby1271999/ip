import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Number here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Number extends Actor {
    
    public Number(int number) {
        GreenfootImage img = new GreenfootImage("Numbers/Num" + String.valueOf(number) + ".png");
        setImage(img);
    }
    
    public void changeNumber(int number) {
        GreenfootImage img = new GreenfootImage("Numbers/Num" + String.valueOf(number) + ".png");
        setImage(img);
    }
}
