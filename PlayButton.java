import greenfoot.*;

public class PlayButton extends Actor {
    public void act() 
    {
        if (Greenfoot.mouseClicked(this)) {
            SelectCharacter selectCharacter = new SelectCharacter();
            Greenfoot.setWorld(selectCharacter);
        }
    }     
}
