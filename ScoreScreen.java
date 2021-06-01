import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ScoreScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ScoreScreen extends World
{
    private int x = 0;
    private int y = 0;
    /**
     * Constructor for objects of class ScoreScreen.
     * 
     */
    public ScoreScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        showBottons();
    }
    
    public void showBottons(){
        Botton backBotton = new BackBotton();
        addObject(backBotton,21,13);
    }
    public void act()
    {
    MouseInfo mouse = Greenfoot.getMouseInfo();
        if (mouse != null)
        {
            x = mouse.getX();
            y = mouse.getY();
        }
          if (Greenfoot.mouseClicked(null))
        {
            if (((x > 0) && (x < 40)) && ((y > 0) && (y < 25)))
            {
                Greenfoot.setWorld(new MenuScreen());
            }       
        }
    }
}
