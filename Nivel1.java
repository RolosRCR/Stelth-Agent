import greenfoot.*;

public class Nivel1 extends World
{
    int screenWidth=600;
    int screenHigh=400;
    private Agent player=new Agent();
    public Nivel1()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        buildMap();
        addEnemmies();
        addObject(player, 475, 45);
    }

    private void buildMap()
    {
        buildPlatformsSteel();
        buildBoxes();
        buildPlatformBoxes();
        buildCollectibles();
        buildGoal();

    }

    public void act(){
        positionPlayer();  
    }

    private void buildPlatformsSteel(){
        int y=210;
        for(int x=0;x<(screenWidth/Platform.getWidth())+1;x++){

            if(x> 21&&x<24)
                addObject(new PlatformSteel(), x*Platform.getWidth(),65);

            if(x<4||x>9)
                addObject(new PlatformSteel(), x*Platform.getWidth(),200);
            if(x<1||x>4)
                addObject(new PlatformSteel(), x*Platform.getWidth(),335);

        }

    }

    private void buildBoxes(){
        addObject(new Box(), 350, 180);
        addObject(new Box(), 350, 315);
    }

    private void buildPlatformBoxes(){
        addObject(new PlatformBox(), 350, 160);
        addObject(new PlatformBox(), 350, 295);

    }

    private void buildGoal(){
        addObject(new PlatformNextLevel(), 35,365);
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
        addObject(new EnemieTypeOne(1),550,183);
        addObject(new EnemieTypeOne(1),50,183);
        addObject(new EnemieTypeOne(1),500,317);
    }
}
