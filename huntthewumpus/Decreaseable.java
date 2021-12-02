/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huntthewumpus;

/**
 * Para implementarlos en las clases que decrementan oxígeno del jugador.
 * @author abbys
 */
public interface Decreaseable {
    
    /**
     * Método que decrementa oxígeno.
     * @param p para poder utilizar los métodos de Player.
     */
    public void decreaseOxygen(Player p);
    
}
