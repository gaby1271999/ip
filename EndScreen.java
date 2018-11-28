import greenfoot.*;

public class EndScreen extends World {

    public static EndScreen endScreen;
    public static No no;
    
    public EndScreen() {    
        super(1600, 800, 1); 
        
        endScreen = this;
        
        prepare();
    }

    private void prepare() {
        Retry retry = new Retry();
        addObject(retry,875,324);
        
        no = new No();
        addObject(no,895,676);
    }
}
