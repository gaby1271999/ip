import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    public final static int GROUND = 500;
    public static int HEALTH = 1000;
    public static int HEALTH_BAR = 400;
    
    private static HealthBar healthBar1, healthBar2;
    
    private static Avatar charPlayer1;
    private static Avatar charPlayer2;

    public MyWorld() {    
        super(1600, 800, 1);
        
        addObjectsInWorld();
    }
    
    private void addObjectsInWorld() {
        //Header player 1
        healthBar1 = new HealthBar(Player.PLAYER_1);
        addObject(healthBar1,200+400,25);
        Player1Header player1Header = new Player1Header();
        addObject(player1Header,200,50);
        
        //header player 2
        healthBar2 = new HealthBar(Player.PLAYER_2);
        addObject(healthBar2,1400-400,25);
        Player2Header player2Header = new Player2Header();
        addObject(player2Header,1400,50);
    }

    public void prepare() {
        charPlayer1.spawnAvatar(this, 100+75, 400-25);
        charPlayer2.spawnAvatar(this, 1600-175, 400-25);
    }
    
    public static Avatar getEnemyAvatar(Player player) {
        if (player == Player.PLAYER_1) {
            return charPlayer2;
        } else {
            return charPlayer1;
        }
    }
    
    public static void setAvatar(Player player, Avatar avatar) {
        if (player == Player.PLAYER_1) {
            charPlayer1 = avatar;
        } else {
            charPlayer2 = avatar;
        }
    }
    
    public static void setAvatar(Player player, Characters character) {
        if (Characters.FARMER == character) {
            if (player == Player.PLAYER_1) {
                charPlayer1 = new Farmer(player, healthBar1);
            } else {
                charPlayer2 = new Farmer(player, healthBar2);
            }
        } else {
            if (player == Player.PLAYER_1) {
                charPlayer1 = new Prof(player, healthBar1);
            } else {
                charPlayer2 = new Prof(player, healthBar2);
            }
        }
    }
}
