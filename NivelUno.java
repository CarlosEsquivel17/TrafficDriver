import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Nivel_1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */

public class NivelUno extends World
{
    private GreenfootSound sound = new GreenfootSound("Nivel1.mp3");
    private personaje pj = new personaje();
    private int numObs;//Número de obstaculos
    public static int vid = 3;
    /**
     * Constructor for objects of class Nivel_1.
     * 
     */
    public NivelUno()
    {
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(840, 650, 1);
        //vid = 3;
        addObject(pj,238,535);
        agregaObs();
    }
    
    public void prepare(){
        addObject(pj,238,535);
        agregaObs();
    }
    public void act(){
       sound.setVolume(40);
       if(vid >0) sound.playLoop(); 
       showText("Vidas: " + vid, 100, 70);
       restart();
    }
    
    public void restart(){
        if(vid == 0){
           over ov = new over();
           sound.stop();
           addObject(ov,420,300);
           Greenfoot.delay(120);
           //Greenfoot.stop();
           Greenfoot.setWorld(new NivelUno());
           vid = 3;
       }
    }
    
    public int getRandomNum(int start, int end){
        int normal = Greenfoot.getRandomNumber(end - start + 1);
        return normal + start;
    }
    
    public void agregaObs(){
        int carril = getRandomNum(1,5);
        int n = carril;
            
        if(carril == 1){
            addObject(new patrulla(),238,80);
        }else if(carril == 2){
            addObject(new patrulla(),360,80);
        }else if(carril == 3){
            addObject(new patrulla(),485,80);
        }else if(carril == 4){
            addObject(new patrulla(),617,80);
        }
                
        carril += 1;
                
        if(carril == 1){
            addObject(new patrulla(),238,80);
        }else if(carril == 2){
            addObject(new patrulla(),360,80);
        }else if(carril == 3){
            addObject(new patrulla(),485,80);
        }else if(carril == 4){
            addObject(new patrulla(),617,80);
        }
    }
    
    public void quitaObs(){
        numObs -= 1;
    }
    
    public void restaVid(){
        vid -= 1;
    }
    
    public void setNumObs(int num){
        this.numObs = num;
    }
    
    public int getNumObs(){
        return this.numObs;
    }
}
