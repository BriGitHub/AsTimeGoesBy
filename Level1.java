import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Level1 extends World
{
    //the variable for the background music
    public static final GreenfootSound music = new GreenfootSound("GenericMusic.mp3");
    
    /**
     * Constructor for objects of class Level1.
     */
    public Level1()
    {     
        // Create a new world with 850x650 cells with a cell size of 1x1 pixels.
        super(850, 650, 1); 
        
        Menu.sound.stop();//stop playing the menu music
        music.setVolume(47);
        music.playLoop();//start the background music and set it in a loop
        
        //Sets Jane, the objective, any interactables/hazards and the floor for the level
        addObject(new JaneDoe(), 50, 580);
        addObject(new Goal(), 780,100);
        addObject(new Obj1(), 425, 35);
        addObject(new Ground1(), 425, 631);
        
        //Creates all the platforms for the level
        addObject(new Platform1(), 200, 515);
        addObject(new Platform1(), 320, 470);
        addObject(new Platform1(), 525, 415);
        addObject(new Platform1(), 650, 515);
        addObject(new Platform1(), 235, 365);
        addObject(new CloudPlatform(), 135, 135);
        addObject(new CloudPlatform(), 285, 230);
        addObject(new CloudMover(), 385, 325);
        addObject(new CloudPlatform(), 600, 225);
        addObject(new CloudPlatform(), 780, 155);
    }
}
