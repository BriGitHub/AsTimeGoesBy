import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CloudDisappear here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CloudDisappear extends Platforms
{
    //The variables that control how much time Jane can stand on the cloud
    private int timer = 25;
    private int count = 0;
    
    /**
     * While Jane is touching the cloud, the count will go up and when 
     * the count reaches the timer the cloud will go away
     */
    public void act() 
    {
        if(isTouching(JaneDoe.class)){
            count++;
            if(count == timer)
            {
                getWorld().removeObject(this);
                return;
            }
            
        }
    }    
}
