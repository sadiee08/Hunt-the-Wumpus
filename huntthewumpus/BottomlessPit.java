/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huntthewumpus;

/**
 * Tiene todos los atributos y métodos de los objetos de tipo BottomlessPit.
 * @author abbys
 */
public class BottomlessPit extends Cavern {

    public BottomlessPit() {
    }

    public BottomlessPit(int id) {
        super(id);
    }
    
    /**
     * Método que te dice que llegaste a la caverna de pozo sin fondo, 
     * te reduce el oxígeno hasta 0.
     * @param p 
     */
    @Override
    public Cavern move(Player p){
        System.out.println("\n\n---" + ANSI_RED + " Has caido en un pozo "
                + "sin fin " + ANSI_RESET + "---");
        p.setSumOxygen(this.oxygen = 0);
        return this;
    }
    
    /**
     * Te alertará si estás en una cavaerna adyacente a una caverna con 
     * un pozo sin fondo.
     * @param p no se utiliza aquí. Pero en otros métodos si.
     * @return Un String con la advertencia.
     */
    @Override
    public String showHint(Player p){
        return ANSI_RED + "...Hay un pozo sin fondo cerca, ten cuidado en donde"
                + " pisas..." +  ANSI_RESET + "\n";
    }
    
    /**
     * Muestra el normbre de la caverna en la que estás.
     * @return El número y nombre de la caverna.
     */
    @Override
    public String toString() {
        return getId() + "BottomlessPit";
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
