import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Escalera here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Stairs extends Actor
{
    private static int platformWidth=94;
    private static int platformHigh=9;
    public Stairs(int num){
        setImage("images/Escalera"+num+".png");   
    }
    /**
     * Act - do whatever the Escalera wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public static int getWidth(){
    return platformWidth;
    }
    public static int getHigh(){
    return platformHigh;
    } 
}
