import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Records extends Hud
{
    private static int score;
    private static int objective;
    
    public Records(String name, int score){
        buildSign(name, score);
    }   
}
