import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class WinScreen extends World
{
    GreenfootSound music = new GreenfootSound("WinMusic.mp3");
    public WinScreen()
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
