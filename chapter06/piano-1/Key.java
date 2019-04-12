import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)

public class Key extends Actor
{
    /**
     * Instance variables
     */
    //Track whether is "piano key down" image has already been set or not
    private boolean isDown; 
    /**
     * Create a new key.
     * Constructor - it runs once when a Key object is created 
     */
    public Key()
    {
        //Key begins in the "up"position
        isDown = false; 
    }

    /**
     * Do the action for this key.
     */
    public void act()
    {
        //When the key image is NOT already showing"down"
        //AND
        //the "g" key on the keyboard has been pressed
        if( !isDown && Greenfoot.isKeyDown("g"))
        {
            setImage("white-key-down.png"); 
            isDown = true;
            play();
        }
        if ( isDown == true && Greenfoot.isKeyDown ("g") == false ) 
        {
            setImage("white-key.png");
            isDown = false; 
        }
    }
    
    /**
     * Play the note of this key
     */
    public void play()
    {
        Greenfoot.playSound("3a.wav"); 
    }
}

