import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class personaje here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class personaje extends Actor
{
    /**
     * Act - do whatever the personaje wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private GreenfootSound music = new GreenfootSound("aceleracion.mp3");
    //public int vidas = 3;//Vidas del jugador
    private int vel = 0;
    private int x = 0;
    
    public void act()
    {
        // Add your action code here.
        if(Greenfoot.isKeyDown("w")){
            vel = 1;
            if(getY() > 30){     //setLocation(getX(), getY() - 2);
                music.playLoop();
            }
            
            /*if(Greenfoot.isKeyDown("s")){
                if(getY() < 620)    setLocation(getX(), getY() + 2);
            }*/
            
            if(Greenfoot.isKeyDown("a")){
                if(getX() > 142)    setLocation(getX() - 2, getY());
            }
            
            if(Greenfoot.isKeyDown("d")){
                if(getX() < 700)    setLocation(getX() + 2, getY());
            }
            verificaChoque();
        }else{ 
            verificaChoque();
        }
    }
    /*
    public void MusicStart(){
        if(Greenfoot.isKeyDown("w")){
            music.playLoop();
        }
    }
    */
   public void verificaChoque(){
       Actor coli = getOneIntersectingObject(patrulla.class);
       if(coli != null){
           getWorld().removeObject(coli);
           NivelUno wd = new NivelUno();
           //NivelUno.class.restaVid();
           wd.restaVid();
           wd.agregaObs();
           Greenfoot.playSound("choque.mp3");
       }
   }
   
   public int getVel(){
       return vel;
   }
}
