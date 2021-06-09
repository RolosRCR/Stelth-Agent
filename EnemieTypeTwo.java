import greenfoot.*;  
import java.util.*;

public class EnemieTypeTwo extends Enemigo
{
    private int counterRight;
    private int counterLeft;
    private static final int SPEED = 4;
    private static final int RIGHT=1;
    private static final int LEFT=2;
    private int direction;
    
    private ArrayList<String> skinMotorcyclistRight = new ArrayList();
    private ArrayList<String> skinMotorcyclistLeft = new ArrayList();
    
    public EnemieTypeTwo(){
        skinMotorcyclistRight.add("Right");
        skinMotorcyclistLeft.add("Left");
        
        buildSkins(skinMotorcyclistRight);
        buildSkins(skinMotorcyclistLeft);
        setImage("images/Motociclista1_derecha_A.png");  
        direction=(int)Math.random()*1+1;
    }    
    public void act() 
    {
        handleDirection();
    }    
    public void handleDirection(){
        int x = getX();
        int y = getY();
        if(isTouching(Platform.class)){
            if(direction==RIGHT){
                moveRight(x, y);
                if(x > 590){
                    setLocation(11, 380);
                    counterRight=0;
                }
            }   
            else if(direction==LEFT){
                moveLeft(x, y);
                if(x<10){
                    setLocation(585, 380);
                    counterLeft=0;
                }
            }
        }
    }
    
    private void moveLeft(int x, int y){
        direction=LEFT;
        setLocation(x-SPEED, y);
        counterLeft++;
        counterRight=0;
        if(counterLeft < (skinMotorcyclistLeft.size())*3){
            if(counterLeft % 3 == 0)
                setImage(skinMotorcyclistLeft.get(counterLeft/3));
        }
        else
            counterLeft=0;
    }
    
    private void moveRight(int x, int y){
        direction=RIGHT;
        setLocation(x+SPEED, y);
        counterLeft=0;
        counterRight++;
        if(counterRight < (skinMotorcyclistRight.size())*15){
            if(counterRight % 15 == 0)
                setImage(skinMotorcyclistRight.get(counterRight/15));
        }
        else
            counterRight=0;
    }
    
    public void buildSkins(List skins){
        if(skins.get(0) == "Right"){
            //skins.add("images/Motociclista1_derecha_A.png");
            skins.add("images/Motociclista1_derecha_B.png");
            skins.add("images/Motociclista1_derecha_C.png");
            skins.add("images/Motociclista1_derecha_D.png");
            skins.add("images/Motociclista1_derecha_E.png");
            skins.add("images/Motociclista1_derecha_F.png");
            skins.add("images/Motociclista1_derecha_G.png");
        }
        else if(skins.get(0) == "Left"){
            //skins.add("images/Motociclista1_izquierda_A.png");
            skins.add("images/Motociclista1_izquierda_B.png");
            skins.add("images/Motociclista1_izquierda_C.png");
            skins.add("images/Motociclista1_izquierda_D.png");
            skins.add("images/Motociclista1_izquierda_E.png");
            skins.add("images/Motociclista1_izquierda_F.png");
            skins.add("images/Motociclista1_izquierda_G.png");
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
