import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
 
public class Button extends Actor
{
    public void act() 
    {
        //If the player clicks on the button it will reset the game to the menu
        if (Greenfoot.mouseClicked(this))
        {
            //Victory.sound.stop();//stop playing the menu music
            Greenfoot.setWorld(new Menu());
        }
    }
}
