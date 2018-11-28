public class Delay {
    
    private long savedTime = 0;
    private int delay;
    
    public Delay(int delay) {
        this.delay = delay;
    }

    public boolean isInDelay(boolean perform) {
        if (System.currentTimeMillis() - savedTime >= delay) {
            if (perform) 
                performDelay();
                
                
            return false;
        }
        
        return true;
    }
    
    public void performDelay() {
        savedTime = System.currentTimeMillis();
    }
}
