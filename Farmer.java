import greenfoot.*;

public class Farmer extends Avatar {
 
    public Farmer(Player player, HealthManager healthManager) {
        super(500, 3, player, healthManager);
    }
    
    public void spawnAvatar(World world, int x, int y) {
        world.addObject(this, x, y);
    }
    
    public void attack() {
        super.getWorld().addObject(new HayFork((Actor) this), super.getX(), super.getY());
    }
    
    public void damage() {
        super.getDamageDelay().performDelay();
        
        super.setImage("farmer_damage.png");
    }
   
    
}
