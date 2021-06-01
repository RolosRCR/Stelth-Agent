import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HelpBotton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HelpBotton extends Botton
{
    /**
     * Act - do whatever the HelpBotton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        super.act();
        if (Greenfoot.mouseClicked(null))
        {
            if (((x > 225) && (x < 375)) && ((y > 165) && (y < 216)))
            {
                Greenfoot.setWorld(new HelpScreen());
            } 
        }
    }    
}
