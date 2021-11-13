import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Shots here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Shots extends Mover
{
    /**
     * Gets rid of the bullet if it goes to the end of the screen
     */
    public void endScreen()
    {
        if (getX()==849 || getX() == 0) 
        {
            getWorld().removeObject(this);
            return;
        }
    }
}
