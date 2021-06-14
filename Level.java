import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Level extends Hud
{
    private static int level;
    private String text = "Level: ";
    
    public Level(){
        buildSign(text, level);
    }   
    
    public static void setLevel(int levelX){
        level = levelX;
    }
}
