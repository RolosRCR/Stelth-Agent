import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Botton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Botton extends Actor
{
       protected int x = 0;
       protected int y = 0;
    /**
     * Act - do whatever the Botton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        MouseInfo mouse = Greenfoot.getMouseInfo();
        if (mouse != null)
        {
            x = mouse.getX();
            y = mouse.getY();
        }
    }    
}
