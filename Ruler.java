import greenfoot.*;

public class Ruler extends Actor {
    private Actor actor;
    
    public Ruler(Actor actor) {
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
