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
    private int previousScore;
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
            if(level=="Nivel1"){
                Score.passScoreToNewLevel();
                Greenfoot.setWorld(new Nivel2());
            }
            else{
                Score.passScoreToNewLevel();
                Greenfoot.setWorld(new Nivel3());
               }
        }
    }
    public boolean isTouchedByAgent(){
    return this.isTouching(Agent.class);
    }
}
