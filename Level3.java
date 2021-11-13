import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Stage5 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level3 extends World
{
    /**
     * Constructor for objects of class Level3.
     */
    public Level3()
    {    
        // Create a new world with 850x650 cells with a cell size of 1x1 pixels.
        super(850, 650, 1);
        
        //Sets Jane, the objective, any interactables/hazards and the floor for the level
        addObject(new JaneDoe(), 128, 580);
        addObject(new Ground3(), 425, 631);
        addObject(new Upgrade(), 800, 50);
        addObject(new Obj3(), 425, 35);
        addObject(new Lava(), 412, 631);
        
        //Sets all the platforms up
        addObject(new ColumnTop(), 210, 503);
        addObject(new ColumnTop(), 65, 383);
        addObject(new ColumnTop(), 765, 518);
        addObject(new ColumnTop(), 720, 298);
        addObject(new CloudDisappear(), 390, 430);
        addObject(new CloudDisappear(), 520, 360);
        addObject(new CloudPlatform(), 260, 290);
        addObject(new CloudMover(), 425, 170);
        addObject(new CloudPlatform(), 800, 80);
    }
}
