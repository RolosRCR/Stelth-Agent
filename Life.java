import greenfoot.*;
public class Life extends Hud
{
    private static int life = 100;
    private static int objective = 100;
    private String text = "Life " + "(x" + String.valueOf(lives) + ") : ";
    private String level;
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
            Score.passScoreToNewLevel();
            setLife();
            level = getWorld().getClass().getName();
            if(level=="Nivel1"){ 
            Greenfoot.setWorld(new Nivel1());}
            else if(level=="Nivel2"){
                Greenfoot.setWorld(new Nivel2());}
            else{
                Greenfoot.setWorld(new Nivel3());}
            
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
