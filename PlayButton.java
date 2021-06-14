import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlayBotton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlayButton extends Button
{
    /**
     * Act - do whatever the PlayBotton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public PlayButton(Observer ... observers)
    {
        super(observers);
    }

    public void act()
    {
        super.act();
        if(Greenfoot.mouseClicked(this)){
            Hud.initializeHud();
            Score.setHudScore();
            Greenfoot.setWorld(new Nivel1());
        }
    }
}
