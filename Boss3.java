import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Boss3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Boss3 extends Bosses
{
    //The images for when the boss is running to the right
    GreenfootImage image1a = new GreenfootImage("boss3.png");
            
    //The images for when the boss is running to the left
    GreenfootImage image1b = new GreenfootImage("bossleft3.png");
    
    private int speed = 3; //The variable that controls how fast the boss moves up and down
    
    //The variables that set where the turning points are
    private int highTurn = 280;
    private int lowTurn = 535;
    
    public Boss3()
    {
        health = 5; //sets the bosses health when he is spawned
    }
    
    public void act() 
    {   
        setLocation (getX(), getY() + speed);
        
        Actor actor = getOneIntersectingObject(null);
        if(actor != null) {
            actor.setLocation ( actor.getX(), actor.getY() + speed);
        }
        
        //Makes the boss start moving the other way if they have reached the turning point
        if (atTurningPoint()) {
            speed = -speed; 
        }
        
        moveTowards(3, image1a, image1b);
        platCheck();
        gotHit();
        getWorld().showText("Boss's HP: " + health, 770, 37); //shows how much health the boss has
        death();
    }  
    
    /**
     * Test if we are at one of the turning points.
     */
    public boolean atTurningPoint()
    {
        return (getY() <= highTurn || getY() >= lowTurn);
    }   
}
