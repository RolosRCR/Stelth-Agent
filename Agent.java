import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

public class Agent extends Actor
{
    private int counterRight;
    private int counterLeft;
    private int counterUp;
    private int counterDown;
    private static final int speed = 2;
    private int direction=1;
    
    ArrayList<String> skinAgentRight = new ArrayList();
    ArrayList<String> skinAgentLeft = new ArrayList();
    ArrayList<String> skinAgentJump = new ArrayList();
    ArrayList<String> skinAgentStairs = new ArrayList();
    ArrayList<String> skinAgentStanding = new ArrayList();
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
        //moveBody();
        handleDirection();
        
    }    
    public void handleDirection(){
        int x = getX();
        int y = getY();
    
        if(isTouching(Platform.class) && direction != 3 && direction != 4){
            if(Greenfoot.isKeyDown("right")){
                moveRight(x, y);
            }   
            else if(Greenfoot.isKeyDown("left")){
                moveLeft(x, y);
            }   
            else if (direction != 0){
                standing(x, y); 
            }
        }  
        if(isTouching(Stairs.class)  && direction !=0){
            if(Greenfoot.isKeyDown("down") && !isTouching(PlatformSteel.class)){                          
                moveDown(x, y);
            }
            else if(Greenfoot.isKeyDown("up")){
                moveUp(x, y);
            }
            else if(direction==3 && isTouching(PlatformSteel.class)){
                if(Greenfoot.isKeyDown("right") || Greenfoot.isKeyDown("left"))
                    direction=0;
            }
        }
        else if(!isTouching(Stairs.class) && direction ==4){
            if(Greenfoot.isKeyDown("right") || Greenfoot.isKeyDown("left")){
                setLocation(x, y + 6);
                direction=0;
            }
        }
    }
    
    private void moveLeft(int x, int y){
        direction=2;
        setLocation(x-speed, y);
        counterLeft++;
        counterRight=0;
        if(counterLeft < (skinAgentLeft.size()-1)*3){
            if(counterLeft % 3 == 0)
                setImage(skinAgentLeft.get(counterLeft/3));
        }
        else
            counterLeft=0;
    }
    
    private void moveRight(int x, int y){
        direction=1;
        setLocation(x+speed, y);
        counterLeft=0;
        counterRight++;
        if(counterRight < (skinAgentRight.size()-1)*3){
            if(counterRight % 3 == 0)
                setImage(skinAgentRight.get(counterRight/3));
        }
        else
            counterRight=0;
    }
    
    private void moveDown(int x, int y){  
        setLocation(x, y +speed);
        direction = 3;
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
        setLocation(x, y - speed);
        direction = 4;
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
