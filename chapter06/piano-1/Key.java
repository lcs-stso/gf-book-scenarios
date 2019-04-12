import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)

public class Key extends Actor
{
    /**
     * Instance variables
     */
    //Track whether is "piano key down" image has already been set or not
    //(isDown is a primitive data type - shows in red,type is lowercase)
    private boolean isDown; 
    
    //Track what key is being played AND what sound file to play 
    //(key and sound are object data types - shoes in black, type is Capitalized)
    private String key;                //**
    private String sound;              //**
    
    /**
     * Create a new key.
     * Constructor - it runs once when a Key object is created 
     */
    public Key(String keyName, String soundFile)
    {
        //Key begins in the "up"position
        isDown = false; 
        
        //Initialize the key and sound instance variables //**
        key = keyName;                                    //**
        sound = soundFile;                                //**
        
    }

    /**
     * Do the action for this key.
     */
    public void act()
    {
        //When the key image is NOT already showing"down"
        //AND
        //the "g" key on the keyboard has been pressed
        if( !isDown && Greenfoot.isKeyDown(key))
        {
            setImage("white-key-down.png"); 
            isDown = true;
            play();
        }
        if ( isDown == true && Greenfoot.isKeyDown (key) == false ) 
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
        Greenfoot.playSound(sound +".wav"); 
    }
}

