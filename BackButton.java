import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class BackButton extends Button
{    
    public void act() 
    {
        super.act();
        if (Greenfoot.mouseClicked(this))
        {     
            Greenfoot.setWorld(new MenuScreen()); 
            ScoreScreen.stopMusic();
        }
    }
   
}    
