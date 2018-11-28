
import greenfoot.*;
import java.util.*;

abstract class Avatar extends Actor {
    
    private MyWorld myWorld = new MyWorld();
    
    private int health, stamina, moveSpeed;
    private Player player;
    private HealthManager healthManager;
    private Delay attackDelay = new Delay(500), damageDelay = new Delay(100);
    
    public Avatar(int stamina, int moveSpeed, Player player, HealthManager healthManager) {
        this.health = myWorld.HEALTH;
        this.stamina = stamina;
        this.moveSpeed = moveSpeed;
        this.player = player;
        this.healthManager = healthManager;
    }
    
    public void setHealth(int health) {
        this.health = health;
    }
    
    public int getHealth() {
        return this.health;
    }
    
    public void act() {
        if (!MyWorld.stopped) {
            controls();
            
            aanval();
            
            if (!damageDelay.isInDelay(false)) {
                if (this instanceof Farmer) {
                    setImage("farmer.png");
                } else if (this instanceof Prof) {
                    setImage("prof.png");
                }
            }
    }
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
        if (!attackDelay.isInDelay(false)) {
            if(getAction() == Action.MELEE) {
                if (this instanceof Farmer) {
                    ((Farmer) this).attack();
                } else if (this instanceof Prof) {
                    ((Prof) this).attack();
                }
                
                List<Avatar> enemys = getObjectsInRange(100, Avatar.class);
                
                if (enemys != null && !enemys.isEmpty()) {
                    Avatar enemy = enemys.get(0);
    
                    enemy.damageDistibutor(50, player);
                    
                    if (enemy instanceof Farmer) {
                        ((Farmer) enemy).damage();
                    } else if (enemy instanceof Prof) {
                        ((Prof) enemy).damage();
                    }
                }
                
                attackDelay.performDelay();
            }
        }
    }
    
    private void damageDistibutor(int damage, Player player) {
        setHealth(getHealth() - damage);
        
        if (getHealth() >= 0) {
            getHealthManager().setHealth(getHealth());
            getHealthManager().changeHealth(getWorld());
        }
        
        if (getHealth() <= 0){
            MyWorld.stopped = true;
            getWorld().addObject(new EndText(player), 800, 400);
        }
    }
    
    private Action getAction() {
        if (Player.PLAYER_2 == this.player) {
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
    
    abstract void attack();
    
    abstract void damage();
    
    public Player getPlayer() {
        return this.player;
    }
    
    public HealthManager getHealthManager() {
        return this.healthManager;
    }
    
    public Delay getDamageDelay() {
        return damageDelay;
    }
    
    private enum Action {
        MELEE, ULT;
    }
    
    private enum Movement {
        LEFT, RIGHT, UP, DOWN;
    }
}
