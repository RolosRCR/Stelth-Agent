import greenfoot.*;  
import java.util.*;

public class EnemieTypeOne extends Enemigo
{
    private int counterRight;
    private int counterLeft;
    private int counterGun=0;
    private static final int SPEED = 2;
    private static final int RIGHT=1;
    private static final int LEFT=2;
    private int direction;
    
    private ArrayList<String> skinEnemieRight = new ArrayList();
    private ArrayList<String> skinEnemieLeft = new ArrayList();
    private ArrayList<String> skinEnemieStanding = new ArrayList();
    
    public EnemieTypeOne(){
        skinEnemieRight.add("Right");
        skinEnemieLeft.add("Left");
        skinEnemieStanding.add("Standing");
        
        buildSkins(skinEnemieRight);
        buildSkins(skinEnemieLeft);
        buildSkins(skinEnemieStanding);
        setImage("images/enemigo1_derecha_A.png");  
        direction=(int)Math.random()*1+1;
    }    
    public void act() 
    {
        handleDirection();
    }    
    public void handleDirection(){
        int x = getX();
        int y = getY();
        //counterGun++;
        if(isTouching(Platform.class)){
            if(direction==RIGHT){
                moveRight(x, y);
                if(x > 590)
                    direction=LEFT;
            }   
            else if(direction==LEFT){
                moveLeft(x, y);
                if(x<10)
                    direction = RIGHT;
            }
        }
    }
    
    private void moveLeft(int x, int y){
        direction=LEFT;
        setLocation(x-SPEED, y);
        counterLeft++;
        counterRight=0;
        if(counterLeft < (skinEnemieLeft.size())*3){
            if(counterLeft % 3 == 0)
                setImage(skinEnemieLeft.get(counterLeft/3));
        }
        else
            counterLeft=0;
    }
    
    private void moveRight(int x, int y){
        direction=RIGHT;
        setLocation(x+SPEED, y);
        counterLeft=0;
        counterRight++;
        if(counterRight < (skinEnemieRight.size())*3){
            if(counterRight % 3 == 0)
                setImage(skinEnemieRight.get(counterRight/3));
        }
        else
            counterRight=0;
    }
    
    private void standing(int x, int y){
        setImage(skinEnemieStanding.get(direction));
    }
    
    public void buildSkins(List skins){
        if(skins.get(0) == "Right"){
            skins.add("images/enemigo1_derecha_B.png");
            skins.add("images/enemigo1_derecha_C.png");
            skins.add("images/enemigo1_derecha_D.png");
            skins.add("images/enemigo1_derecha_E.png");
            skins.add("images/enemigo1_derecha_F.png");
            skins.add("images/enemigo1_derecha_G.png");
        }
        else if(skins.get(0) == "Left"){
            skins.add("images/enemigo1_izquierda_B.png");
            skins.add("images/enemigo1_izquierda_C.png");
            skins.add("images/enemigo1_izquierda_D.png");
            skins.add("images/enemigo1_izquierda_E.png");
            skins.add("images/enemigo1_izquierda_F.png");
            skins.add("images/enemigo1_izquierda_G.png");
        }
        else if(skins.get(0) == "Standing"){
            skins.add("images/enemigo1_derecha_A.png");
            skins.add("images/enemigo1_izquierda_A.png");       
        }
    } 
    
    public int getPositionX(){
        return getX();   
    }
    public int getPositionY(){
        return getY();
    }
    public int getDirection(){
        return direction;
    }
}
