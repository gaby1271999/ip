import greenfoot.*;

/**
 * Write a description of class Char2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Char2 extends Avatar
{
    public Char2() {
        super(500, 3, Player.PLAYER_2);
        
        Player player = Player.PLAYER_2;
        
        MyWorld.setAvatar(player, (Avatar) this);
    }   
}
