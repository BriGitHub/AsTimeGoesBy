import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Bosses here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Bosses extends Mover
{
    //The variable that says how strong the characer is being pulled down
    private int gravity; 
    
    //The variable that represents the rng factory
    private int rngAmount;
    
    //The variable that says how many hits the character can take
    public int health;
    
    /**
     * Creates a random number to decide what the boss does
     */
    public int rng()
    {
        rngAmount = 0;
        rngAmount = Greenfoot.getRandomNumber(10);
        return rngAmount;
    }
    
    
    /**
     * Checks if the laser is touches the boss and if it is, take one health 
     * point away from the boss
     */
    public int gotHit()
    {
        if(isTouching(LasorRight.class))
        {
           health--;
           removeTouching(LasorRight.class);
        }
        if(isTouching(LasorLeft.class))
        {
           health--;
           removeTouching(LasorLeft.class);
        }
        return health;
    }
    
    /**
     * Sees if the boss's health is zero and if it is, the boss despawns and the portal
     * piece falls so the player can pick it up
     */
    public void death()
    {
        if (health == 0)
        {
            getWorld().addObject(new Piece(), 600, 550);
            getWorld().removeObject(this);
        }
    }
    
    /**
     * Makes sure the boss doesn't run under the platforms
     */
    public void platCheck()
    {
        if(getX() >= 750) move(-30);
        if(getX() <= 125) move(30);
    }
    
    /**
     * Resets the image to the standing image if he isn't jumping
     */
    public void noJump(int ground, GreenfootImage firstImage, GreenfootImage secondImage)
    {
        Actor jane = (Actor)getWorld().getObjects(JaneDoe.class).get(0); // gets reference to jane
        
        if(getY() >= ground)
        {
            if(jane.getX() < getX()) setImage(firstImage);
            else setImage(secondImage);
        }
    }
    
    /**
     * Moves towards jane and also sets the image based on her location
     */
    public void moveTowards(int amt, GreenfootImage firstImage, GreenfootImage secondImage)
    {
        Actor jane = (Actor)getWorld().getObjects(JaneDoe.class).get(0); // gets reference to jane
        
        if(jane.getX() < getX()) 
        {
            setImage(firstImage);
            move(-amt);
        }
        else 
        {
            setImage(secondImage);
            move(amt);
        }
    }
}
