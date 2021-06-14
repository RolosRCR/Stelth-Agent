import greenfoot.*;  
import java.util.*;

public class EnemieTypeThree extends Enemie
{    
    private int counterRight;
    private int counterLeft;
    private int counterGun=0;
    private double direction;
    private String typeWeapon;
    private int cadenceWeapon;
    private int levelPower;
    private static final int SPEED = 1;
    
    private ArrayList<String> skinEnemieRight = new ArrayList();
    private ArrayList<String> skinEnemieLeft = new ArrayList();
    private ArrayList<String> skinEnemieStanding = new ArrayList();
    
    public EnemieTypeThree(int levelPower){ 
        this.levelPower = levelPower;
        buildSkins();
        setWeapon();
        setImage("images/soldado-minigun-derecha_G.png");  
        direction=Math.random()*2+1;
    }    
    
    public void act() 
    {
        handleDirection();
    }    
    
    private void handleDirection(){
        int x = getX();
        int y = getY();
        //counterGun++;
        if(isTouching(Platform.class) && direction != STAND){
            if((int)direction==RIGHT){
                moveRight(x, y);
                if(x > 590||isTouching(Box.class))
                    direction=LEFT;
                if(!isTouching(Platform.class)){
                    direction=LEFT;
                    setLocation(x-20,y);
                }
            }   
            else if((int)direction==LEFT){
                moveLeft(x, y);
                if(x<10||isTouching(Box.class)||!isTouching(Platform.class))
                    direction=RIGHT;
                if(!isTouching(Platform.class)){
                    direction=RIGHT;
                    setLocation(x+20,y);}

            }
            
            if(getPositionYPlayer() > y){
                if(getPositionYPlayer() - y < 10)
                    direction = STAND;
            }
            else if(getPositionYPlayer() < y){
                if(y - getPositionYPlayer() < 10)
                    direction = STAND;
            }
        }
        else if(direction == STAND){
            counterGun++;
            if(getPositionXPlayer() > getX()){
                standing(RIGHT);
                if(counterGun % cadenceWeapon == 0)
                    getWorld().addObject(TypeWeaponFactory.buildWeapon(typeWeapon, RIGHT, KEYWEAPON), x + 30, y + 7);
            }
            else{
                standing(LEFT);
                if(counterGun % cadenceWeapon == 0)
                    getWorld().addObject(TypeWeaponFactory.buildWeapon(typeWeapon, LEFT, KEYWEAPON), x - 30, y + 7);
            }
            
            if(getPositionYPlayer() > y){
                if(getPositionYPlayer() - y > 10){
                    direction =Math.random()*2+1;
                    counterGun=0;
                }
            }
            else if(getPositionYPlayer() < y){
                if(y - getPositionYPlayer() > 10){
                    direction = Math.random()*2+1;
                    counterGun=0;
                }
            }
        }
    }
    
    private void buildSkins(){
        int typeMovements=3;
        for(int i=0; i<typeMovements; i++){
            if(i == RIGHT){
                skinEnemieRight.add("images/soldado-minigun-derecha_A.png");
                skinEnemieRight.add("images/soldado-minigun-derecha_B.png");
                skinEnemieRight.add("images/soldado-minigun-derecha_C.png");
                skinEnemieRight.add("images/soldado-minigun-derecha_D.png");
                skinEnemieRight.add("images/soldado-minigun-derecha_E.png");
                skinEnemieRight.add("images/soldado-minigun-derecha_F.png");
            }
            else if(i == LEFT){
                skinEnemieLeft.add("images/soldado-minigun-izquierda_A.png");
                skinEnemieLeft.add("images/soldado-minigun-izquierda_B.png");
                skinEnemieLeft.add("images/soldado-minigun-izquierda_C.png");
                skinEnemieLeft.add("images/soldado-minigun-izquierda_D.png");
                skinEnemieLeft.add("images/soldado-minigun-izquierda_E.png");
                skinEnemieLeft.add("images/soldado-minigun-izquierda_F.png");
            }
            else if(i == STAND){
                skinEnemieStanding.add("images/soldado-minigun-derecha_G.png");
                skinEnemieStanding.add("images/soldado-minigun-izquierda_G.png");     
            }
        } 
    }
    
    private void moveLeft(int x, int y){
        direction=LEFT;
        setLocation(x-SPEED, y);
        counterLeft++;
        counterRight=0;
        if(counterLeft < (skinEnemieLeft.size())*TIMESKIN){
            if(counterLeft % TIMESKIN == 0)
                setImage(skinEnemieLeft.get(counterLeft/TIMESKIN));
        }
        else
            counterLeft=0;
    }
    
    private void moveRight(int x, int y){
        direction=RIGHT;
        setLocation(x+SPEED, y);
        counterLeft=0;
        counterRight++;
        if(counterRight < (skinEnemieRight.size())*TIMESKIN){
            if(counterRight % TIMESKIN == 0)
                setImage(skinEnemieRight.get(counterRight/TIMESKIN));
        }
        else
            counterRight=0;
    }
    
    private void standing(int position){
        setImage(skinEnemieStanding.get(position-1));
    } 
    
    private void setWeapon(){       
        if(levelPower == 1){
            typeWeapon= "Gun";
            cadenceWeapon = 10;
        }
        else if(levelPower == 2){
            typeWeapon = "SemiAutomatic";
            cadenceWeapon = 6;
        }
        else if(levelPower == 3){
            typeWeapon = "MachineGun"; 
            cadenceWeapon = 2;
        }
    }
}
