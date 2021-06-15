import greenfoot.*;

public class Time extends Hud
{
    private int timmer = 1*60*55;
    private String text;
    private String level;
    public Time(){
        text = "Time: " + timmer/(60*55) + ": ";
        buildSign(text, timmer/55);
    }  
    
    public void act() {
        if(--timmer != 0) {
            text = "Time: " + timmer/(60*55) + ": ";
            updateImage(text, (timmer%(60*55))/55);
        }
        else{
            lives();
        }
    }
   
    
    private void lives(){
            lives--; 
            Score.passScoreToNewLevel();
            Life.setLife();
            level = getWorld().getClass().getName();
            if(level=="Nivel1")
            Greenfoot.setWorld(new Nivel1());
            else if(level=="Nivel2")
                Greenfoot.setWorld(new Nivel2());
            else
                Greenfoot.setWorld(new Nivel3());
    }
}
