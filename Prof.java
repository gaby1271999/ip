import greenfoot.*;

/**
 * Write a description of class Char2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Prof extends Avatar
{
    public Prof(Player player, HealthManager healthManager) {
        super(500, 3, player, healthManager);
    }   
    
    public void spawnAvatar(World world, int x, int y) {
        world.addObject(this, x, y);
    }
    
    public void attack() {
        super.getWorld().addObject(new Ruler((Actor) this), super.getX(), super.getY());
    }
    
    public void damage() {
        super.getDamageDelay().performDelay();
        
        super.setImage("prof_damage.png");
    }
}
