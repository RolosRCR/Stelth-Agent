import greenfoot.*; 
import java.util.*;

/**
 * Write a description of class counter here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Hud extends Actor
{
    public static int lives=3;
    public static int totalScore;
    private int stringLength;
    private static int amountEnemies;
    private static int scoreEnemies;

    public void act() {
    }
    public void buildSign(String sign, int points){
        stringLength = (sign.length() + 2) * 16;
        setImage(new GreenfootImage(stringLength, 24));
        GreenfootImage image = getImage();
        Font font = image.getFont();
        image.setFont(font.deriveFont(24.0F));
        image.setColor(Color.BLACK);
        
        updateImage(sign, points);
    }

    public void updateImage(String sign, int score){
        GreenfootImage image = getImage();
        image.clear();
        image.drawString(sign + score, 1, 18);
    }
    
    public static void initializeHud(){
        lives = 3;
        totalScore = 0;
    }
    
    public static void setAmountEnemies(int amount){
        amountEnemies = amount;
        scoreEnemies = amount;
    }
    
    public static void subtractAmountEnemies(){
        amountEnemies--;
    }
    
    public static int getAmountEnemies(){
        return amountEnemies;
    }
    
    public static void updateScore(){
        totalScore += (scoreEnemies * Enemie.getPoints()) * (lives - 1);
    }
    
    public static int getLives(){
        return lives;
    }
    
    public static int getTotalScore(){
        return totalScore;
    }
    
}
