import greenfoot.*;

public class StartScreen extends World {

    public StartScreen() {    
        // Create a new world with 1600x800 cells with a cell size of 1x1 pixels.
        super(1600, 800, 1); 
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        PlayButton playButton = new PlayButton();
        addObject(playButton,774,268);
        InstructionButton instructionButton = new InstructionButton();
        addObject(instructionButton,775,464);
        /*
        p1 p1 = new p1();
        addObject(p1,128,42);
        p1 p12 = new p1();

        p1.setLocation(173,41);
        removeObject(p1);*/
        playButton.setLocation(733,378);
        instructionButton.setLocation(727,630);
    }
}
