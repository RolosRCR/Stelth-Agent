import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class InitialScreen extends World
{
    GreenfootSound music = new GreenfootSound("intro.mp3");
    
    public InitialScreen()
    {    
        
        super(600, 400, 1);
        prepare();
    }

    private void prepare()
    {
        InitialScreenText initialScreenText = new InitialScreenText();
        addObject(initialScreenText,297,187);
    }

    public void act()
    {
 
        if(!music.isPlaying())
        { 
            music.setVolume(5);
            music.play();
        }
        if(Greenfoot.isKeyDown("space"))
        {
            music.stop();
            Greenfoot.setWorld(new MenuScreen());  
            
        }
    }

}
