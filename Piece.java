import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Piece here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Piece extends Interactables
{
    /**
     * Act - do whatever the Piece wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if ((getOneObjectAtOffset(0, getImage().getHeight()/2, JaneDoe.class) != null) && (level==2))
        {
            Greenfoot.playSound("Metal.mp3");
            World world3 = new Level2A(); //Changes to the next level
            world3.addObject(new Goal(), 140, 110); //Puts the new goal in the level
            Greenfoot.setWorld(world3); //Changes to the next level
            reset();
        }
        
        if ((getOneObjectAtOffset(0, getImage().getHeight()/2, JaneDoe.class) != null) && (level==5))
        {
            Greenfoot.playSound("Metal.mp3");
            World world6 = new Level3A(); //Changes to the next level
            world6.addObject(new Goal(), 760,80); //Puts the new goal in the level
            Greenfoot.setWorld(world6); //Changes to the next level
            reset();
        }
        
        if ((getOneObjectAtOffset(0, getImage().getHeight()/2, JaneDoe.class) != null) && (level==8))
        {
            World victoryScreen = new Victory(); //Changes to the next level
            Greenfoot.setWorld(victoryScreen); //Changes to the next level
        }
    }    
}
