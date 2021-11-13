import greenfoot.*;

public class JaneDoe extends Mover
{
    //The variable that says how many hits the character can take
    public static int health = 3;
    
    //The images for when Jane is running to the right
    private GreenfootImage image1a = new GreenfootImage("alien.png");
    private GreenfootImage image2a = new GreenfootImage("alien1.png");
    private GreenfootImage image3a = new GreenfootImage("alien2.png");
    
    //The images for when Jane is running to the left
    private GreenfootImage image1b = new GreenfootImage("alienflip.png");
    private GreenfootImage image2b = new GreenfootImage("alien1flip.png");
    private GreenfootImage image3b = new GreenfootImage("alien2flip.png");
    
    //sound file for the gunshot
    private static final GreenfootSound shot = new GreenfootSound("Lazer.mp3");
    
    //Creates variables to make sure the user cannot just shoot constantly
    public static int reloadDelayCount = 140;
    public static int coolDown = 140;
    private boolean shoot = false;
    public static int numUpgrade = 0;
    
    //The variable that controls which way Jane is facing so she shoots the bullet in 
    // that direction
    public static boolean facing = true;
    
    private int vSpeed = 0;
    private int acceleration = 2;
    private boolean jumping;
    private int jumpStrength = 25;
    private int speed = 8;
    private int direction = 9; // 1 = right and -1 = left
    
    public JaneDoe()
    {
        setImage(image1a);
    }
    
    /**
     * Act - do whatever the Player wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        hub();
        if(Menu.hasTimer) //if it is the timed mode, display the time on screen
            countTime();
        checkKey();
        platformAbove();
        checkFall();
        
        checkRightWalls();
        checkLeftWalls();
        
        gotHit();
        Actor hazard = getOneObjectAtOffset(0, getImage().getHeight()/2, Hazards.class);
        if(hazard != null) //If Jane falls in the pit or touches lava she dies
        {
            Greenfoot.playSound("bigOof.wav");
            health=0;
        }
        checkHealth();
        shooting();
        
        // Makes sure the reload doesn't go over the cooldown
        if (reloadDelayCount < coolDown) {
            reloadDelayCount++;
        }
        
        // Lets you shoot in half the time in if you get the upgrade piece
        Actor upgrade = getOneObjectAtOffset(0, getImage().getHeight()/2, Upgrade.class);
        if(upgrade != null) //If Jane touches an upgrade, she picks it up
        {
            if (numUpgrade == 0) //the first upgrade
            {
                GreenfootSound reload  = new GreenfootSound("reloadCheap.wav");
                reload.play();
                coolDown /= 2;
                reloadDelayCount /= 2;
            }
            else if (numUpgrade == 1) //onces she has the first upgrade, the second one is different
            {
                Greenfoot.playSound("Glub.wav");
                health++;
            }
            numUpgrade ++;
            removeTouching(Upgrade.class);
        }
    }   

    /**
     * Gives the player control over Jane with their keyboard. They have the option
     * of using the arrow keys or AWD to control her.
     */
    public void checkKey()
    {
        int spriteWidth = getImage().getWidth();
        int xDistance = (int)(spriteWidth/2);
        
        //Makes Jane move to the right if the player presses D or the right arrow key
        if(Greenfoot.isKeyDown("right") || Greenfoot.isKeyDown("D"))
        {
            facing = true;
            direction = 1;
            switchImage(image1a, image2a, image3a);
            moveRight();
        }
        
        //Makes Jane move to the left if the player presses A or the left arrow key
        if(Greenfoot.isKeyDown("left") || Greenfoot.isKeyDown("A"))
        {
            facing = false;
            direction = -1;
            switchImage(image1b, image2b, image3b);
            moveLeft();
        }
         
        //Makes Jane jump if the player presses W or the up arrow key
        if((Greenfoot.isKeyDown("up") || Greenfoot.isKeyDown("W")) && jumping == false)
        {
            jump();
        }
    }

    /**
     * Moves the character right based on the speed variable
     */
    public void moveRight()
    {
        setLocation(getX()+speed, getY());
    }

    /**
     * Moves the character left based on the speed variable
     */
    public void moveLeft()
    {
        setLocation(getX()-speed, getY());
    }

    /**
     * Checks to see if Jane is hitting her head on a platform above her
     */
    public boolean platformAbove()
    {
        int spriteHeight = getImage().getHeight();
        int yDistance = (int)(spriteHeight/-2);
        Actor ceiling = getOneObjectAtOffset(0, yDistance, Platforms.class);
        if(ceiling != null)
        {
            vSpeed = 1;
            bopHead(ceiling);
            return true;
        }
        else
        {
            return false;
        }
    }

    /**
     * Checks to see if Jane is hitting or running into a wall/platform to the right of her
     */
    public boolean checkRightWalls()
    {
        int spriteWidth = getImage().getWidth();
        int xDistance = (int)(spriteWidth/2);
        Actor rightWall = getOneObjectAtOffset(xDistance, 0, Platforms.class);
        if(rightWall == null)
        {
            return false;
        }
        else
        {
            stopByRightWall(rightWall);
            return true;
        }
    }

    /**
     * If Jane is hitting a wall/platform to the right of her, this will move her to the  
     * left so she doesn't glitch through the platform or get stuck inside of it
     */
    public void stopByRightWall(Actor rightWall)
    {
        int wallWidth = rightWall.getImage().getWidth();
        int newX = rightWall.getX() - (wallWidth + getImage().getWidth())/2;
        setLocation(newX - 5, getY());
    }

    /**
     * Checks to see if Jane is hitting or running into a wall/platform to the left of her
     */
    public boolean checkLeftWalls()
    {
        int spriteWidth = getImage().getWidth();
        int xDistance = (int)(spriteWidth/-2);
        Actor leftWall = getOneObjectAtOffset(xDistance, 0, Platforms.class);
        if(leftWall == null)
        {
            return false;
        }
        else
        {
            stopByLeftWall(leftWall);
            return true;
        }
    }

    /**
     * If Jane is hitting a wall/platform to the left of her, this will move her to the  
     * right so she doesn't glitch through the platform or get stuck inside of it
     */
    public void stopByLeftWall(Actor leftWall)
    {
        int wallWidth = leftWall.getImage().getWidth();
        int newX = leftWall.getX() + (wallWidth + getImage().getWidth())/2;
        setLocation(newX + 5, getY());
    }

    /**
     * If Jane is hitting a wall/platform to the above of her, this will move her   
     * downwards so she doesn't glitch through the platform or get stuck inside of it
     */
    public void bopHead(Actor ceiling)
    {
        int ceilingHeight = ceiling.getImage().getHeight();
        int newY = ceiling.getY() + (ceilingHeight + getImage().getHeight())/2;
        setLocation(getX(), newY);
    }
    
    /**
     * Makes Jane fall, she falls faster the longer she falls
     */
    public void fall()
    {
        setLocation(getX(), getY() + vSpeed + 3);
        if(vSpeed <=7)
        {
            vSpeed = vSpeed + acceleration;
        }
        jumping = true;
    }

    /** 
     * Chekc to see if Jane is on a platform/ground
     */
    public boolean onGround()
    {
        int spriteHeight = getImage().getHeight();
        int yDistance = (int)(spriteHeight/2) + 5;
        Actor ground = getOneObjectAtOffset(0, getImage().getHeight()/2, Platforms.class);
        if(ground == null)
        {
            jumping = true;
            return false;
        }
        else
        {
            moveToGround(ground);
            return true;
        }
    }

    /**
     * Puts Jane on the platform/ground and tells the computer she is no longer jumping
     */
    public void moveToGround(Actor ground)
    {
        int groundHeight = ground.getImage().getHeight();
        int newY = ground.getY() - (groundHeight + getImage().getHeight())/2;
        setLocation(getX(), newY);
        jumping = false;
    }

    /**
     * If Jane is not on a platform, she falls. If she is on a platform then the variable
     * controlling how fast she falls is reset to zero.
     */
    public void checkFall()
    {
        if(onGround())
        {
            vSpeed = 0;
        }
        else
        {
            fall();
        }
    }

    /**
     * This creates the jumping physics: how high she will jump and once she jumps
     * she starts falling.
     */
    public void jump()
    {
        vSpeed = vSpeed - jumpStrength;
        jumping = true;
        fall();
    }
    
    /**
     * Makes the text that displays at the top of the screen that
     * tells the player how much health they have and if they can
     * shoot yet or if they are reloading and can't shoot yet
     */
    public void hub()
    {
        getWorld().showText("HP: " + health, 80, 25);
        if (reloadDelayCount <= coolDown){
            getWorld().showText("Reloading", 80, 50);
            if (reloadDelayCount == coolDown)
            {
                getWorld().showText("Shot Ready", 80, 50); 
            }
        }
    }
    
    /**
     * Checks to see if Jane gets hit and if she does get hit, subtract 
     * one health and then send Jane back so she doesn't take multiple 
     * damage from one hit
     **/
    public void gotHit()
    {
        if(isTouching(Bosses.class))
        {
            Greenfoot.playSound("oof.wav");
            health--;
            checkHealth();
            if((getX() - 220) < 0) move(220);
            else if (getX() + 200 > 850) move(-220);
            else move(-220);
            Greenfoot.delay(5);
        }
    }
    
     /**
      * Checks to see if Jane is still alive and if her health has 
      * hit zero, then game over.
     **/
    public void checkHealth()
    {
       if(health == 0)
        {
            World gameOver = new GameOver(); //Changes to the next level
            Greenfoot.setWorld(gameOver); //Changes to the next level
            Greenfoot.playSound("Death.mp3");
            //Greenfoot.stop();
        } 
    }
    
    /**
     * Makes Jane shot a bullet if the player presses the space bar. The bullet will
     * travel in the direction that Jane was facing when the player pressed the space
     * bar.
     */
    public void shooting()
    {
        if(shoot) 
        {
            shoot = false;
        }
        if (Greenfoot.isKeyDown("space") && reloadDelayCount >= coolDown)  //makes jane shoot
        {
            shot.setVolume(45);
            shot.play();//start playing the sound
            shoot = true;
            if(facing)
                getWorld().addObject(new LasorRight(), getX()+27, getY()+9);
            else
                getWorld().addObject(new LasorLeft(), getX()-27, getY()+9);
            reloadDelayCount=0;
        }
    }
    
    /**
     * Count down the game time and display it. Stop the game 
     * with a winning message when time is up.
     */
    private void countTime()
    {
        Menu.time--;
        showTime();
        if ((Menu.time) == 0)
        {
            health=0;
        }
    }

    /**
     * Show the remaining game time on screen.
     */
    private void showTime()
    {
        //getWorld().showText("Time: " + (Menu.time), 80, 75);
        getWorld().showText("Time left: " + ((Menu.time/60)+1), 80, 75);
    }
}
