import greenfoot.*;

public class ProfButton extends Actor {
    
    private Player player;
    private int selectedXPos;
    
    public ProfButton(Player player) {
        this.player = player;
    }
    
    public void act() {
        if (Greenfoot.mouseClicked(this)) {
            if (player == Player.PLAYER_1) {
                SelectCharacter.selectChar1.setLocation(125+200+250, 400);
                SelectCharacter.char1 = Characters.PROF;
            } else {
                SelectCharacter.selectChar2.setLocation(125+250+1000, 400);
                SelectCharacter.char1 = Characters.PROF;
            }
        }
    }    
}
