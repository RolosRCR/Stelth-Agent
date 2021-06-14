import greenfoot.*;  
import java.util.*;

public class Agent extends Actor
{
    private int counterRight;
    private int counterLeft;
    private int counterUp;
    private int counterDown;
    private int counterGun=0;
    private int direction;
    private boolean jumping;
    private boolean startJumping;
    private int highAgent;
    private String typeWeapon="MachineGun";
    private static final int SPEED = 2;
    private static final int JUMPSPEED = 3;
    private static final int HIGHJUMP=40;
    private static final int RIGHT=1;
    private static final int LEFT=2;
    private static final int UP=4;
    private static final int DOWN=3;
    private static final int UPWEAPON=5;
    private static final int NOMOVEMENT=0;
    private static final int KEYWEAPON=1;
    
    private ArrayList<String> skinAgentRight = new ArrayList();
    private ArrayList<String> skinAgentLeft = new ArrayList();
    private ArrayList<String> skinAgentJump = new ArrayList();
    private ArrayList<String> skinAgentStairs = new ArrayList();
    private ArrayList<String> skinAgentStanding = new ArrayList();
    private ArrayList<String> skinAgentUpWeapon = new ArrayList();
    
    public Agent(){

        buildSkins();
        setImage("images/Personaje principal_derecha_A.png");   
    }    
    public void act() 
    {
        handleDirection();
    }    
    private void handleDirection(){
        int x = getX();
        int y = getY();
        counterGun++;
        if(isTouching(Platform.class) && direction != DOWN && direction != UP && !jumping){
            if(Greenfoot.isKeyDown("right")){
                moveRight(x, y);
            }   
            else if(Greenfoot.isKeyDown("left")){
                moveLeft(x, y);
            }
            else if(Greenfoot.isKeyDown("z") && counterGun % cadence(typeWeapon) == 0){
                getWorld().addObject(TypeWeaponFactory.buildWeapon(typeWeapon, direction, KEYWEAPON), getX(), getY());
            }
            else if(!isTouching(Stairs.class) && Greenfoot.isKeyDown("up")){
                if(direction == RIGHT)
                    setImage(skinAgentUpWeapon.get(direction-1));
                else if(direction == LEFT)
                    setImage(skinAgentUpWeapon.get(direction-1));
                if(counterGun % cadence(typeWeapon) == 0)
                 getWorld().addObject(TypeWeaponFactory.buildWeapon(typeWeapon, UP, KEYWEAPON), getX(), getY());
            }
            else if(Greenfoot.isKeyDown("space")){
                jumping=true;
                startJumping = true;
                highAgent=getY();
            }
            else if (direction != NOMOVEMENT){
                standing(x, y); 
            }
        }
        else if(jumping){
            jump(x, y);
        }
        if(isTouching(Stairs.class)  && direction != NOMOVEMENT && !jumping){
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
        counterGun=0;
        if(counterLeft < (skinAgentLeft.size())*3+3){
            if(counterLeft % 3 == 0)
                setImage(skinAgentLeft.get(counterLeft/3-1));
        }
        else
            counterLeft=0;
    }
    
    private void moveRight(int x, int y){
        direction=RIGHT;
        setLocation(x+SPEED, y);
        counterLeft=0;
        counterRight++;
        counterGun=0;
        if(counterRight < (skinAgentRight.size())*3+3){
            if(counterRight % 3 == 0)
                setImage(skinAgentRight.get(counterRight/3-1));
        }
        else
            counterRight=0;
    }
    
    private void moveDown(int x, int y){  
        setLocation(x, y +SPEED);
        direction = DOWN;
        counterUp=0;
        counterDown++;
        counterGun=0;
        if(counterDown < ((skinAgentStairs.size())*3+3)){
            if(counterDown % 3 == 0)
                setImage(skinAgentStairs.get(counterDown/3-1));
        }
        else
            counterDown=0;
    } 
    
    private void moveUp(int x, int y){
        setLocation(x, y - SPEED);
        direction = UP;
        counterUp++;
        counterDown=0;
        counterGun=0;
        if(counterUp < ((skinAgentStairs.size())*3+3)){
            if(counterUp % 3 == 0)
                setImage(skinAgentStairs.get(counterUp/3-1));
        }
        else
            counterUp=0;
    }
    
    private void standing(int x, int y){
        setImage(skinAgentStanding.get(direction-1));
    }
    
    private void buildSkins(){
        int movementTypes=5;
        
        for(int i=0; i<=5; i++){
            if(i == RIGHT){
                skinAgentRight.add("images/Personaje principal_derecha_B.png");
                skinAgentRight.add("images/Personaje principal_derecha_C.png");
                skinAgentRight.add("images/Personaje principal_derecha_D.png");
                skinAgentRight.add("images/Personaje principal_derecha_E.png");
                skinAgentRight.add("images/Personaje principal_derecha_F.png");
                skinAgentRight.add("images/Personaje principal_derecha_G.png");
            }
            else if(i == LEFT){
                skinAgentLeft.add("images/Personaje principal_izquierda_B.png");
                skinAgentLeft.add("images/Personaje principal_izquierda_C.png");
                skinAgentLeft.add("images/Personaje principal_izquierda_D.png");
                skinAgentLeft.add("images/Personaje principal_izquierda_E.png");
                skinAgentLeft.add("images/Personaje principal_izquierda_F.png");
                skinAgentLeft.add("images/Personaje principal_izquierda_G.png");
            }
            else if(i == UP){
                skinAgentJump.add("images/Personaje principal-Salto_derecha_B.png");        
                skinAgentJump.add("images/Personaje principal-Salto_izquierda_B.png");
            }
            else if(i == DOWN){
                skinAgentStairs.add("images/Personaje principal_Arriba-Abajo-A.png");
                skinAgentStairs.add("images/Personaje principal_Arriba-Abajo-B.png");
            }
            else if(i == NOMOVEMENT){
                skinAgentStanding.add("images/Personaje principal_derecha_A.png");
                skinAgentStanding.add("images/Personaje principal_izquierda_A.png");
                skinAgentStanding.add("images/Personaje principal_Arriba-Abajo-A.png");
                skinAgentStanding.add("images/Personaje principal_Arriba-Abajo-B.png");        
            }
            else if(i == UPWEAPON){
                skinAgentUpWeapon.add("images/Personaje principal_derechaArriba_A.png");
                skinAgentUpWeapon.add("images/Personaje principal_izquierdaArriba_A.png");
            }
        }
    }
    
    
    private void jump(int x, int y){
        if (direction == RIGHT){ 
            setImage(skinAgentJump.get(direction-1));
            if(startJumping == true){
                setLocation(x + SPEED, y - JUMPSPEED);
                if(y>highAgent-HIGHJUMP){
                    x=x+SPEED;
                    y=y-JUMPSPEED;
                }
                else
                    startJumping=false;
            }
            else if(startJumping==false){
                setLocation(x + SPEED, y + JUMPSPEED);
                x=x+SPEED;
                y=y+JUMPSPEED;
                if(y==highAgent)
                    jumping=false;
            }
        }
        else if(direction == LEFT){
            setImage(skinAgentJump.get(direction-1));
            if(startJumping== true){
                setLocation(x - SPEED, y - JUMPSPEED);
                if(y>highAgent-HIGHJUMP){
                    x=x-SPEED;
                    y=y-JUMPSPEED;
                }
                else{
                    startJumping=false;
                }
            }
            else if(startJumping==false){
                setLocation(x - SPEED, y + JUMPSPEED);
                x=x-SPEED;
                y=y+JUMPSPEED;  
                if(y==highAgent)
                    jumping=false;
            } 
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
    
    private int cadence(String typeWeapon){
        switch(typeWeapon){
           case "Gun":
               return 15;
           case "SemiAutomatic":
               return 10;
           case "MachineGun":
               return 5;
           default:
               return 100;
        }
    }
}
