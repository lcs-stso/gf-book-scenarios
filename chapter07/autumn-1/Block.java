import greenfoot.*;
//Get access to the List type from the Java API 
import java.util.List; 

/**
 * A block that bounces back and forth across the screen.
 * 
 * @author Michael Kölling
 * @version 0.1
 */
public class Block extends Actor
{
    private int delta = 2;
    
    /**
     * Move across the screen, bounce off edges. Turn leaves, if we touch any.
     */
    public void act() 
    {
        move();
        checkEdge();
        checkMouseClick();
    }
    
    /**
     * Move sideways, either left or right.
     */
    private void move()
    {
        setLocation(getX()+delta, getY());
    }
    
    /**
     * Check whether we are at the edge of the screen. If we are, turn around.
     */
    private void checkEdge()
    {
        if (isAtEdge()) 
        {
            delta = -delta;  // reverse direction
        }
    }
    
    /**
     * Check whether the mouse button was clicked. If it was, change all leaves.
     */
    private void checkMouseClick()
    {
        //When "null" is passed as an argument to mouseClicked,this method, 
        //mouseClicked, returns true ANY TIME the mouse is clicked
        //If you pass a specific object reference,this method returns true
        //ONLY when the object is clicked 
        if (Greenfoot.mouseClicked(this)) 
        {
            //Get an object reference to the world 
           World myWorld = getWorld(); 
            
           //2.Get a list of object references to all the Leaf objects in the 
           //world 
           // TYPE    NAME                       CLASS
           List<Leaf> leaves = myWorld.getObjects(Leaf.class);
           
           //3. Automatically iterate (loop) through the lsit the correct 
           //number of times with each iteration, get an object reference to 
           //the next Leaf in the list 
           //"For each leaf in the leaves list..." 
           for(Leaf leaf : leaves) 
           {
             //Change the image on this particular leaf 
             leaf.changeImage();
             
           }
        }
    }
    
}
