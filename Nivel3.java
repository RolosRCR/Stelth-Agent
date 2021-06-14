import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

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
    /**
     * Constructor for objects of class Nivel3.
     * 
     */
    public Nivel3()
    {    

        super(600, 400, 1); 
        buildMap();
        addEnemmies();
        addObject(player, 510, 50);
    }

    public void act(){
        positionPlayer();  
    }

    private void buildMap(){
        buildPlatformsSteel();
        buildStairs();
        buildBoxes();
        buildPlatformBoxes();
        buildCollectibles();
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
        addObject(new Plane(1),100,50);
    }
}
