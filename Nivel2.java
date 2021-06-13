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
    /**
     * Constructor for objects of class Nivel2.
     * 
     */
    public Nivel2()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        buildMap();
        addObject(new Agent(), 20, 20);
    }

    private void buildMap()
    {
        buildPlatforms();
    }

    private void buildPlatforms(){
        for(int x=0;x<(screenWidth/Platform.getWidth())+1;x++){
            addObject(new PlatformSteel(), x*Platform.getWidth(),screenWidth-Platform.getHigh());
            addObject(new PlatformSteel(), x*Platform.getWidth(),150);
            addObject(new PlatformSteel(), x*Platform.getWidth(),275);
            if(x<6)
                addObject(new PlatformSteel(), x*Platform.getWidth(),60);
        }
    }
}
