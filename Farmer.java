import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Char1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Farmer extends Avatar {
 
    public Farmer(Player player, HealthBar healthBar) {
        super(500, 3, player, healthBar); 
        
        MyWorld.setAvatar(player, (Avatar) this);
    }
    
    public void spawnAvatar(World world, int x, int y) {
        world.addObject(this, x, y);
    }
}
