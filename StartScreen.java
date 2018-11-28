import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class StartScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class StartScreen extends World
{

    /**
     * Constructor for objects of class StartScreen.
     * 
     */
    public StartScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1600, 800, 1);
        repaint();
        prepare();
    }
    
    private void prepare() {
        PlayButton playButton = new PlayButton();
        addObject(playButton,800,200);
        InstructionButton instructionButton = new InstructionButton();
        addObject(instructionButton,800,650);
    }
}
