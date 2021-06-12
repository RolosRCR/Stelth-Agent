import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class MachineGun extends Weapon
{
    private static final int SPEED = 8;
    private int direction ;
    private static final int HURT=2;
    private int x;
    private int y;
    
    public MachineGun(int direction){
        this.direction=direction;
        setImage("images/gunType3.png");   
    }
    public void act() 
    { 
        x=getX();
        y=getY();
        if(direction == 1){
            setLocation(x+SPEED, y); 
            if(x > 600)
                getWorld().removeObjects(getWorld().getObjects(MachineGun.class));   
        }
        else if(direction == 2){
            setLocation(x-SPEED, y);
            if(x < 0)
                getWorld().removeObjects(getWorld().getObjects(MachineGun.class)); 
        }
        collision();
    }   
    
}
