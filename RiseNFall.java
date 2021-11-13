import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class RiseNFall here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class RiseNFall extends Platforms
{
    private int speed = 3; //The variable that controls how fast the platform moves
    
    //The variables that set where the turning points are
    private int highTurn = 120;
    private int lowTurn = 535;

    /**
     * Move in the direction we are currently moving in. Turn if we reach a turning point.
     */
    public void act() 
    {
        setLocation ( getX(), getY() + speed);
        
        Actor actor = getOneIntersectingObject(null);
        if(actor != null) {
            actor.setLocation ( actor.getX(), actor.getY() + speed);
        }
        
        if (atTurningPoint()) {
            speed = -speed;
        }
    }
    
    /**
     * Test if we are at one of the turning points.
     */
    public boolean atTurningPoint()
    {
        return (getY() <= highTurn || getY() >= lowTurn);
    }   
}
