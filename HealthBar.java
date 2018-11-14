import greenfoot.*;
public class HealthBar extends Actor {
    
    private Player player;
    
    public HealthBar(Player player) {
        this.player = player;
    }
    
    public void addDamage(double damage) {
        double healthBar = (double)MyWorld.HEALTH_BAR;
        double health = (double)MyWorld.HEALTH;
        
        double ratio = healthBar/health;
        
        double move = damage*ratio;
        
        System.out.println(this.player);
        
        if (Player.PLAYER_1 == player) {
            move((int) move);
        } else {
            setRotation(180);
            move((int) move);
        }
    }
    
    
    public String getPlayer() {
        return this.player.toString();
    }
}
