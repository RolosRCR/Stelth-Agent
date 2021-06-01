import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MenuScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MenuScreen extends World
{
       private int x = 0;
       private int y = 0;
    /**
     * Constructor for objects of class MenuScreen.
     * 
     */
    public MenuScreen()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        showMenu();
    }

    public World previousScreen(){
        return new InitialScreen();
    }

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void showMenu(){
        showBottons();
    }
    
    public void showBottons(){
        Botton backBotton = new BackBotton();
        addObject(backBotton,21,13);
        PlayBotton playBotton = new PlayBotton();
        addObject(playBotton,300,100);
        HelpBotton helpBotton = new HelpBotton();
        addObject(helpBotton,300,190);
        ScoreBotton scoreBotton = new ScoreBotton();
        addObject(scoreBotton,300,280);
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
                Greenfoot.setWorld(new InitialScreen());
            }    
            /* if (((x > 300) && (x < 450)) && ((y > 100) && (y < 151)))
            {
                Greenfoot.setWorld(new PlayScreen());
            }
           */
            else if (((x > 225) && (x < 375)) && ((y > 165) && (y < 216)))
            {
                Greenfoot.setWorld(new HelpScreen());
            }     else if (((x > 225) && (x < 375)) && ((y > 255) && (y < 306)))
            {
                Greenfoot.setWorld(new ScoreScreen());
            }     
        }
    }
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
}
