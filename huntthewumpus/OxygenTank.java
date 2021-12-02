/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huntthewumpus;

/**
 * Tiene todos los atributos y métodos de los objetos de tipo OxygenTank.
 * @author abbys
 */
public class OxygenTank extends Cavern {

    public OxygenTank() {
        this.oxygen = 15;
    }

    public OxygenTank(int id) {
        super(id);
    }

    /**
     * Te regenera 15 de oxigeno.
     * @param p para poder acceder al método de Player y modificar el oxígeno.
     */
    public void oxygenRisesToXV(Player p){
        for (int i = 0; i < 25; i++) {
            System.out.println("");            
        }
        System.out.println(ANSI_BLUE + "Encontraste un tanque de oxigeno" 
                + ANSI_RESET);
        System.out.println(ANSI_BLUE + "Tu oxigeno sube un 15%" 
                + ANSI_RESET);
        p.modiOxygen(this.oxygen = 15);
    }
    
    /**
     * Le manda hablar al método de oxygenRisesToXV, lo implementa cuando 
     * llega a una casilla de tanque de oxígeno.
     * @param p para poder mandarselo a oxygenRisesToXV.
     * @return el método.
     */
    @Override
    public Cavern move(Player p){
        oxygenRisesToXV(p);
        return this;
    }

    /**
     * Muestra el normbre de la caverna en la que estás.
     * @return El número y nombre de la caverna.
     */
    @Override
    public String toString() {
        return getId() + "OxygenTank";
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
