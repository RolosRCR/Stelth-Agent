import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class BackBotton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class BackBotton extends Botton
{
    /**
     * Act - do whatever the BackBotton wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
       super.act();
          if (Greenfoot.mouseClicked(null))
        {
            if (((x > 0) && (x < 40)) && ((y > 0) && (y < 25)))
            {
                Greenfoot.setWorld(new MenuScreen());
            }       
        }
    }
}    
