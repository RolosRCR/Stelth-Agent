import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TypeWeapon here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class TypeWeaponFactory extends Actor
{
    
    public static Weapon buildWeapon(String type, int direction){
        switch(type){
            case "Gun":
                return new Gun(direction);
            case "SemiAutomatic":
                return new SemiAutomatic(direction);
            case "MachineGun":
                return new MachineGun(direction);
            default:
                return null;
        }
    }
}
