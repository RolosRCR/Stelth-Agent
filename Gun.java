import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
public class Gun extends Weapon
{
    private int direction;
    private int keyWeapon;
    private int x;
    private int y;
    private static final int HURT=2;
    private static final int SPEED = 4;
    private static final int RIGHT=1;
    private static final int LEFT=2;
    private static final int UP=4;
    
    public Gun(int direction, int keyWeapon){
        this.direction=direction;
        this.keyWeapon = keyWeapon;
        setImage("images/gunType1.png");   
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
        collision();
    } 
   
    private void collision(){
        //System.out.println(keyWeapon);
        if(getX() > 590 || getX() < 10 || getY() > 395 || getY() < 10 && isTouching(Platform.class)){
            getWorld().removeObject(this);
        }  
        else if(keyWeapon == KEYWEAPONPLAYER){
            Actor collided = getOneIntersectingObject(Enemie.class);
            if(collided != null){
                Enemie.subtractLife(keyWeapon, HURT);
            }            
        }
        else if(keyWeapon == KEYWEAPONENEMIE){
            if(isTouching(Agent.class)){
                getWorld().removeObject(this);
                Life.subtract(HURT);
                Enemie.subtractLife(keyWeapon, HURT);
            }
        }
    } 
}
