import greenfoot.*;

public class Nivel1 extends World
{
    private int limitPlatformWidth;
    private int limitPlatformHigh;
    private int sizePlatformHigh;
    private int sizePlatformWidth;
    private static final int LEVELPOWER=1;
    private int amountEnemies=4;
    private int highStairs;
    private int highAgent;
    private int directionAgent; 
    private static final int LEVEL=1;
    private Agent player = new Agent();

    public Nivel1()
    {    
        super(600, 400, 1); 
        Level.setLevel(LEVEL);
        buildMap();
        addObject(new Level(), 205, 10);
        addObject(new Time(), 505, 90);
        addObject(new Life(), 205, 90);
        addObject(new Score(), 205, 50);
        addObject(player, 50, 380);
        addObject(new EnemieTypeOne(LEVELPOWER), 250, 292);
        addObject(new EnemieTypeOne(LEVELPOWER), 250, 382);
        addObject(new EnemieTypeTwo(), 250, 380);
        addObject(new EnemieTypeThree(LEVELPOWER), 250, 290);
        addObject(new Plane(LEVELPOWER), 250, 90); 
        Life.setHudLife();
        Hud.setAmountEnemies(amountEnemies);

    }
    
    public void act(){
        positionPlayer();
        compareEnemies();
        compareLives();
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
    
    public void positionPlayer(){
        Enemie.setPositionPlayer(player.getPositionX(), player.getPositionY());
    }  
    
    public static void compareEnemies(){
        if(Hud.getAmountEnemies() == 0){
            Score.score();
            Hud.updateScore();   
            //Greenfoot.setWorld(new Nivel2());
        } 
    }
    
    public static void compareLives(){
        if(Hud.getLives() <= 0){           
            Greenfoot.setWorld(new MenuScreen());
            ScoreScreen.addScore("Jorge: ", Hud.getTotalScore()); 
        }
    }
}
