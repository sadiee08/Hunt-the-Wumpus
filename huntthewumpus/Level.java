/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huntthewumpus;

/**
 * Tiene todos los atributos y métodos de los objetos de tipo Level.
 * @author abbys
 */
public class Level {
    private int id;
    private String nameLevel;
    private int numBottomlessPit;
    private int numGiantBat;
    private int numWater;
    private int numOxygenTank;
    private int numCaverns;
    private int numOxygen;
    private int numWitcher;
    private int numCamp;
    private int numWumpus;
   
    public static int numLevel =0;

    public Level() {
        numLevel++;
        id=numLevel;
    }

    public Level(String nameLevel, int numBottomlessPit, 
            int numGiantBat, int numWater, int numOxygenTank, 
            int numCaverns, int numOxygen, int numWitcher, int numCamp, int numWumpus) {
        this();
        this.nameLevel = nameLevel;
        this.numBottomlessPit = numBottomlessPit;
        this.numGiantBat = numGiantBat;
        this.numWater = numWater;
        this.numOxygenTank = numOxygenTank;
        this.numCaverns = numCaverns;
        this.numOxygen = numOxygen;
        this.numWitcher = numWitcher;
        this.numCamp = numCamp;
        this.numWumpus = numWumpus;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameLevel() {
        return nameLevel;
    }

    public void setNameLevel(String nameLevel) {
        this.nameLevel = nameLevel;
    }

    public int getNumBottomlessPit() {
        return numBottomlessPit;
    }

    public void setNumBottomlessPit(int numBottomlessPit) {
        this.numBottomlessPit = numBottomlessPit;
    }

    public int getNumGiantBat() {
        return numGiantBat;
    }

    public void setNumGiantBat(int numGiantBat) {
        this.numGiantBat = numGiantBat;
    }

    public int getNumWater() {
        return numWater;
    }

    public void setNumWater(int numWater) {
        this.numWater = numWater;
    }

    public int getNumOxygenTank() {
        return numOxygenTank;
    }

    public void setNumOxygenTank(int numOxygenTank) {
        this.numOxygenTank = numOxygenTank;
    }

    public int getNumCaverns() {
        return numCaverns;
    }

    public void setNumCaverns(int numCaverns) {
        this.numCaverns = numCaverns;
    }

    public int getNumOxygen() {
        return numOxygen;
    }

    public void setNumOxygen(int numOxygen) {
        this.numOxygen = numOxygen;
    }

    public int getNumWitcher() {
        return numWitcher;
    }

    public void setNumWitcher(int numWitcher) {
        this.numWitcher = numWitcher;
    }

    public int getNumCamp() {
        return numCamp;
    }

    public void setNumCamp(int numCamp) {
        this.numCamp = numCamp;
    }

    public int getNumWumpus() {
        return numWumpus;
    }

    public void setNumWumpus(int numWumpus) {
        this.numWumpus = numWumpus;
    }

    public static int getNumLevel() {
        return numLevel;
    }

    public static void setNumLevel(int numLevel) {
        Level.numLevel = numLevel;
    }

    /**
     * Método que muestra la cantidad de los tipos de caverna que tendrá
     * el nivel elegido.
     * @return String con la cantidades de las cavernas.
     */
    @Override
    public String toString() {
        return  id + ") " + nameLevel + " (oxigeno inicial: " + numOxygen + 
                ", pozos: " + numBottomlessPit + ", murcielago gigante: " 
                + numGiantBat + ", agua: " + numWater + ", tanques de oxigeno: " 
                + numOxygenTank + ", cavernas: " + numCaverns + ", brujos: " 
                + numWitcher + ", campamento: " + numCamp +")";
    }
    
}
