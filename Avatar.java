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
            move(-this.moveSpeed);
        } else if (getMovement() == Movement.RIGHT) {
            move(this.moveSpeed);
        } else if (getMovement() == Movement.JUMP) {
            isJumping = true;
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
            if (Greenfoot.isKeyDown("left")) {
                return Movement.LEFT;
            } else if (Greenfoot.isKeyDown("right")) {
                return Movement.RIGHT;
            } else if (Greenfoot.isKeyDown("up")) {
                return Movement.JUMP;
            }
        } else {
            if (Greenfoot.isKeyDown("q")) {
                return Movement.LEFT;
            } else if (Greenfoot.isKeyDown("d")) {
                return Movement.RIGHT;
            } else if (Greenfoot.isKeyDown("z")) {
                return Movement.JUMP;
            }
        }
        
        return null;
    }
    
    private enum Actions {
        MELEE, ULT;
    }
    
    private enum Movement {
        LEFT, RIGHT, JUMP;
    }
    
    public enum Player {
        PLAYER_1, PLAYER_2;
    }
}
