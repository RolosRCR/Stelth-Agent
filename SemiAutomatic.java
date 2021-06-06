import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class SemiAutomatic extends Weapon
{
    private static final int SPEED = 6;
    private int direction;
    private static final int HURT=2;
    private int x;
    private int y;
    
    public SemiAutomatic(int direction){
        this.direction=direction;
        setImage("images/gunType2.png");   
    }
    public void act() 
    { 
        x=getX();
        y=getY();
        if(direction == 1){
            setLocation(x+SPEED, y); 
            if(x > 600)
                getWorld().removeObjects(getWorld().getObjects(SemiAutomatic.class));   
        }
        else if(direction == 2){
            setLocation(x-SPEED, y);
            if(x < 0)
                getWorld().removeObjects(getWorld().getObjects(SemiAutomatic.class)); 
        }
        Collision();
    }   
    
    public int getPositionX(){
        return getX(); 
    }
    
    public int getPositionY(){
        return getY();
    }
    
    public void Collision(){
        if(getX() > 590 || getX() < 10){
            getWorld().removeObject(this);
        }    
    } 
}
