import greenfoot.*;

public class MyWorld extends World {
    public static final int HEALTH = 1000;
    public static final int HEALTH_BAR = 400;
    public static boolean stopped = false;
    
    private static Avatar charPlayer1;
    private static Avatar charPlayer2;

    private static HealthManager health2;
    private static HealthManager health1;
    
    
    public MyWorld() {    
        super(1600, 800, 1);
        
        player1Header();
        player2Header();
    }
    
    private void player1Header() {
        //Header player 1
        Player1Header player1Header = new Player1Header();
        addObject(player1Header,200,50);
        health1 = new HealthManager( 4, 25);
        health1.changeHealth(this);
    }
    
    private void player2Header() {
        //header player 2
        Player2Header player2Header = new Player2Header();
        addObject(player2Header,1400,50);
        health2 = new HealthManager( 4, 1425);
        health2.changeHealth(this);
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
    
    public static void setAvatar(Player player, Characters character) {
        if (Characters.FARMER == character) {
            if (player == Player.PLAYER_2) {
                charPlayer2 = new Farmer(player, health2);
                return;
            } else {
                charPlayer1 = new Farmer(player, health1);
                return;
            }
        } else {
            if (player == Player.PLAYER_1) {
                charPlayer1 = new Prof(player, health1);
                return;
            } else {
                charPlayer2 = new Prof(player, health2);
                return;
            }
        }
    }
}
