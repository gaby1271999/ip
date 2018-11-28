import greenfoot.*;

public class Chicken extends Actor {
    
    private String[] images={"chicken1","chicken2"};
    
    private int nrAfbeelding;

    public Chicken() {
        nrAfbeelding = Greenfoot.getRandomNumber(images.length);
        setImage(images[nrAfbeelding] + ".png");
        
        EndScreen.no.MyMusic.playLoop();
    }
    
    public void fly() {
        move(-3);
        nrAfbeelding++;
        
        if (nrAfbeelding >= images.length){
            nrAfbeelding = 0;
        }
        
        setImage(images[nrAfbeelding] + ".png"); 
    }
    
    public void act () {
        fly();
       
        if (getX() == 0) {
            getWorld().removeObject(this);
            
            EndScreen.no.MyMusic.stop();
        }
    }   
}
