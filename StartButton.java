import greenfoot.*;

public class StartButton extends Actor {
    
    public void act() {
       if (Greenfoot.mouseClicked(this)) {
           Characters char1 = SelectCharacter.char1;
           Characters char2 = SelectCharacter.char2;
           
           MyWorld myWorld = new MyWorld();
           
           Greenfoot.setWorld(myWorld);
           
           myWorld.setAvatar(Player.PLAYER_1, SelectCharacter.char1);
           myWorld.setAvatar(Player.PLAYER_2, SelectCharacter.char2);
           
           myWorld.prepare();
       }
    }    
}
