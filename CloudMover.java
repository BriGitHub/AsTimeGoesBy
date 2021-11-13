import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class CloudMover here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class CloudMover extends Platforms
{
    private int speed = 4; //The variable that controls how fast the platform is moving
    
    //The variables that set where the turning points are
    private int leftTurn = 40;
    private int rightTurn = 810;
    
    //The variables that contain the different images of the different facings(left and right)
    private GreenfootImage image1 = new GreenfootImage("dinomover.png");
    private GreenfootImage image2 = new GreenfootImage("dinomoverleft.png");

    public CloudMover()
    {
        if(level == 0 || level==1)
            setImage(image2); //If Jane is in the dinosaur stages, the platform looks like a pterodactyl
        else
            setImage(new GreenfootImage("platformcloud.png")); //On the other levels, it will look like a cloud
    }
    
    /**
     * Move in the direction we are currently moving in. Turn if we reach a turning point.
     */
    public void act() 
    {
        if(level == 2 || level == 5 || level == 8) //If it's a boss level, the turning points are different
        {
            leftTurn = 120;
            rightTurn = 740;
        }
        else
        {
            leftTurn = 40;
            rightTurn = 810;
        }
        setLocation ( getX() + speed, getY() );
        
        Actor actor = getOneIntersectingObject(null);
        if(actor != null) {
            actor.setLocation ( actor.getX() + speed, actor.getY() );
        }
        
        if (atTurningPoint()) {
            speed = -speed;
            if(level == 1 || level == 2)
            {
                switchImage(image1, image2);
            }
        }
    }
    
    /**
     * Test if we are at one of the turning points.
     */
    public boolean atTurningPoint()
    {
        return (getX() <= leftTurn || getX() >= rightTurn);
    }
}
