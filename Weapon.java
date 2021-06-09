import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Weapon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Weapon extends Actor
{
    public int getPositionX(){
        return getX(); 
    }
    
    public int getPositionY(){
        return getY();
    }
    
    public void collision(){
        if(getX() > 590 || getX() < 10){
            getWorld().removeObject(this);
        }    
    } 
    
}
