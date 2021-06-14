import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ScreenGameOver here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ScreenGameOver extends World
{

    /**
     * Constructor for objects of class ScreenGameOver.
     * 
     */
    public ScreenGameOver()
    {    
        super(600, 400, 1);
        
    }
    
    public void act(){
        if(Greenfoot.isKeyDown("space"))
        {
            Greenfoot.setWorld(new MenuScreen());            
        }   
    }
}
