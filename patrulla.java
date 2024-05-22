import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class patrulla here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class patrulla extends Actor
{
    //private int vel;
    
    public patrulla(){
    }
    /**
     * Act - do whatever the patrulla wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
        //setLocation(getX(),getY() + 1);
        if(Greenfoot.isKeyDown("w")){
            setLocation(getX(),getY() + 1);
            if(getY() >= getWorld().getHeight() -1){
                NivelUno pista = (NivelUno) getWorld();
                pista.removeObject(this);
                //pista.setNumObs(0);
                pista.agregaObs();
            }
        }else{
            setLocation(getX(),getY() - 1);
            if(getY() == 20){
                NivelUno pista = (NivelUno) getWorld();
                pista.removeObject(this);
                //pista.setNumObs(0);
                pista.agregaObs();
            }
        }
    }
}
