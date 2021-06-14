import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Collectibles here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Collectible extends Actor
{
    /**
     * Act - do whatever the Collectibles wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {

    } 

    public void Coallition(){
        if (isTouching(Agent.class))
            getWorld().removeObject(this);
    }
}
