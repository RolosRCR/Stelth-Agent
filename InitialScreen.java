import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class InitialScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class InitialScreen extends World
{

    /**
     * Constructor for objects of class InitialScreen.
     * 
     */
    public InitialScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        prepare();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        InitialScreenText initialScreenText = new InitialScreenText();
        addObject(initialScreenText,297,187);
    }

    public void act()
    {
    if(Greenfoot.isKeyDown("space"))
    Greenfoot.setWorld(new MenuScreen());
    }
    
}
