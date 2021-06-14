import greenfoot.*;
import java.util.*;

/**
 * Write a description of class ScoreScreen here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ScoreScreen extends World
{
    private static GreenfootSound music = new GreenfootSound("intro.mp3");
    private int x = 0;
    private int y = 0;
    
   public static ArrayList<Player> players = new ArrayList();
   private static Player player;
   public static int size;
   
   public void act(){
       
       if(!music.isPlaying())
       { 
           music.setVolume(10);
           music.play();
       }
    }
   public ScoreScreen()
   {            
        super(600, 400, 1); 
        addObject(new BackButton(),21,13);
        //addObject(new Records("Jorge", 5), 250, 50);
        for(int i=0; i<players.size(); i++){
           player = players.get(i);
           addObject(new Records(player.getName(), player.getScore()), 250, 50+(i*20));
        }
   }
   
   public static void addScore(String name, int score){ 
      players.add(new Player(name, score));
      Collections.sort(players, new Comparator<Player>() {
	@Override
	public int compare(Player p1, Player p2) {
		return new Integer(p2.getScore()).compareTo(new Integer(p1.getScore()));
	}
      });
      
      if(players.size() > 5){
          players.remove(5);    
      }
   }  
   
   public static void stopMusic(){
       music.stop();
   }
   
}
