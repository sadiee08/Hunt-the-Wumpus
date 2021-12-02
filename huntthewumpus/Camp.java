/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huntthewumpus;

/**
 * Tiene todos los atributos y métodos de los objetos de tipo Camp.
 * @author abbys
 */
public class Camp extends Cavern{

    public Camp() {
    }

    public Camp(int id) {
        super(id);
    } 
    
    /**
     * Verifica si ya tienes a Wumpus para ver si ya acabaste el juego.
     * @param p para poder acceder a los métodos de Player.
     */
    @Override
    public Cavern move(Player p){
        if(p.isYouCatchWumpus() == true){
            p.setWin(true);
        }
        return this;
    }
    
    /**
     * Se resetea el oxígeno a como inició.
     * @param l Para sacar la cantidad de oxigeno incial.
     * @param p Para poder llamar el método para modificar el oxígeno.
     */
    public void increaseOxygen(Level l, Player p){
        int num = l.getNumOxygen();
        p.setSumOxygen(num);
    }
    
    /**
     * Muestra el normbre de la caverna en la que estás.
     * @return El número y nombre de la caverna.
     */
    @Override
    public String toString() {
        return getId() + "Camp";
    }
    
}