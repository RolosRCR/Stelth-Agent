import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Boost here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Boost extends Collectible
{
    protected String improvementType;
    protected void Coallition(){
        if (isTouching(Agent.class)){
            Agent.typeWeapon=improvementType;
        } 
        super.Coallition();
    } 
}
