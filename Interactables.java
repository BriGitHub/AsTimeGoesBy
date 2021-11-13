import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Interactables here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Interactables extends Mover
{
    public static final GreenfootSound teleport = new GreenfootSound("Health.wav");
    
    /**
     * Runs the basic things that should update between every level 
     */
    public void reset()
    {
        level++; //Increments the level variable by one
        JaneDoe.facing = true; //Makes the computer know Jane is facing right
        Greenfoot.delay(5); //Delays the game so the player can see the level before it starts
    }
}
