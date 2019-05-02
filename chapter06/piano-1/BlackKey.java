import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BlackKey here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BlackKey extends Actor
{
    private boolean isDown; 
    private String key;               
    private String sound;            
    private boolean keyBlack;
    /**
     * Create a new key.
     * Constructor - it runs once when a Key object is created 
     */
     public BlackKey(String keyName, String soundFile, boolean isKeyBlack)
    {
        //Key begins in the "up"position
        isDown = false; 
        
        //Initialize the key and sound instance variables 
        key = keyName;                                   
        sound = soundFile;                                
        keyBlack = isKeyBlack; 
    }
    
    /**
     * Act - do whatever the BlackKey wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        if( !isDown && Greenfoot.isKeyDown(key))
        {
            setImage("black-key-down.png"); 
            isDown = true;
            play();
        }
         if ( isDown == true && Greenfoot.isKeyDown (key) == false ) 
        {
            setImage("black-key.png");
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
