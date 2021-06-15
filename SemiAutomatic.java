import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class SemiAutomatic extends Weapon
{
    private int direction;
    private int keyWeapon;
    private int x;
    private int y;
    private static final int SPEED = 6;
    private static final int HURT=3;
    private static final int RIGHT=1;
    private static final int LEFT=2;
    private static final int UP=4;
    
    public SemiAutomatic(int direction, int keyWeapon){
        this.direction=direction;
        this.keyWeapon = keyWeapon;
        setImage("images/gunType2.png");   
    }
    public void act() 
    { 
        x=getX();
        y=getY();
        if(direction == RIGHT)
            setLocation(x+SPEED, y);
        else if(direction == LEFT)
            setLocation(x-SPEED, y);        
        else if(direction == UP)
            setLocation(x , y-SPEED);
        collision(keyWeapon,HURT);
    }   
    
}
