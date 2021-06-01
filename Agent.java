import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Agent here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Agent extends Actor
{
    private int counterRight;
    private int counterLeft;
    private int counterUp;
    private int currentImage;
    private static final int speed = 2;
    private int direction;
    public Agent(){
        setImage("images/Personaje principal_derecha_A.png");   
    }    
    /**
     * Act - do whatever the Agent wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act() 
    {
        //moveBody();
        handleDirection();
        
    }    
    public void handleDirection(){

        int x = getX();
        int y = getY();
        
        if(isTouching(Platform.class)){
            if(direction !=4 || direction != 5){
                if(Greenfoot.isKeyDown("right"))
                    moveRigth(x, y); 
                else if(Greenfoot.isKeyDown("left")){
                    moveLeft(x, y);
                }
                else{
                    standing(x, y); 
                }
            }
        }
        if(isTouching(Stairs.class) && direction !=0){
            if(Greenfoot.isKeyDown("down") && !isTouching(PlatformSteel.class))
                moveDown(x, y);
            else if(Greenfoot.isKeyDown("up")){
                moveUp(x, y);
            }
        }
        else if(!isTouching(Stairs.class)){
            if(direction==5){
                setLocation(x, y + 5);
                direction=0;
            }
            else if(direction == 4){
                setLocation(x, y - 5);
                direction=0;
            }
        }
    }
    
    private void moveLeft(int x, int y){
        direction=3;
        setLocation(x - speed, y);
        counterLeft++;
        counterRight=0;
        if(counterLeft==19)
            counterLeft=1;
            
        if(counterLeft==1){
            setImage("images/Personaje principal_izquierda_B.png");
        }else if(counterLeft==4){
            setImage("images/Personaje principal_izquierda_C.png");
        }
        else if(counterLeft==7){
            setImage("images/Personaje principal_izquierda_D.png");
        }
        else if(counterLeft==10){
            setImage("images/Personaje principal_izquierda_E.png");
        }
        else if(counterLeft==13){
            setImage("images/Personaje principal_izquierda_F.png");
        }
        else if(counterLeft==16){
            setImage("images/Personaje principal_izquierda_G.png");
        }        
    }
    
    private void moveRigth(int x, int y){
        direction = 2;
        setLocation(x + speed, y);
        counterLeft=0;
        counterRight++;
        if(counterRight==19)
            counterRight=1;
                
        if(counterRight==1){
            setImage("images/Personaje principal_derecha_B.png");
        }else if(counterRight==4){
            setImage("images/Personaje principal_derecha_C.png");
        }
        else if(counterRight==7){
            setImage("images/Personaje principal_derecha_D.png");
        }
        else if(counterRight==10){
            setImage("images/Personaje principal_derecha_E.png");
        }
        else if(counterRight==13){
            setImage("images/Personaje principal_derecha_F.png");
        }
        else if(counterRight==16){
            setImage("images/Personaje principal_derecha_G.png");
        }  
    }
    
    public void moveDown(int x, int y){
        setLocation(x, y + speed);
        direction = 4;
        counterUp++;
        if(counterUp>3)
            counterUp=1;
            
        if(counterUp==1){
            setImage("images/Personaje principal_Arriba-Abajo-A.png");
        }
        else if(counterUp==2){
            setImage("images/Personaje principal_Arriba-Abajo-B.png");
        }
    }
    
    public void moveUp(int x, int y){
        setLocation(x, y - speed);
        direction = 5;
        counterUp++;
        if(counterUp>2)
            counterUp=1;
            
        if(counterUp==1){
            setImage("images/Personaje principal_Arriba-Abajo-A.png");
        }
        else if(counterUp==2){
            setImage("images/Personaje principal_Arriba-Abajo-B.png");
        }
    }
    
    public void standing(int x, int y){
        if(direction == 2)
            setImage("images/Personaje principal_derecha_A.png");
        else if(direction==3){
            setImage("images/Personaje principal_izquierda_A.png");
        }
        else if(direction==4){
            setImage("images/Personaje principal_Arriba-Abajo-A.png");
        }
        else if(direction==5){
             setImage("images/Personaje principal_Arriba-Abajo-B.png");
        }
    }
}
