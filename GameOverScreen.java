import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class GameOverScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class GameOverScreen extends World
{
        GreenfootSound music = new GreenfootSound("EndMusic.mp3");

    public GameOverScreen()
    {    
        super(600, 400, 1);
    }

    public void act(){
        if(!music.isPlaying())
        { 
            music.setVolume(20);
            music.play();
        }
        if(Greenfoot.isKeyDown("space"))
        {
            music.stop();
            Greenfoot.setWorld(new MenuScreen());            
        }   
    }
    
}
