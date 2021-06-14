import greenfoot.*;  
import java.util.*;

public class Plane extends Enemie
{
    private int counterRight;
    private int counterLeft;
    private int counterGun=0;
    private int life=110;
    private double direction;
    private static final String TYPEWEAPON= "Bomb";
    private int levelPower;
    private int cadenceWeapon;
    private static final int SPEED = 3;
    
    private ArrayList<String> skinEnemieRight = new ArrayList();
    private ArrayList<String> skinEnemieLeft = new ArrayList();
    private ArrayList<String> skinEnemieStanding = new ArrayList();
    
    public Plane(int levelPower){
        this.levelPower = levelPower;
        buildSkins();
        setWeapon(); 
        direction=Math.random()*1+1;
    } 
    
    public void act() 
    {
        handleDirection();
    } 
    
    private void handleDirection(){
        int x = getX();
        int y = getY();
        counterGun++;
        if(!isTouching(Platform.class)){
            if((int)direction==RIGHT){
                moveRight(x, y);
                if(x > 590){
                    direction=LEFT;
                    counterGun=0;
                }
            }   
            else if((int)direction==LEFT){
                moveLeft(x, y);
                if(x<10){
                    direction = RIGHT;
                    counterGun=0;
                }
            }
            if(counterGun % cadenceWeapon == 0){
                getWorld().addObject(TypeWeaponFactory.buildWeapon(TYPEWEAPON, 0, KEYWEAPONENEMIE), x, y + 35);
            }
        }
        life();
    }
    
    private void buildSkins(){
        int typeMovements=3;
        for(int i=0; i<typeMovements; i++){
            if(i == RIGHT){
                skinEnemieRight.add("images/avion_derecha_A.png");
                skinEnemieRight.add("images/avion_derecha_B.png");
                skinEnemieRight.add("images/avion_derecha_C.png");
                skinEnemieRight.add("images/avion_derecha_B.png");
                skinEnemieRight.add("images/avion_derecha_A.png");
                skinEnemieRight.add("images/avion_frente_A.png");
                skinEnemieRight.add("images/avion_izquierda_A.png");
                skinEnemieRight.add("images/avion_izquierda_B.png");
                skinEnemieRight.add("images/avion_izquierda_C.png");
                skinEnemieRight.add("images/avion_izquierda_B.png");
                skinEnemieRight.add("images/avion_izquierda_A.png");
                skinEnemieRight.add("images/avion_frente_A.png");
            }
            else if(i == LEFT){
                skinEnemieLeft.add("images/avion_izquierda_A.png");
                skinEnemieLeft.add("images/avion_izquierda_B.png");
                skinEnemieLeft.add("images/avion_izquierda_C.png");
                skinEnemieLeft.add("images/avion_izquierda_B.png");
                skinEnemieLeft.add("images/avion_izquierda_A.png");
                skinEnemieLeft.add("images/avion_frente_A.png");
                skinEnemieLeft.add("images/avion_derecha_A.png");
                skinEnemieLeft.add("images/avion_derecha_B.png");
                skinEnemieLeft.add("images/avion_derecha_C.png");
                skinEnemieLeft.add("images/avion_derecha_B.png");
                skinEnemieLeft.add("images/avion_derecha_A.png");
                skinEnemieLeft.add("images/avion_frente_A.png");
            }
            else if(i == STAND){
                skinEnemieStanding.add("images/avion_frente_A.png");     
            }
        }
    } 
    
    private void moveLeft(int x, int y){
        direction=LEFT;
        setLocation(x-SPEED, y);
        counterLeft++;
        counterRight=0;
        if(counterLeft < (skinEnemieLeft.size())*(TIMESKIN*2)){
            if(counterLeft % (TIMESKIN*2) == 0)
                setImage(skinEnemieLeft.get(counterLeft/(TIMESKIN*2)));
        }
        else
            counterLeft=0;
    }
    
    private void moveRight(int x, int y){
        direction=RIGHT;
        setLocation(x+SPEED, y);
        counterLeft=0;
        counterRight++;
        if(counterRight < (skinEnemieRight.size())*(TIMESKIN*2)){
            if(counterRight % (TIMESKIN*2) == 0)
                setImage(skinEnemieRight.get(counterRight/(TIMESKIN*2)));
        }
        else
            counterRight=0;
    }
    
    private void standing(int x, int y){
        setImage(skinEnemieStanding.get((int)direction));
    }
    
    private void setWeapon(){        
        if(levelPower == 1){
            cadenceWeapon = 15;
        }
        else if(levelPower == 2){
            cadenceWeapon = 10;
        }
        else if(levelPower == 3){
            cadenceWeapon = 5;
        }
    }
    
    public void life(){
        Actor collided = getOneIntersectingObject(Weapon.class);
        if(collided != null){
            if(keyWeaponPlayer == 1){
                life -= hurtPlayer;
                getWorld().removeObject(collided);
            }
        } 
        if(life <= 0){
            getWorld().removeObject(this);
            Score.addScore(Enemie.getPoints());
            Hud.subtractAmountEnemies();
        }
    }
}
