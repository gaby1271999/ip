import greenfoot.*;

public class No extends Actor {
    GreenfootSound MyMusic = new GreenfootSound("chicken.mp3");

    public void act() { 

        if(getWorld().getObjects(Chicken.class).size() == 0){
            if (Greenfoot.mouseClicked(this)) {
                Chicken chicken = new Chicken();
                EndScreen.endScreen.addObject (chicken,1595,512);
            }
        }
    }
}
