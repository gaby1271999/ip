import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HayFork here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HayFork extends Actor
{
    private Actor actor;
    
    public HayFork(Actor actor) {
        this.actor = actor;
        this.setRotation(actor.getRotation());
    }
    
    Delay delay = new Delay(15);
    
    int i = 0;
    public void act(){
        setLocation(actor.getX(), actor.getY());
        
        if (!delay.isInDelay(false)) {
            if (i < 90) {
                turn(3);
                
                i+=3;
            } else {
                getWorld().removeObject(this);
            }
        }
    }    
}
