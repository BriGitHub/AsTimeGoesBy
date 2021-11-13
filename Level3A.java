import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level3B here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level3A extends World
{
    /**
     * Constructor for objects of class Level3A.
     */
    public Level3A()
    {    
        // Create a new world with 850x650 cells with a cell size of 1x1 pixels.
        super(850, 650, 1);
        
        //Sets Jane, the objective, and the floor for the level
        addObject(new JaneDoe(), 128, 580);
        addObject(new Obj3A(), 425, 35);
        addObject(new Ground3A(), 425, 631);
        
        //Sets all the platforms up
        addObject(new ColumnTop(), 465, 520);
        addObject(new ColumnTop(), 310, 405);
        addObject(new ColumnTop(), 225, 405); 
        addObject(new ColumnTop(), 145, 405);
        addObject(new ColumnTop(), 70, 405);
        addObject(new ColumnTop(), 645, 340);
        addObject(new CloudPlatform(), 440, 310);
        addObject(new CloudPlatform(), 255, 250);
        addObject(new CloudMover(), 425, 140);
    }
}
