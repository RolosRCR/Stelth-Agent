import greenfoot.*;

/**
 * Write a description of class Weapon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Weapon extends Actor
{
    private static final int KEYWEAPONPLAYER = 1;
    private static final int KEYWEAPONENEMIE = 2;
    
    public int getPositionX(){
        return getX(); 
    }
    
    public int getPositionY(){
        return getY();
    }
    
    public void collision(int keyWeapon){
        if(getX() > 590 || getX() < 10 || getY() > 395 || getY() < 10 || isTouching(Platform.class)){
            getWorld().removeObject(this);
        }  
        else if(keyWeapon == KEYWEAPONPLAYER){
            if(isTouching(Enemie.class))
                getWorld().removeObject(this);
        }
        else if(keyWeapon == KEYWEAPONENEMIE){
            if(isTouching(Agent.class))
                getWorld().removeObject(this);
        }
    } 
    
}
