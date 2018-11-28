import greenfoot.*;

public class EndText extends Actor {

    private Delay delay = new Delay(1000*10), countdownDelay = new Delay(1000);
    private Number[] numbers = new Number[2];
    private int counter = 10;
    private boolean isCountdownAdded = false;
    
    public EndText(Player player) {
        if (player == Player.PLAYER_1) {
            setImage("end_text1.png");
        } else {
            setImage("end_text2.png");
        }
        
        delay.performDelay();
        
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = new Number(getCounter(i));
        }
    }
    
    public void act() {
        if (!isCountdownAdded) {
            getWorld().addObject(numbers[0], 800-25, 225);
            getWorld().addObject(numbers[1], 800+25, 225);
        
            isCountdownAdded = true;
        }
        
        if (!countdownDelay.isInDelay(false)) {
            for (int i = 0; i < numbers.length; i++) {
                numbers[i].changeNumber(getCounter(i));
            }
            
            counter--;
            countdownDelay.performDelay();
        }
        
        if (!delay.isInDelay(false)) {
            Greenfoot.setWorld(new EndScreen());
        }
    }
    
    private int getCounter(int index) {
        String count = String.valueOf(counter);
        
        if (count.split("(?<!^)").length > 1) {
            return Integer.valueOf(count.split("(?<!^)")[index]);
        } else {
            if (index == 0) {
                return 0;
            } else {
                return counter;
            }
        }
    }
}
