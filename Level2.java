import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class myWorldStage3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level2 extends World
{
    /**
     * Constructor for objects of class Level2.
     */
    public Level2()
    {    
        // Create a new world with 850x650 cells with a cell size of 1x1 pixels.
        super(850, 650, 1); 
        
        //Sets Jane, the objective, any interactables/hazards and the floor for the level
        addObject(new JaneDoe(), 128, 580); 
        addObject(new Ground2(), 425, 631);
        addObject(new Obj2(), 425, 40);
        addObject(new Pit(), 407, 622);
        addObject(new Upgrade(), 670, 170);
        
        //Creates all the platforms for the level
        addObject(new Platform2(), 70, 436);
        addObject(new CloudPlatform(), 50, 155);
        addObject(new CloudPlatform(), 110, 180);
        addObject(new CloudMover(), 585, 517);
        addObject(new Platform2(), 435, 410);
        addObject(new Platform2(), 305, 370);
        addObject(new Platform2(), 655, 538);
        addObject(new CloudPlatform(), 670, 200);
        addObject(new CloudMover(), 145, 285);
        addObject(new CloudDisappear(), 530, 305);
    }
}
