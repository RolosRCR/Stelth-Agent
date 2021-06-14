import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Nivel2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Nivel2 extends World
{
    int screenWidth=600;
    int screenHigh=400;
    private Agent player=new Agent();
    /**
     * Constructor for objects of class Nivel2.
     * 
     */
    public Nivel2()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        buildMap();
        addEnemmies();
        addObject(player, 50, 0);
    }

    public void act(){
        positionPlayer();  
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

    private void buildPlatformsSteel(){
        for(int x=0;x<(screenWidth/Platform.getWidth())+1;x++){
            if(x!= 19)
                addObject(new PlatformSteel(), x*Platform.getWidth(),150);
            if(x!= 4&&x!= 5)
                addObject(new PlatformSteel(), x*Platform.getWidth(),270);
            addObject(new PlatformSteel(), x*Platform.getWidth(),590);
            if(x<5)
                addObject(new PlatformSteel(),x*Platform.getWidth(),60);
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
        addObject(new Box(), 560, 125);
        addObject(new Box(), 250, 245);
        addObject(new Box(), 95, 375);
    }

    private void buildPlatformBoxes(){
        addObject(new PlatformBox(),239,105);
        addObject(new PlatformBox(),329,70);

        addObject(new PlatformBox(), 430, 105-Box.getHigh());
        addObject(new PlatformBox(), 430+Box.getWidth(), 105);
        addObject(new PlatformBox(), 560, 105);
        addObject(new PlatformBox(), 250, 225);
        addObject(new PlatformBox(), 95, 355);
    }

    private void buildGoal(){
        addObject(new PlatformNextLevel(), 560,400);
        addObject(new Arrow(), 558,370);
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
        addObject(new EnemieTypeThree(3),450,378);
    }
}

