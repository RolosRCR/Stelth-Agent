import greenfoot.*;  
import java.util.*;

public class EnemieTypeOne extends Enemie
{
    private int counterRight;
    private int counterLeft;
    private int counterGun=0;
    private int levelPower;
    private int life=30;
    private double direction;
    private String typeWeapon;
    private int cadenceWeapon;
    private static final int SPEED = 2;
        
    private ArrayList<String> skinEnemieRight = new ArrayList();
    private ArrayList<String> skinEnemieLeft = new ArrayList();
    private ArrayList<String> skinEnemieStanding = new ArrayList();
    
    public EnemieTypeOne(int levelPower){
        this.levelPower = levelPower;
        buildSkins();
        setWeapon();
        setImage("images/enemigo1_derecha_A.png");  
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
                if(x > 590)
                    direction=LEFT;
            }   
            else if((int)direction==LEFT){
                moveLeft(x, y);
                if(x<10)
                    direction = RIGHT;
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
                if(counterGun % cadenceWeapon ==0)
                    getWorld().addObject(TypeWeaponFactory.buildWeapon(typeWeapon, RIGHT, KEYWEAPONENEMIE), x + 15, y);
            }
            else{
                standing(LEFT); 
                if(counterGun % cadenceWeapon ==0)
                    getWorld().addObject(TypeWeaponFactory.buildWeapon(typeWeapon, LEFT, KEYWEAPONENEMIE), x - 15, y);
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
        life();
    }
    
    private void buildSkins(){
        int typeMovements=3;
        for(int i=0; i<typeMovements; i++){
            if(i == RIGHT){
                skinEnemieRight.add("images/enemigo1_derecha_B.png");
                skinEnemieRight.add("images/enemigo1_derecha_C.png");
                skinEnemieRight.add("images/enemigo1_derecha_D.png");
                skinEnemieRight.add("images/enemigo1_derecha_E.png");
                skinEnemieRight.add("images/enemigo1_derecha_F.png");
                skinEnemieRight.add("images/enemigo1_derecha_G.png");
            }
            else if(i == LEFT){
                skinEnemieLeft.add("images/enemigo1_izquierda_B.png");
                skinEnemieLeft.add("images/enemigo1_izquierda_C.png");
                skinEnemieLeft.add("images/enemigo1_izquierda_D.png");
                skinEnemieLeft.add("images/enemigo1_izquierda_E.png");
                skinEnemieLeft.add("images/enemigo1_izquierda_F.png");
                skinEnemieLeft.add("images/enemigo1_izquierda_G.png");
            }
            else if(i == STAND){
                skinEnemieStanding.add("images/enemigo1_derecha_A.png");
                skinEnemieStanding.add("images/enemigo1_izquierda_A.png");       
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
            cadenceWeapon = 20;
        }
        else if(levelPower == 2){
            typeWeapon = "SemiAutomatic";
            cadenceWeapon = 15;
        }
        else if(levelPower == 3){
            typeWeapon = "MachineGun"; 
            cadenceWeapon = 10;
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