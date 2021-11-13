import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Victory here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Victory extends World
{
    public static final GreenfootSound soundH = new GreenfootSound("VictoryH.wav");
    
    /**
     * Constructor for objects of class Victory.
     * 
     */
    public Victory()
    {    
        // Create a new world with 850x650 cells with a cell size of 1x1 pixels.
        super(850, 650, 1); 
        Level1.music.stop(); //stops the background music
        soundH.setVolume(75);
        soundH.play();
        addObject(new Button(), 430, 600);
    }
}
