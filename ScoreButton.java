import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ScoreBotton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ScoreButton extends Button
{
    public ScoreButton(){   
    }
    public ScoreButton(Observer ... observers)
    {
        super(observers);
    }

    public void act() 
    {
        super.act();
        if (Greenfoot.mouseClicked(this))
        {
            ScoreScreen.stopMusic();
            Greenfoot.setWorld(new ScoreScreen());
        }
    }    
}
