import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Player here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Player extends Actor
{
    private String name;
    private int score;
    public Player(String name, int score){
        this.name = name;
        this.score = score;
    }
    
    public int getScore(){
        return score;
    }
    
    public String getName(){
        return name;
    }
}
