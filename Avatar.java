
import greenfoot.*;
import java.util.*;

abstract class Avatar extends Actor {
    
    private MyWorld myWorld = new MyWorld();
    
    private int health, stamina, moveSpeed;
    private Player player;
    private HealthBar healthBar;
    
    public Avatar(int stamina, int moveSpeed, Player player, HealthBar healthBar) {
        this.health = myWorld.HEALTH;
        this.stamina = stamina;
        this.moveSpeed = moveSpeed;
        this.player = player;
        this.healthBar = healthBar;
    }
    
    public void setHealth(int health) {
        this.health = health;
    }
    
    public int getHealth() {
        return this.health;
    }
    
    public void act() {
        controls();
        
        aanval();
    }
    
    private void controls() {
        if (getMovement() == Movement.LEFT) {
            setRotation(180);
            move(4);
        } else if (getMovement() == Movement.RIGHT) {
            setRotation(0);
            move(4);
        } else if (getMovement() == Movement.UP) {
            setRotation(-90);
            move(4);
        } else if (getMovement() == Movement.DOWN) {
            setRotation(90);
            move(4);
        }
    }
    
    private Movement getMovement() {
        if (Player.PLAYER_1 == this.player) {
            if (Greenfoot.isKeyDown("q")) {
                return Movement.LEFT;
            } else if (Greenfoot.isKeyDown("d")) {
                return Movement.RIGHT;
            } else if (Greenfoot.isKeyDown("z")) {
                return Movement.UP;
            } else if (Greenfoot.isKeyDown("s")) {
                return Movement.DOWN;
            }
        } else {
            if (Greenfoot.isKeyDown("4")) {
                return Movement.LEFT;
            } else if (Greenfoot.isKeyDown("6")) {
                return Movement.RIGHT;
            } else if (Greenfoot.isKeyDown("8")) {
                return Movement.UP;
            } else if (Greenfoot.isKeyDown("5")) {
                return Movement.DOWN;
            }
        }
        
        return null;
    }
    
    private void aanval() {
        if(getAction() == Action.MELEE) {
            List<Avatar> enemys = getObjectsInRange(100, Avatar.class);
            
            if (enemys != null && !enemys.isEmpty()) {
                Avatar enemy = enemys.get(0);

                enemy.setHealth(enemy.getHealth() - 50);
                
                enemy.getHealthBar().addDamage(50);
                
                //DELAY
                Greenfoot.delay(500);
            }
        }
    }
    
    private Action getAction() {
        if (Player.PLAYER_1 == this.player) {
            if (Greenfoot.isKeyDown("7")) {
                return Action.MELEE;
            } else if (Greenfoot.isKeyDown("9")) {
                return Action.ULT;
            }
        } else {
            if (Greenfoot.isKeyDown("a")) {
                return Action.MELEE;
            } else if (Greenfoot.isKeyDown("e")) {
                return Action.ULT;
            }
        }
        
        return null;
    }
    
    abstract void spawnAvatar(World world, int x, int y);
    
    public HealthBar getHealthBar() {
        return this.healthBar;
    }
    
    private enum Action {
        MELEE, ULT;
    }
    
    private enum Movement {
        LEFT, RIGHT, UP, DOWN;
    }
}
