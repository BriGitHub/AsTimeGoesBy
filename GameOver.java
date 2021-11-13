import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameOver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOver extends World
{

    /**
     * Constructor for objects of class GameOver.
     * 
     */
    public GameOver()
    {    
        // Create a new world with 850x650 cells with a cell size of 1x1 pixels.
        super(850, 650, 1); 
        Level1.music.stop();//stop playing the background music
        addObject(new Button(), 430, 450); 
    }
}
