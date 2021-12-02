/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huntthewumpus;

/**
 * Tiene todos los atributos y métodos de los objetos de tipo Wumpus.
 * @author abbys
 */
public class Wumpus extends Cavern{

    public Wumpus() {
    }

    public Wumpus(int id) {
        super(id);
    }
    
    /**
     * Te alertará si estás en una cavaerna adyacente a la de wumpus.
     * @param p Para poder acceder a los métodos de Player.
     * @return 
     */
    public String scream(Player p){
        String isCloseWumpus = "";
        if (p.isYouCatchWumpus() == false){
            isCloseWumpus = ANSI_PURPLE + "...¡Huele a azufre! Wumpus está "
                    + "cerca...\n" + ANSI_RESET;
        }
        return isCloseWumpus;
    }

    /**
     * Muestra cuando atrapaste a Wumpus.
     * @param p Para poder acceder a isYouCatchWumpus de Player.
     */
    @Override
     public Cavern move(Player p){
        if (p.isYouCatchWumpus() == false){
            System.out.println(ANSI_YELLOW + "¡Encontraste a Wumpus!\n" 
                    + ANSI_RESET);
            p.setYouCatchWumpus(true);
        }
        return this;
    }
     
    /**
     * Muestra lo que esta en scream().
     * @param p Para mandarselo a scream.
     * @return
     */
    @Override
    public String showHint(Player p){
        return scream(p);
    }
    
    /**
     * Muestra el normbre de la caverna en la que estás.
     * @return El número y nombre de la caverna.
     */
    @Override
    public String toString() {
        return getId() + "Wumpus";
    }
    
    /**
     * Método para poder agregarle color a la consola.
     */
    public static final String ANSI_PURPLE = "\u001B[35m";
    
    /**
     * Método para poder agregarle color a la consola.
     */
    public static final String ANSI_YELLOW = "\u001B[33m";
    
    /**
     * Método para poder agregarle color a la consola.
     */
    public static final String ANSI_RESET = "\u001B[0m";
}
