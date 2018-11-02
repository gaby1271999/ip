import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Char1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Char1 extends Avatar {
 
    public Char1() {
        super(500, 3, Player.PLAYER_1);
        
        Player player = Player.PLAYER_1; 
        
        MyWorld.setAvatar(player, (Avatar) this);
    }
}
