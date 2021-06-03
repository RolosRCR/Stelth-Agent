import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.*;

/**
 * Write a description of class Botton here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Button extends Actor
{       
    private List<Observer> observers = new LinkedList();

    public void addObserver(Observer observer)
    {
        observers.add(observer);
    }

    protected Button (){}

    protected Button (Observer ... observers)
    {
        for(Observer observer: observers)
        {
            this.observers.add(observer);
        }
    }

    public void act() 
    {
        if (Greenfoot.mouseClicked(this))
        {
            for(Observer observer: observers)
            {
                observer.eventOcurred();
            }
        }
    }     
}
