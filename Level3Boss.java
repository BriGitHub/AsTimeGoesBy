import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level3Boss here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level3Boss extends World
{
    /**
     * Constructor for objects of class Level3Boss.
     */
    public Level3Boss()
    {    
        // Create a new world with 850x650 cells with a cell size of 1x1 pixels.
        super(850, 650, 1);
        
        //Sets Jane, the objective, and the floor for the level
        addObject(new JaneDoe(), 128, 580);
        addObject(new Ground2Boss(), 425, 631);
        addObject(new Obj3Boss(), 425, 35);
        
        //Creates all the platforms for the level
        addObject(new CloudMover(), 425, 170);
        addObject(new RiseNFall(), 38, 400);
        addObject(new RiseNFall(), 812, 400);
    }
}
