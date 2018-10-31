import greenfoot.*;

public class Avatar extends Actor {
    
    private MyWorld myWorld = new MyWorld();
    
    private int health, stamina, moveSpeed;
    private Player player;
    private boolean isJumping = false;
    
    public Avatar(int stamina, int moveSpeed, Player player) {
        this.health = myWorld.HEALTH;
        this.stamina = stamina;
        this.moveSpeed = moveSpeed;
        this.player = player;
    }
    
    public void act() {
        contols();
    }
    
    private void contols() {
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
        
        if (isJumping) {
            turn(-90);
            move(-6);
            turn(90);
            
            if (getY() < myWorld.GROUND -60) {
                isJumping = false;
            }
        }
    }
    
    private Movement getMovement() {
        if (Player.PLAYER_1 == this.player) {
            if (Greenfoot.isKeyDown("4")) {
                return Movement.LEFT;
            } else if (Greenfoot.isKeyDown("6")) {
                return Movement.RIGHT;
            } else if (Greenfoot.isKeyDown("8")) {
                return Movement.UP;
            } else if (Greenfoot.isKeyDown("5")) {
                return Movement.DOWN;
            }
        } else {
            if (Greenfoot.isKeyDown("q")) {
                return Movement.LEFT;
            } else if (Greenfoot.isKeyDown("d")) {
                return Movement.RIGHT;
            } else if (Greenfoot.isKeyDown("z")) {
                return Movement.UP;
            } else if (Greenfoot.isKeyDown("s")) {
                return Movement.DOWN;
            }
        }
        
        return null;
    }
    
    private enum Actions {
        MELEE, ULT;
    }
    
    private enum Movement {
        LEFT, RIGHT, UP, DOWN;
    }
    
    public enum Player {
        PLAYER_1, PLAYER_2;
    }
}
