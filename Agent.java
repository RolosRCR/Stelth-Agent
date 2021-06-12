import greenfoot.*;  
import java.util.*;

public class Agent extends Actor
{
    private int counterRight;
    private int counterLeft;
    private int counterUp;
    private int counterDown;
    private static final int SPEED = 2;
    private static final int RIGHT=1;
    private static final int LEFT=2;
    private static final int UP=4;
    private static final int DOWN=3;
    private static final int NOMOVEMENT=0;
    private int direction;
    
    private ArrayList<String> skinAgentRight = new ArrayList();
    private ArrayList<String> skinAgentLeft = new ArrayList();
    private ArrayList<String> skinAgentJump = new ArrayList();
    private ArrayList<String> skinAgentStairs = new ArrayList();
    private ArrayList<String> skinAgentStanding = new ArrayList();
    
    public Agent(){
        skinAgentRight.add("Right");
        skinAgentLeft.add("Left");
        skinAgentJump.add("Jump");
        skinAgentStairs.add("Stairs");
        skinAgentStanding.add("Standing");
        
        buildSkins(skinAgentRight);
        buildSkins(skinAgentLeft);
        buildSkins(skinAgentJump);
        buildSkins(skinAgentStairs);
        buildSkins(skinAgentStanding);
        setImage("images/Personaje principal_derecha_A.png");   
    }    
    public void act() 
    {
        handleDirection();        
    }    
    public void handleDirection(){
        int x = getX();
        int y = getY();
    
        if(isTouching(Platform.class) && direction != DOWN && direction != UP){
            if(Greenfoot.isKeyDown("right")){
                moveRight(x, y);
            }   
            else if(Greenfoot.isKeyDown("left")){
                moveLeft(x, y);
            }   
            else if (direction != NOMOVEMENT){
                standing(x, y); 
            }
        }  
        if(isTouching(Stairs.class)  && direction != NOMOVEMENT){
            if(Greenfoot.isKeyDown("down") && !isTouching(PlatformSteel.class)){                          
                moveDown(x, y);
            }
            else if(Greenfoot.isKeyDown("up")){
                moveUp(x, y);
            }
            else if(direction==3 && isTouching(PlatformSteel.class)){
                if(Greenfoot.isKeyDown("right") || Greenfoot.isKeyDown("left"))
                    direction=NOMOVEMENT;
            }
        }
        else if(!isTouching(Stairs.class) && direction == UP){
            if(Greenfoot.isKeyDown("right") || Greenfoot.isKeyDown("left")){
                setLocation(x, y + 6);
                direction=NOMOVEMENT;
            }
        }
        
    }
    
    private void moveLeft(int x, int y){
        direction=LEFT;
        setLocation(x-SPEED, y);
        counterLeft++;
        counterRight=0;
        if(counterLeft < (skinAgentLeft.size())*3){
            if(counterLeft % 3 == 0)
                setImage(skinAgentLeft.get(counterLeft/3));
        }
        else
            counterLeft=0;
    }
    
    private void moveRight(int x, int y){
        direction=RIGHT;
        setLocation(x+SPEED, y);
        counterLeft=0;
        counterRight++;
        if(counterRight < (skinAgentRight.size())*3){
            if(counterRight % 3 == 0)
                setImage(skinAgentRight.get(counterRight/3));
        }
        else
            counterRight=0;
    }
    
    private void moveDown(int x, int y){  
        setLocation(x, y +SPEED);
        direction = DOWN;
        counterUp=0;
        counterDown++;
        if(counterDown < ((skinAgentStairs.size())*3)){
            if(counterDown % 3 == 0)
                setImage(skinAgentStairs.get(counterDown/3));
        }
        else
            counterDown=0;
    } 
    
    private void moveUp(int x, int y){
        setLocation(x, y - SPEED);
        direction = UP;
        counterUp++;
        counterDown=0;
        if(counterUp < ((skinAgentStairs.size())*3)){
            if(counterUp % 3 == 0)
                setImage(skinAgentStairs.get(counterUp/3));
        }
        else
            counterUp=0;
    }
    
    private void standing(int x, int y){
        setImage(skinAgentStanding.get(direction));
    }
    
    public void buildSkins(List skins){
        if(skins.get(0) == "Right"){
            skins.add("images/Personaje principal_derecha_B.png");
            skins.add("images/Personaje principal_derecha_C.png");
            skins.add("images/Personaje principal_derecha_D.png");
            skins.add("images/Personaje principal_derecha_E.png");
            skins.add("images/Personaje principal_derecha_F.png");
            skins.add("images/Personaje principal_derecha_G.png");
        }
        else if(skins.get(0) == "Left"){
            skins.add("images/Personaje principal_izquierda_B.png");
            skins.add("images/Personaje principal_izquierda_C.png");
            skins.add("images/Personaje principal_izquierda_D.png");
            skins.add("images/Personaje principal_izquierda_E.png");
            skins.add("images/Personaje principal_izquierda_F.png");
            skins.add("images/Personaje principal_izquierda_G.png");
        }
        else if(skins.get(0) == "Jump"){
            skins.add("images/Personaje principal-Salto_derecha_B.png");        
            skins.add("images/Personaje principal-Salto_izquierda_B.png");
        }
        else if(skins.get(0) == "Stairs"){
            skins.add("images/Personaje principal_Arriba-Abajo-A.png");
            skins.add("images/Personaje principal_Arriba-Abajo-B.png");
        }
        else if(skins.get(0) == "Standing"){
            skins.add("images/Personaje principal_derecha_A.png");
            skins.add("images/Personaje principal_izquierda_A.png");
            skins.add("images/Personaje principal_Arriba-Abajo-A.png");
            skins.add("images/Personaje principal_Arriba-Abajo-B.png");        
        }
    }
}
