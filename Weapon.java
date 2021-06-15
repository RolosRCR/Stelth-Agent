import greenfoot.*;

/**
 * Write a description of class Weapon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Weapon extends Actor
{
    public static final int KEYWEAPONPLAYER = 1;
    public static final int KEYWEAPONENEMIE = 2;

    public int getPositionX(){
        return getX(); 
    }

    public int getPositionY(){
        return getY();
    }

    protected void collision(int keyWeapon, int HURT){
        if(getX() > 590 || getX() < 10 || getY() > 395 || getY() < 10 || isTouching(Platform.class)|| isTouching(Box.class)){
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
            }
        }

    } 

}
