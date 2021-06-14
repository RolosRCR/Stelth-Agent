import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ScoreBotton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ScoreButton extends Button
{
    /**
     * Act - do whatever the ScoreBotton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public ScoreButton(Observer ... observers)
    {
        super(observers);
    }

    public void act() 
    {
        super.act();
        if (Greenfoot.mouseClicked(this))
        {
            Greenfoot.setWorld(new ScoreScreen());
            
        }
    }    
}
