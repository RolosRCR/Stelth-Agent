import greenfoot.*;  
import java.util.ArrayList;

public class Bomb extends Weapon
{
    private static final int SPEED = 4;
    private static final int HURT=2;
    private static final int TIMESKIN=3;
    private int counterDown=0;
    private int keyWeapon;
    private int x;
    private int y;
    private ArrayList<String> skinDown = new ArrayList();
    
    public Bomb(int keyWeapon){  
        this.keyWeapon = keyWeapon;
        buildSkins();  
    }
    public void act() 
    { 
        x=getX();
        y=getY();
        counterDown++;
        setLocation(x, y + SPEED); 
        if(counterDown < (skinDown.size())*TIMESKIN+3){
            if(counterDown % TIMESKIN == 0)
                setImage(skinDown.get(counterDown/TIMESKIN-1));
        }
        collision();
    }   
    
    private void buildSkins(){
        skinDown.add("images/bomba_caida_A.png");
        skinDown.add("images/bomba_caida_B.png");
    }
    
    private void collision(){
        if(getX() > 590 || getX() < 10 || getY() > 395 || getY() < 10){
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
