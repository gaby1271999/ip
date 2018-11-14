import greenfoot.*;

public class SelectCharacter extends World {

    public static Characters char1, char2;
    
    public static SelectChar selectChar1 = new SelectChar();
    public static SelectChar selectChar2 = new SelectChar();
    
    public SelectCharacter() {    
        super(1600, 800, 1); 
        prepare();
    }

    private void prepare() {
        Player1Text player1Text = new Player1Text();
        addObject(player1Text,200+200,200);
        Player2Text player2Text = new Player2Text();
        addObject(player2Text,200+1000,200);
        
        //player1 selection
        FarmerButton farmerButton1 = new FarmerButton(Player.PLAYER_1);
        addObject(farmerButton1,125+200,400);
        addObject(selectChar1,125+200,400);
        char1 = Characters.FARMER;
        
        ProfButton profButton1 = new ProfButton(Player.PLAYER_1);
        addObject(profButton1,125+200+250,400);
        
        //player2 selection
        FarmerButton farmerButton2 = new FarmerButton(Player.PLAYER_2);
        addObject(farmerButton2,125+1000,400);
        addObject(selectChar2,125+1000,400);
        char2 = Characters.FARMER;
        
        ProfButton profButton2 = new ProfButton(Player.PLAYER_2);
        addObject(profButton2,125+1000+250,400);
        
        StartButton startButton = new StartButton();
        addObject(startButton,800,700);
    }
}
