import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Nivel1 extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public Nivel1()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(600, 400, 1); 
        buildMap();
        addObject(new Agent(), 250, 376);
        
    }
    
    public void buildMap(){
        int x=10;
        for(int i=0; i<29; i++){
            this.addObject(new PlatformSteel(), x, 395);
            if(i<28){
                this.addObject(new PlatformSteel(), x+21, 335);
            }    
            if(i==0){
               this.addObject(new PlatformStone(), x, 335); 
            }
            x=x+21;
        }
        
        this.addObject(new Stairs(), 10, 360);
    }    
}
