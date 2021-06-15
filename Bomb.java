import greenfoot.*;  
import java.util.ArrayList;

public class Bomb extends Weapon
{
    private static final int SPEED = 4;
    private static final int HURT=10;
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
        collision(keyWeapon,HURT);
    }   
    
    private void buildSkins(){
        skinDown.add("images/bomba_caida_A.png");
        skinDown.add("images/bomba_caida_B.png");
    }
    
}
