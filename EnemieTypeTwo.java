import greenfoot.*;  
import java.util.*;

public class EnemieTypeTwo extends Enemie
{
    private int counterRight;
    private int counterLeft;
    private double direction;
    private static final int SPEED = 4;
    
    private ArrayList<String> skinMotorcyclistRight = new ArrayList();
    private ArrayList<String> skinMotorcyclistLeft = new ArrayList();
    
    public EnemieTypeTwo(){

        buildSkins();
        //setImage("images/Motociclista1_derecha_A.png");  
        direction=Math.random()*2+1;
    }   
    
    public void act() 
    {
        handleDirection();
    }   
    
    private void handleDirection(){
        int x = getX();
        int y = getY();
        if(isTouching(Platform.class)){
            if((int)direction==RIGHT){
                moveRight(x, y);
                if(x > 590){
                    setLocation(11, 380);
                    counterRight=0;
                }
            }   
            else if((int)direction==LEFT){
                moveLeft(x, y);
                if(x<10){
                    setLocation(585, 380);
                    counterLeft=0;
                }
            }
        }
    }
    
    private void buildSkins(){
        int typeMovements=2;
        
        for(int i=1; i<=typeMovements; i++){
            if(i == RIGHT){
                //skins.add("images/Motociclista1_derecha_A.png");
                skinMotorcyclistRight.add("images/Motociclista1_derecha_B.png");
                skinMotorcyclistRight.add("images/Motociclista1_derecha_C.png");
                skinMotorcyclistRight.add("images/Motociclista1_derecha_D.png");
                skinMotorcyclistRight.add("images/Motociclista1_derecha_E.png");
                skinMotorcyclistRight.add("images/Motociclista1_derecha_F.png");
                skinMotorcyclistRight.add("images/Motociclista1_derecha_G.png");
            }
            else if(i == LEFT){
                //skins.add("images/Motociclista1_izquierda_A.png");
                skinMotorcyclistLeft.add("images/Motociclista1_izquierda_B.png");
                skinMotorcyclistLeft.add("images/Motociclista1_izquierda_C.png");
                skinMotorcyclistLeft.add("images/Motociclista1_izquierda_D.png");
                skinMotorcyclistLeft.add("images/Motociclista1_izquierda_E.png");
                skinMotorcyclistLeft.add("images/Motociclista1_izquierda_F.png");
                skinMotorcyclistLeft.add("images/Motociclista1_izquierda_G.png");
            }
        }
    } 
    
    private void moveLeft(int x, int y){
        direction=LEFT;
        setLocation(x-SPEED, y);
        counterLeft++;
        counterRight=0;
        if(counterLeft < (skinMotorcyclistLeft.size())*(TIMESKIN*4)){
            if(counterLeft % (TIMESKIN*4) == 0)
                setImage(skinMotorcyclistLeft.get(counterLeft/(TIMESKIN*4)));
        }
        else
            counterLeft=0;
    }
    
    private void moveRight(int x, int y){
        direction=RIGHT;
        setLocation(x+SPEED, y);
        counterLeft=0;
        counterRight++;
        if(counterRight < (skinMotorcyclistRight.size())*(TIMESKIN*4)){
            if(counterRight % (TIMESKIN*4) == 0)
                setImage(skinMotorcyclistRight.get(counterRight/(TIMESKIN*4)));
        }
        else
            counterRight=0;
    }
}
