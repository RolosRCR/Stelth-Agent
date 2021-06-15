import greenfoot.*;  
import javax.swing.*;
/**
 * Write a description of class Nivel3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Nivel3 extends World
{
    int screenWidth=600;
    int screenHigh=400;
    private Agent player=new Agent();
    private static final int LEVEL=3;
    private Plane finalBoss = new Plane(1);
    public static GreenfootSound musicLevel3=new GreenfootSound("Level3Music.mp3");
    public Nivel3()
    {    

        super(600, 400, 1); 
        buildMap();
        buildHUD();
        addEnemmies();
        addObject(player, 510, 50);
    }

    public void act(){
        positionPlayer();
        compareLives();
        playMusic();    
    }

    private void buildMap(){
        buildPlatformsSteel();
        buildStairs();
        buildBoxes();
        buildPlatformBoxes();
        buildCollectibles();
    }
    private void buildHUD(){
        Level.setLevel(LEVEL);
        addObject(new Level(), 78, 20);
        addObject(new Time(), 93, 40);
        addObject(new Life(), 250, 20);
        addObject(new Score(), 210, 40);
        Life.setHudLife();
    }

    private void buildPlatformsSteel(){
        for(int x=0;x<(screenWidth/Platform.getWidth())+1;x++){
            if(x>1  && x<6)
                addObject(new PlatformSteel(), x*Platform.getWidth(),300);
            if(x>7  && x<12)
                addObject(new PlatformSteel(), x*Platform.getWidth()+Platform.getWidth(),300);
            if(x>14  && x<19)
                addObject(new PlatformSteel(), x*Platform.getWidth()+Platform.getWidth(),300);
            addObject(new PlatformSteel(), x*Platform.getWidth(),590);
        }
    }

    private void buildBoxes(){
        addObject(new Box(), 520,375);
    }

    private void buildStairs(){
        addObject(new Stairs(3), 15,355);
    }

    private void buildPlatformBoxes(){
        addObject(new PlatformBox(), 520,355);
    }

    private void buildCollectibles(){
        addObject(new USBBonus(), 568,370);
        addObject(new BulletsBoost(), 15,290);
    }

    public void positionPlayer(){
        Enemie.setPositionPlayer(player.getPositionX(), player.getPositionY());
    }

    private void addEnemmies(){
        addObject(new EnemieTypeThree(1),370,378);
        addObject(finalBoss,100,50);
    }
    private void compareLives(){
        if(Hud.getLives() <= 0){
            musicLevel3.stop();
            String name = JOptionPane.showInputDialog("Introduce Nombre");
            Greenfoot.setWorld(new GameOverScreen());
            ScoreScreen.addScore(name + " : ", Hud.getTotalScore());
        }
        else if(finalBoss.getlife()<=0){
            musicLevel3.stop();
            String name = JOptionPane.showInputDialog("Introduce Nombre");           
            Greenfoot.setWorld(new WinScreen());
            ScoreScreen.addScore(name + " : ", Hud.getTotalScore());
        }
    }
    private void playMusic(){
        if(!musicLevel3.isPlaying())
        {   
            musicLevel3.setVolume(20);
            musicLevel3.play();
        }
    }
}
