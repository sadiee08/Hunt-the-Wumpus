/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huntthewumpus;

/**
 * Tiene todos los atributos y métodos de los objetos de tipo Water.
 * @author abbys
 */
public class Water extends Cavern implements Decreaseable{

    public Water() {
        this.oxygen = -3;
    }

    public Water(int id) {
        super(id, -3);
    }
    
    /**
     * Esto es lo que hace cuando caes en una caverna de agua.
     * @param p Para poder mandarselo a decreaseOxygen.
     * @return Regresa el método.
     */
    @Override
    public Cavern move(Player p){
        System.out.println(ANSI_BLUE + "Has entrado a una caverna con agua");
        System.out.println("Se reduce 3% de tu oxigeno " + ANSI_RESET);
        decreaseOxygen(p);
        return this;
    }
    
    /**
     * Te alertará si estás en una cavaerna adyacente a una caverna de agua.
     * @param p 
     * @return Regresa un String.
     */
    @Override
    public String showHint(Player p){
        String result = ANSI_BLUE + "...Se escuchan gotas cayendo..." 
                + "\n" + ANSI_RESET;
        return result;
    }

    /**
     * Te disminuye el oxigeno.
     * @param p Para poder acceder al método de modificar el oxígeno.
     */
    @Override
    public void decreaseOxygen(Player p){
        p.modiOxygen(this.oxygen = -3);
    }
    
    /**
     * Muestra el normbre de la caverna en la que estás.
     * @return El número y nombre de la caverna.
     */
    @Override
    public String toString() {
        return getId() + "Water";
    }
    
    /**
     * Método para poder agregarle color a la consola.
     */
    public static final String ANSI_BLUE = "\u001B[34m";
    
    /**
     * Método para poder agregarle color a la consola.
     */
    public static final String ANSI_RESET = "\u001B[0m";
}
