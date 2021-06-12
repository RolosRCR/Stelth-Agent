import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class Gun extends Weapon
{
    private static final int SPEED = 4;
    private int direction;
    private static final int HURT=2;
    private int x;
    private int y;
    
    public Gun(int direction){
        this.direction=direction;
        setImage("images/gunType1.png");   
    }
    public void act() 
    { 
        x=getX();
        y=getY();
        if(direction == 1){
            setLocation(x+SPEED, y); 
            if(x > 600)
                getWorld().removeObjects(getWorld().getObjects(Gun.class));   
        }
        else if(direction == 2){
            setLocation(x-SPEED, y);
            if(x < 0)
                getWorld().removeObjects(getWorld().getObjects(Gun.class)); 
        }
        collision();
    }   
}
