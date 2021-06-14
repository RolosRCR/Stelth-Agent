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
    private int x = 0;
    private int y = 0;
    
   public static ArrayList<Player> players = new ArrayList();
   private static Player player;
   public static int size;
   
   public ScoreScreen()
   {            
        super(600, 400, 1); 
        addObject(new BackButton(),21,13);
        //addObject(new Records("Jorge", 5), 250, 50);
        for(int i=0; i<players.size(); i++){
           player = players.get(i);
           System.out.println(player.getName() + player.getScore());
           addObject(new Records(player.getName(), player.getScore()), 250, 50+(i*20));
        }
   }
   
   public static void addScore(String name, int score){ 
      players.add(new Player(name, score)); 
      /**if(players.size() == 0){
          players.add(new Player(name, score));    
      }
      else{
          for(int i=0; i<players.size(); i++){
              player = players.get(i);
              if(score > player.getScore()){
                  players.add(i, new Player(name, score)); 
                  players.add(player);
              }
              else{
                  players.add(new Player(name, score));
              }
          } 
      }*/
   }   
}
