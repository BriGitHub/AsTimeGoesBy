import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Boss2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Boss2 extends Bosses
{
    //The variable that says how strong the characer is being pulled down
    private int gravity; 
    
    //The images for when the boss is running to the right
    GreenfootImage image1a = new GreenfootImage("boss2.png");
    GreenfootImage image2a = new GreenfootImage("bossjump2.png");
            
    //The images for when the boss is running to the left
    GreenfootImage image1b = new GreenfootImage("bossleft2.png");
    GreenfootImage image2b = new GreenfootImage("bossjumpleft2.png");
 
    public Boss2()
    {
        health = 4; //sets the bosses health when he is spawned
    }
    
    public void act() 
    {   
        Actor jane = (Actor)getWorld().getObjects(JaneDoe.class).get(0); // gets reference to jane
        
        moveTowards(1, image1a, image1b);
        platCheck();
        noJump(565, image1a, image1b);
    
        //Makes the boss jump and sets the image to a jumping image
        if ((!(getY() <= 565)) && (rng()==1))
        {
            if(jane.getX() < getX()) setImage(image2a);
            else setImage(image2b);
            gravity = 17; //This will make the character jump
            setLocation(getX(), getY() - gravity);
        }
        
        //Makes Jane fall untill he is back on the ground
        if (getY() <= 565) 
        {
            gravity = gravity - 2;
            setLocation(getX(), getY() - gravity);
        }

        gotHit();
        getWorld().showText("Boss's HP: " + health, 770, 37); //shows how much health the boss has
        death();
    }
}
