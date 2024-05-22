import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Menu extends World
{
Flecha flecha = new Flecha();
private int opc = 0;
private GreenfootSound intro = new GreenfootSound("intro.mp3");
 
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public Menu()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(840, 650, 1);
        prepare();
    }
    
    public void prepare(){
        Nombre nom = new Nombre();
        addObject(nom,249,80);
        Inicio incio = new Inicio();
        addObject(incio, 420, 250);
        Salir salir = new Salir();
        addObject(salir,420,450);
        addObject(flecha,200,250);
    }
    
    public void act(){
        intro.setVolume(40);
        intro.playLoop();
        if(Greenfoot.isKeyDown("w") && opc !=0){
           opc++;
        }
        if(Greenfoot.isKeyDown("s") && opc !=1){
           opc--;
        }
        if (opc >=2){
            opc = 0;
        }
        if (opc < 0){
            opc = 1;
        }
        flecha.setLocation(200,250 + (opc*200));
        
        if (Greenfoot.isKeyDown("ENTER")){
            switch(opc){
                case 0: //jugar
                    Greenfoot.setWorld(new NivelUno());
                    Greenfoot.playSound("motor.mp3");
                    intro.stop();
                    break;
                case 1: //salir
                    Greenfoot.stop();
                    Greenfoot.playSound("motor.mp3");
                    intro.stop();
                    break;
            }
        }
        
    }
    }

