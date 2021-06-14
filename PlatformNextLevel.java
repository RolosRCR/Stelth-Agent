import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PlatformNextLevel here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PlatformNextLevel extends Platform
{
    private String level;
    /**
     * Act - do whatever the PlatformNextLevel wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        Coallition();
    }    

    public void Coallition(){

        if (isTouching(Agent.class)){
            level = getWorld().getClass().getName();
            if(level=="Nivel1")
                Greenfoot.setWorld(new Nivel2());
            else
                Greenfoot.setWorld(new Nivel3());
        }
    }
}
