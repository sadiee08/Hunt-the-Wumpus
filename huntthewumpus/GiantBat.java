/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huntthewumpus;

import static huntthewumpus.HuntTheWumpus.connectedCaverns;

/**
 * Tiene todos los atributos y métodos de los objetos de tipo GiantBat.
 * @author abbys
 */
public class GiantBat extends Cavern{

    public GiantBat() {
    }

    public GiantBat(int id) {
        super(id);
    }

    /**
     * Muestra lo que sucede si entras a una caverna con un murciélago.
     * @param p Para poder acceder el método de modificar el oxígeno.
     */
    @Override
    public Cavern move(Player p){
        
        p.modiOxygen(this.oxygen);
        return moveTo();
    }
    
    /**
     * Mensaje si caes en una caverna de murciélago.
     */
    public void speach(){
        System.out.println(ANSI_RED + "¡Cuidado! Un murciélago te atrapo, "
            + "cuidado en donde te deje..." + "\n" + ANSI_RESET);
    }
    
    /**
     * Te mueve de caverna de manera random.
     * @return regresa número de la caverna a cambiar.
     */
    public Cavern moveTo(){
       int ran = (int) (Math.random() * connectedCaverns.size());
       return connectedCaverns.get(ran);
    }
    
    /**
     * Muestra el normbre de la caverna en la que estás.
     * @return El número y nombre de la caverna.
     */
    @Override
    public String toString() {
        return getId() + "Giant Bat";
    }
    
    /**
     * Método para poder agregarle color a la consola.
     */
    public static final String ANSI_RED = "\u001B[31m";
    
    /**
     * Método para poder agregarle color a la consola.
     */
    public static final String ANSI_RESET = "\u001B[0m";
}
