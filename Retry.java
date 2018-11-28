import greenfoot.*;

public class Retry extends Actor {
    
    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            if (EndScreen.no.MyMusic.isPlaying()) {
                EndScreen.no.MyMusic.stop();
            }
            
            MyWorld.stopped = false;
            Greenfoot.setWorld(new StartScreen());
        }
    }      
}
