import greenfoot.*;
public class Life extends Hud
{
    private static int life = 100;
    private static int objective = 100;
    private String text = "Life " + "(x" + String.valueOf(lives) + ") : ";
    
    public Life(){
        buildSign(text, life);
    }   
    public void act() {
        if(life > objective) {
            life--;
            updateImage(text, life);
        }
        lives();
    }
    
    public static void subtract(int hurt){
        objective -= hurt;
    }
    
    public void lives(){
        if(life <= 0){
            lives--; 
            Score.score();
            setLife();
            Greenfoot.setWorld(new Nivel1());
        }
    }
    
    public static void setHudLife(){
        life = 100;
        objective = 100;
    }
   
    public static void setLife(){
         life=100;
         objective=100;
    }
}
