import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class PlayButton extends Button
{
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
