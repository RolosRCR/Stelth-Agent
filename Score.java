import greenfoot.*;
public class Score extends Hud
{
    private static int score;
    private static int objective;
    private String text = "Score: ";
    
    public Score(){
        score = totalScore;
        objective = totalScore;
        buildSign(text, score);
    }   
    public void act() {
        if(score < objective) {
            score++;
            updateImage(text, score);
        }
    }
    
    public static void addScore(int points){
        objective += points;
    }
    
    public static void score(){
        totalScore = score;
    }
    
    public static void setHudScore(){
        score = 0;
        objective = 0;
    }
    
}
