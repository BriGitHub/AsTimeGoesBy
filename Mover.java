import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Mover here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Mover extends Actor
{ 
    public static int level=1; //this variable tells the program what level it is
    
    /**
     * Overloads switchImage for two parameters
     * Alternate the character's image between image1 and image2.
     * Makes the character look like they are walking.
     */
    public void switchImage(GreenfootImage firstImage, GreenfootImage secondImage)
    {
        if (getImage() == firstImage) 
        {
            setImage(secondImage);
        }
        else
        {
            setImage(firstImage);
        }
    }
    /**
     * Overloads switchImage for three parameters
     * Alternate the character's image between image1, image2, and image3.
     * Makes the character look like they are walking.
     */
    public void switchImage(GreenfootImage firstImage, GreenfootImage secondImage, GreenfootImage thirdImage)
    {
        if (getImage() == firstImage) 
        {
            setImage(secondImage);
        }
        else if(getImage() == secondImage)
        {
            setImage(thirdImage);
        }
        else
        {
            setImage(firstImage);
        }
    }
}
