import greenfoot.*;  
import java.util.*;

public class Agent extends Actor
{
    private int counterRight;
    private int counterLeft;
    private int counterUp;
    private int counterDown;
    private int counterGun=0;
    private static final int SPEED = 2;
    private static final int JUMPSPEED = 3;
    private static final int HIGHLIMIT = 0;
    private static final int FALLSPEED = 3;
    private static final int HIGHJUMP=50;
    private static final int RIGHT=1;
    private static final int LEFT=2;
    private static final int UP=4;
    private static final int DOWN=3;
    private static final int NOMOVEMENT=0;
    private int direction;
    private boolean jumping;
    private boolean isJumping;
    private int highAgent;
    private String typeWeapon="MachineGun";

    private ArrayList<String> skinAgentRight = new ArrayList();
    private ArrayList<String> skinAgentLeft = new ArrayList();
    private ArrayList<String> skinAgentJump = new ArrayList();
    private ArrayList<String> skinAgentStairs = new ArrayList();
    private ArrayList<String> skinAgentStanding = new ArrayList();

    public Agent(){

        buildSkins();
        setImage("images/Personaje principal_derecha_A.png");   
    }    

    public void act() 
    {
        handleDirection();
    }    

    public void handleDirection(){
        int x = getX();
        int y = getY();
        counterGun++;
        if(!isTouching(Platform.class) && !isTouching(Stairs.class) &&!jumping){
            fall(x, y);
        }
        else if(isTouching(Platform.class) && direction != DOWN && direction != UP && !jumping){
            if(Greenfoot.isKeyDown("space")){
                jumping=true;
                isJumping = true;
                highAgent=getY();
            }
            else if(Greenfoot.isKeyDown("right")){
                moveRight(x, y);
            }   
            else if(Greenfoot.isKeyDown("left")){
                moveLeft(x, y);
            }
            else if(Greenfoot.isKeyDown("z") && counterGun % cadence(typeWeapon) == 0){
                getWorld().addObject(TypeWeaponFactory.buildWeapon(typeWeapon, direction), getX(), getY());
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

    private void fall(int x, int y){
        setLocation(x, y+FALLSPEED);
        /*if(isTouching(Platform.class)||isTouching(Box.class)){
            setLocation(x, y-FALLSPEED);
            while(!isTouching(Platform.class)){
                setLocation(x, y++);
            }
        }*/
    }

    private void moveLeft(int x, int y){
        direction=LEFT;
        setLocation(x-SPEED, y);
        if(isTouching(Box.class))
            setLocation(x+SPEED, y);
        counterLeft++;
        counterRight=0;
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
        if(isTouching(Box.class))
            setLocation(x-SPEED, y);
        counterLeft=0;
        counterRight++;
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
        }
    }

    private void jump(int x, int y){ 
        int jumpDirection;

        if (direction==RIGHT){
            jumpDirection=1;
            setImage(skinAgentJump.get(0));}
        else {
            jumpDirection=-1;
        setImage(skinAgentJump.get(1));}

        if(y>highAgent-HIGHJUMP && isJumping && y>HIGHLIMIT){
            y=y-JUMPSPEED;
        }
        else{
            isJumping=false;  
        } 
        if(!isTouching(Box.class))
          x=x+(SPEED*jumpDirection);
        setLocation(x , y);

        if(!isJumping&&!isTouching(Platform.class)){
            y=y+JUMPSPEED;
            setLocation(x,y);
            if(isTouching(Platform.class)){
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

        public int cadence(String typeWeapon){
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
