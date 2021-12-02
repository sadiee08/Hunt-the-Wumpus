/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huntthewumpus;

import java.util.ArrayList;

/**
 * Tiene todos los atributos y métodos de los objetos de tipo Cavern.
 * @author abbys
 */
public class Cavern {
    private int id;
    protected int oxygen = -1;

    /**
     * Conexión entre cavernas aleatorias.
     */
    public ArrayList<Cavern> conectionCaverns = new ArrayList<>();
    
    public Cavern() {
    }

    public Cavern(int id) {
        this.id = id;
    }
    
    public Cavern(int id, int oxygen) {
        this.id = id;
        this.oxygen = oxygen;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getOxygen() {
        return oxygen;
    }

    public void setOxygen(int oxygen) {
        this.oxygen = oxygen;
    }

    public ArrayList<Cavern> getConectionCaverns() {
        return conectionCaverns;
    }

    public void setConectionCaverns(ArrayList<Cavern> conectionCaverns) {
        this.conectionCaverns = conectionCaverns;
    }
 
    /**
     * Lo que hace es que cuando se mueve a una caverna nueva,
     * disminuye su oxigeno.
     * @param p para poder hablarle al método que modifica el oxígeno.
     * @return 
     */
    public Cavern move (Player p){
        p.modiOxygen(this.oxygen);
        return this;
    }
    
    /**
     * Muestra el normbre de la caverna en la que estás.
     * @return El número y nombre de la caverna.
     */
    @Override
    public String toString() {
        return getId() + "Cavern";
    }  
    
    /**
     * Agrega el dato tipo Cavern al arraylist de conectionCaverns.
     * @param c
     */
    public void connectCavern(Cavern c){
        this.conectionCaverns.add(c);
    }
    
    /**
     * Checa si la caverna ya está dentro del arraylist que contiene 
     * las conexiones.
     * @param c Es el dato que se mandará a revisar si esta contenido 
     * ya en el arraylist.
     * @return Regresa true o false si es que ya esta contenido.
     */
    public boolean isAlreadyConnected(Cavern c){
        return this.conectionCaverns.contains(c);
    }

    /**
     * Muestra un mensaje de que caverna está a lado en donde estás.
     * @param p Se utiliza prinpipalmente en las clases a donde se 
     * extendio Cavern.
     * @return Retorna un String.
     */
    public String showHint(Player p){
        return "";
    }
}
