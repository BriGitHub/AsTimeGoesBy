import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Upgrade here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Upgrade extends Interactables
{
    public Upgrade()
    {
        if(JaneDoe.numUpgrade == 0) //If it is the first upgrade, it'a reload
            setImage(new GreenfootImage("upgrade.png")); 
        else //If Jane has gotten the first upgrade, now this one is a health pack
            setImage(new GreenfootImage("upgrade2.png")); 
    }   
}
