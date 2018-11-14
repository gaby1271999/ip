import greenfoot.*;

public class FarmerButton extends Actor {
    private Player player;
    private int selectedXPos;
    
    public FarmerButton(Player player) {
        this.player = player;
    }
    
    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            if (player == Player.PLAYER_1) {
                SelectCharacter.selectChar1.setLocation(125+200, 400);
                SelectCharacter.char1 = Characters.FARMER;
            } else {
                SelectCharacter.selectChar2.setLocation(125+1000, 400);
                SelectCharacter.char2 = Characters.FARMER;
            }
        }
    }    
}
