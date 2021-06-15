import greenfoot.*;
import javax.swing.*;

public class Nivel1 extends World
{

    int screenWidth=600;
    int screenHigh=400;
    private Agent player=new Agent();
    private static final int ENEMIESLEVELPOWER=1;
    private int amountEnemies=4;
    private static final int LEVEL=1;
    public static GreenfootSound musicLevel1=new GreenfootSound("Level1Music.mp3");
    private PlatformNextLevel meta = new PlatformNextLevel();

    public Nivel1()
    {   
        
        super(600, 400, 1);
        buildMap();
        buildHUD();
        addEnemmies();
        Hud.setAmountEnemies(amountEnemies);
        addObject(player, 475, 44);
    }

    public void act(){
        positionPlayer(); 
        playMusic();
        compareLives();
        
    }

    private void buildMap()
    {

        buildPlatformsSteel();
        buildBoxes();
        buildPlatformBoxes();
        buildCollectibles();
        buildGoal();

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
        int y=210;
        for(int x=0;x<(screenWidth/Platform.getWidth())+1;x++){

            if(x> 21&&x<24)
                addObject(new PlatformSteel(), x*Platform.getWidth(),65);

            if(x<4||x>9)
                addObject(new PlatformSteel(), x*Platform.getWidth(),200);
            if(x>4)
                addObject(new PlatformSteel(), x*Platform.getWidth(),335);

        }

    }

    private void buildBoxes(){
        addObject(new Box(), 350, 175);
        addObject(new Box(), 350, 310);
    }

    private void buildPlatformBoxes(){
        addObject(new PlatformBox(), 350, 155);
        addObject(new PlatformBox(), 350, 290);

    }

    private void buildGoal(){
        addObject(meta, 35,365);
        addObject(new Arrow(), 50,335);
    }

    private void buildCollectibles(){
        addObject(new USBBonus(), 510,110);
        addObject(new USBBonus(), 135,245);
        addObject(new USBBonus(), 350,270);
        addObject(new USBBonus(), 560,310);
    }

    public void positionPlayer(){
        Enemie.setPositionPlayer(player.getPositionX(), player.getPositionY());
    }

    private void addEnemmies(){
        addObject(new EnemieTypeOne(ENEMIESLEVELPOWER),550,183);
        addObject(new EnemieTypeOne(ENEMIESLEVELPOWER),50,183);
        addObject(new EnemieTypeOne(ENEMIESLEVELPOWER),500,317);
    }

    private void compareLives(){
        if(Hud.getLives() <= 0 ){
            musicLevel1.stop();
            String name = JOptionPane.showInputDialog("Introduce Nombre");            
            Greenfoot.setWorld(new GameOverScreen());
            ScoreScreen.addScore(name + " : ", Hud.getTotalScore());
        }
    }

    private void playMusic(){
        if(!musicLevel1.isPlaying())
        {   
            musicLevel1.setVolume(20);
            musicLevel1.play();
        }
        if(meta.isTouchedByAgent()){
            musicLevel1.stop();
        }
    }
}
