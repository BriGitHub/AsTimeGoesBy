import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class LasorLeft here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LasorLeft extends Shots
{
    /**
    /**
     * Act - do whatever the Lasor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        shoot();
        endScreen();
    }
    
    public void shoot()
    {
        move(-12); //moves the bullet to the left
    }   
}
