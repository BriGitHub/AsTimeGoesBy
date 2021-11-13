import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Goal2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Goal2 extends Interactables
{
    /**
     * Act - do whatever the Goal2 wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if ((getOneObjectAtOffset(0, getImage().getHeight()/2, JaneDoe.class) != null) && (level==4))
        {
            World world5 = new Level2Boss(); //Creates to the next level
            world5.addObject(new Boss2(), 500, 500); //Puts the new boss in the level
            Greenfoot.setWorld(world5); //Changes to the next level
            teleport.setVolume(87);
            teleport.play();
            reset();
        }
        
        if ((getOneObjectAtOffset(0, getImage().getHeight()/2, JaneDoe.class) != null) && (level==7))
        {
            World world8 = new Level3Boss(); //Changes to the next level
            world8.addObject(new Boss3(), 500,500); //Puts the new goal in the level
            Greenfoot.setWorld(world8); //Changes to the next level
            teleport.setVolume(87);
            teleport.play();
            reset();
        }
    }    
}
