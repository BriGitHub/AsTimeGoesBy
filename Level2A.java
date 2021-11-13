import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Level2A here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level2A extends World
{

    /**
     * Constructor for objects of class Level2A.
     * 
     */
    public Level2A()
    {    
        // Create a new world with 850X650 cells with a cell size of 1x1 pixels.
        super(850, 650, 1); 
        
        //Sets Jane, the objective, any interactables/hazards and the floor for the level
        addObject(new JaneDoe(), 128, 580); 
        addObject(new Ground2A(), 425, 631);
        addObject(new Obj2A(), 425, 35);
        
        //Creates all the platforms for the level
        addObject(new Platform2(), 85, 436);
        addObject(new CloudPlatform(), 140, 170);
        addObject(new Platform2(), 200, 510);
        addObject(new CloudPlatform(), 260, 340);
        addObject(new Platform2(), 655, 538);
        addObject(new Platform2(), 530, 460);
        addObject(new Platform2(), 750, 410);
        addObject(new CloudPlatform(), 810, 130);
        addObject(new CloudMover(), 530, 250);
    }
}
