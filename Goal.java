import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Goal here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Goal extends Interactables
{
    /**
     * Act - do whatever the Goal wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        //Changes level Jane gets to the goal
        if ((getOneObjectAtOffset(0, getImage().getHeight()/2, JaneDoe.class) != null) && (level==1))
        {
            World world2 = new Level1Boss(); //Creates to the next level
            world2.addObject(new Boss1(), 500, 500); //Puts the new boss in the level
            Greenfoot.setWorld(world2); //Changes to the next level
            teleport.setVolume(87);
            teleport.play();
            reset();
        }
        
        if ((getOneObjectAtOffset(0, getImage().getHeight()/2, JaneDoe.class) != null) && (level==3))
        {
            World world4 = new Level2(); //Creates to the next level
            world4.addObject(new Goal2(), 50, 95); //Puts the new goal in the level
            Greenfoot.setWorld(world4); //Changes to the next level
            teleport.setVolume(87);
            teleport.play();
            reset();
        }
        
        if ((getOneObjectAtOffset(0, getImage().getHeight()/2, JaneDoe.class) != null) && (level==6))
        {
            World world7 = new Level3(); //Creates to the next level
            world7.addObject(new Goal2(), 720,240); //Puts the new goal in the level
            Greenfoot.setWorld(world7); //Changes to the next level
            teleport.setVolume(87);
            teleport.play();
            reset();
        }
        
        
    }    
}
