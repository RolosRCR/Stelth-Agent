import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MenuScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MenuScreen extends World implements Observer{
    private GreenfootSound backgroundMusic = new GreenfootSound("InitialScreenMusic.MP3");
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

    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void showMenu()
    {
        addObject(new PlayButton(this),300,100);
        addObject(new HelpButton(this),300,190);
        addObject(new ScoreButton(this),300,280);
    }

    public void act()
    {
        super.act();
        if(!backgroundMusic.isPlaying())
        {
            backgroundMusic.play();
        }
    }

    public void eventOcurred()
    {
        backgroundMusic.pause();
    }
}
