import greenfoot.*;
import javax.swing.*;  

public class Nivel2 extends World
{
    int screenWidth=600;
    int screenHigh=400;
    private Agent player=new Agent();
    private static final int LEVEL=2;
    public static GreenfootSound musicLevel2=new GreenfootSound("Level2Music.mp3");
    private PlatformNextLevel meta = new PlatformNextLevel();

    public Nivel2()
    {    
        super(600, 400, 1); 
        buildMap();
        buildHUD();
        addEnemmies();
        addObject(player, 50, 50);
        
    }

    public void act(){
        positionPlayer();
        
        playMusic();
        compareLives();
    }

    private void buildMap()
    {
        buildPlatformsSteel();
        buildPlatformsStone();
        buildStairs();
        buildBoxes();
        buildPlatformBoxes();
        buildGoal();
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
            if(x!= 19)
                addObject(new PlatformSteel(), x*Platform.getWidth(),150);
            if(x!= 4&&x!= 5)
                addObject(new PlatformSteel(), x*Platform.getWidth(),270);
            addObject(new PlatformSteel(), x*Platform.getWidth(),590);
            if(x<5)
                addObject(new PlatformSteel(),x*Platform.getWidth(),100);
        }
        addObject(new PlatformSteel(),560,110);
    }

    private void buildPlatformsStone(){
        addObject(new PlatformStone(), 400,150);
    }

    private void buildStairs(){
        addObject(new Stairs(3), 560,55);
        addObject(new Stairs(3), 400,180);
        addObject(new Stairs(3), 400,220);

    }

    private void buildBoxes(){
        addObject(new Box(), 240, 125);
        addObject(new Box(), 330, 90);

        addObject(new Box(), 430, 125);
        addObject(new Box(), 430, 125-Box.getHigh());
        addObject(new Box(), 430+Box.getWidth(), 125);

    }

    private void buildPlatformBoxes(){
        addObject(new PlatformBox(),239,105);
        addObject(new PlatformBox(),329,70);
        addObject(new PlatformBox(), 430, 105-Box.getHigh());
        addObject(new PlatformBox(), 430+Box.getWidth(), 105);
        addObject(new PlatformBox(), 560, 105);
        addObject(new PlatformBox(), 250, 245);
        addObject(new PlatformBox(), 95, 375);
    }

    private void buildGoal(){
        addObject(meta, 560,400);
        addObject(new Arrow(), 553,373);
    }

    private void buildCollectibles(){
        addObject(new USBBonus(), 560,10);
        addObject(new USBBonus(), 560,245);
        addObject(new USBBonus(), 35,245);
        addObject(new USBBonus(), 300,370);
        addObject(new CadenceBoost(), 250,200);
    }

    public void positionPlayer(){
        Enemie.setPositionPlayer(player.getPositionX(), player.getPositionY());

    }

    private void addEnemmies(){
        addObject(new EnemieTypeThree(1),50,131);
        addObject(new EnemieTypeOne(2),300,131);
        addObject(new EnemieTypeOne(2),200,251);
        addObject(new EnemieTypeThree(2),450,378);
    }
    private void compareLives(){
        if(Hud.getLives() <= 0){
            musicLevel2.stop();
            String name = JOptionPane.showInputDialog("Introduce Nombre");
            Greenfoot.setWorld(new GameOverScreen());
            ScoreScreen.addScore(name + " : ", Hud.getTotalScore());
        }
    }
    private void playMusic(){
        if(!musicLevel2.isPlaying())
        {   
            musicLevel2.setVolume(20);
            musicLevel2.play();
        }
        if(meta.isTouchedByAgent()){
            musicLevel2.stop();
        }
    }
}

