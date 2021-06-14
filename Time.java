import greenfoot.*;

public class Time extends Hud
{
    private int timmer = 2*60*55;
    private String text;
    
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
            Score.score();
            Life.setLife();
            Greenfoot.setWorld(new Nivel1());
    }
}
