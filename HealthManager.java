import greenfoot.*;

public class HealthManager {

    private String health;
    private int xPos, minLength;
    
    private Number[] numbers;
    
    public HealthManager(int minLength, int xPos) {
        this.health = String.valueOf(MyWorld.HEALTH);
        this.xPos = xPos;
        this.minLength = minLength;
        
        this.numbers = new Number[minLength];
    }
    
    public void changeHealth(World world) {
        if (this.numbers != null) {
            for(int i = 0; i < this.numbers.length; i++) {
                Number number = this.numbers[i];
                world.removeObject(number);
            }
        }
        
        if (health.length() < minLength) {
            for(int i = 0; i < minLength-health.length(); i++) {
                Number number = new Number(0);
                numbers[i] = number;
            }
        }
        
        int stringIndexCounter = 0;
        for (int i = (minLength-health.length()); i < minLength; i++) {
            Number number = new Number(Integer.valueOf(health.split("(?<!^)")[stringIndexCounter]));
            numbers[i] = number;
            stringIndexCounter++;
        }
        
        for (int i = 0; i < numbers.length; i++) {
            world.addObject(numbers[i], this.xPos+(i*50), 125);
        }
    }
    
    public void setHealth(int health) {
        this.health = String.valueOf(health);
    }
    
    public String getHealth () {
        return this.health;
    }
}
