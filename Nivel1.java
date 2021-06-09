import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Nivel1 extends World
{
    private int limitPlatformWidth;
    private int limitPlatformHigh;
    private int sizePlatformHigh;
    private int sizePlatformWidth;
    private int highStairs;
    private Agent personaje = new Agent();

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public Nivel1()
    {    
        super(600, 400, 1); 
        buildMap();
        addObject(personaje, 250, 380);
        addObject(new EnemieTypeOne(), 250, 380);
        addObject(new EnemieTypeTwo(), 250, 380);
    }
    
    public void buildMap(){
        int x=0;
        int y=400;
        sizePlatformHigh = 90;
        sizePlatformWidth = 21;
        limitPlatformWidth=600/sizePlatformWidth+1;
        limitPlatformHigh=400/sizePlatformHigh;
        highStairs=350;
        for(int i=0; i<limitPlatformWidth; i++){
            for(int j=0; j<limitPlatformHigh; j++){
                 if(i% 5 ==0 && y != 400){
                     this.addObject(new PlatformStone(), x, y);
                     this.addObject(new Stairs(), x, highStairs);
                 }
                 else{
                     this.addObject(new PlatformSteel(), x, y); 
                 }
                 y=y-sizePlatformHigh;
            }
            y=400;
            x=x+sizePlatformWidth;
        }
    }
    public int getAgentPosition(){
        return personaje.getPositionX();
    }
}
