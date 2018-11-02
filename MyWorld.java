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
    
    private static Avatar charPlayer1;
    private static Avatar charPlayer2;

    public MyWorld() {    
        super(800, 600, 1); 
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare() {
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
}
