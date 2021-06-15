import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Collectibles here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Collectible extends Actor
{
    protected int POINTS;
    public void act() 
    {
        Coallition();
    } 

    protected void Coallition(){
        if (isTouching(Agent.class)){
            getWorld().removeObject(this);
            Score.addScore(POINTS);
        }       
    }
}
