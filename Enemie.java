import greenfoot.*;

public class Enemie extends Actor
{    
    public static final int RIGHT=1;
    public static final int LEFT=2;
    public static final int STAND=0;
    public static final int TIMESKIN=3;
    public static final int KEYWEAPON=2;
    public static int positionYPlayer;
    public static int positionXPlayer;
    
    public void act() 
    {
        // Add your action code here.
    }    
    
    public static void setPositionPlayer(int x, int y){
        positionYPlayer = y;
        positionXPlayer = x;
    }
    
    public int getPositionYPlayer(){
        return positionYPlayer;   
    }
    
    public int getPositionXPlayer(){
        return positionXPlayer;
    }
}
