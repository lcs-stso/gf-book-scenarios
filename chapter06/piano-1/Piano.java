import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)

/**
 * A piano that can be played with the computer keyboard.
 * 
 * @author: M. Kölling
 * @version: 0.1
 */
public class Piano extends World
{
    /**
     * Instance variable (can be used anywhere below) 
     */
    //Primitive data type(int)
    int frames; 
    //Object data type..square brackets[]indicate an array(a list) 
    //Data type: String,we want an array,and the name is"student name"
    String[] studentNames = {"Sarah", "Chelsea","Jack","Maxwell","Gavin","Peter",
            "Minah","Brandon","Jeowoo","Peter","Justy"};
    //Track the white keys and notes
    String[] whiteKeys = {"a","s","d","f","g","h","j","k","l",";","'","\\"};
    String[] whiteNotes = {"3c","3d","3e","3f","3g","3a","3b","4c","4d","4e",
            "4f","4g"};

    String[] blackKeys = {"w","e","","t","y","u","", "o","p","","[",""};
    String[] blackNotes = {"3c#", "3d#","","3f#","3g#","3a#","","4c#","4d#","",
            "4f#",""}; 
    /**
     * Make the piano.
     */
    public Piano() 
    {
        super(800, 340, 1);

        //Start tracking frames 
        frames = 0;

        //Initialize the array of student names 

    }

    /**
     * Act- called repeatedly to create animation 
     */
    public void act()
    {
        //Every second,say hello to the next person in the list 
        //Use of Boolean AND to check both conditions 
        //The showText statement only runs when BOTH conditions are true 
        //This block of code runs once per second until the end of the 
        //whiteKeys array
        //NOTE: whiteKeys.length automatically returns the correct number 
        //      of values in the array(so that we wont run pass the end) 
        int position = frames/60;
        if((frames%60 == 0) && (position < whiteKeys.length))
        {
            //Assemble the piano by creating each key one by one 
            Key anotherKey = new Key(whiteKeys[position], whiteNotes[position], true);
            //This line actually adds the object to the Piano world
            //     OBJECT    HORIZONTAL POSITION   VERTICAL POSITION  
            //NOTE: Check phone to see sketch of logical explaining the 
            //expression
            //      for the x position(horizontal position) of each key 

            addObject(anotherKey,54 + position * 63,140);

            //Only show a message when we are in the bounds of the array
            showText("Array index is:" + frames / 60,400,250);

            //Only say hello when we are in the bounds of the array
            //Say hello to everyone in the class!
            //showText("Hello" + studentNames[ frames/60 ],400,170);

        }
        //Keep track of scores 
        frames+=1; 
        //Show current frame 
        showText(""+frames,100,100);
         // Now draw all of the black piano keys on the screen
        for (int index = 0; index < blackKeys.length; index += 1)
        {
            // Only add a black key if there is a computer keyboard key
            // set in the blackKeys array at this index
            if (blackKeys[index] != "")
            {
                // Create a new black Key object
                BlackKey newKey = new BlackKey(blackKeys[index], blackNotes[index], false);

                // Add the key object to the scenario
                addObject(newKey, 85 + 63 * index, 86);
            }
        }
        
    }
}