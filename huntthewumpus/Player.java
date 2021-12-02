/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huntthewumpus;

/**
 * Tiene todos los atributos y métodos de los objetos de tipo Player.
 * @author abbys
 */
public class Player {
    private int id;
    private int sumOxygen;
    private boolean youCatchWumpus = false;
    private boolean win = false;
    public Cavern inTheCavern;
    public boolean dead= false;

    public Player() {
    }

    public Player(int id, int sumOxygen, Cavern inTheCavern) {
        this.id = id;
        this.sumOxygen = sumOxygen;
        this.inTheCavern = inTheCavern;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSumOxygen() {
        return sumOxygen;
    }

    public void setSumOxygen(int sumOxygen) {
        this.sumOxygen = sumOxygen;
    }

    public boolean isYouCatchWumpus() {
        return youCatchWumpus;
    }

    public void setYouCatchWumpus(boolean youCatchWumpus) {
        this.youCatchWumpus = youCatchWumpus;
    }

    public boolean isWin() {
        return win;
    }

    public void setWin(boolean win) {
        this.win = win;
    }

    public Cavern getInTheCavern() {
        return inTheCavern;
    }

    public void setInTheCavern(Cavern inTheCavern) {
        this.inTheCavern = inTheCavern;
    }

    public boolean isDead() {
        return dead;
    }

    public void setDead(boolean dead) {
        this.dead = dead;
    }
    
    
    /**
     * Movimientos del jugador.
     * @param c Para poder acceder a los métodos de Cavern.
     * @param l Para poder acceder a los métods de Level.
     */
    public void movePlayer(Cavern c, Level l){
        if (c.getClass() == (new GiantBat()).getClass() || c.getClass() 
                == (new Witcher()).getClass()){
            space();
            Cavern result = c.move(this);
            if (result != null){
                this.movePlayer(result, l);
            } else{
                this.inTheCavern = c;
            }
            if ((c.getClass() == (new GiantBat()).getClass())){
                ((GiantBat)c).speach();
            }
        }else {
            space();
            c.move(this);
            this.inTheCavern = c;
            if(c.getClass() == (new Camp()).getClass()){
                ((Camp)c).increaseOxygen(l, this);
            } 
        }
        
    }
   
    /**
     * Modifica la cantidad de oxigeno del jugador si es que se mueve de lugar.
     * @param sumOxygen cantidad que pide para restarle a la cantidad inicial.
     */
    public void modiOxygen(int sumOxygen){
        this.sumOxygen += sumOxygen;
    }
    
    /**
     * Muestra en donde estás, enseña las posibles salidas de las cavernas y
     * el oxígeno actual.
     * @param p para poder mandarselo a lookAround.
     */
    public void lookUp(Player p){
        System.out.println("--------------------------");
        if (inTheCavern.getClass() == (new Camp()).getClass()){
            //space();
            System.out.print(ANSI_YELLOW + "----- CAMPAMENTO -----\n" 
                    + ANSI_RESET);
        }
        System.out.println("Entraste a la caverna: " 
                + this.inTheCavern.getId());
        System.out.println("Tienes " + this.sumOxygen + "% de oxigeno." );
        System.out.println("Wumpus capturado: " + ANSI_CYAN 
                + p.isYouCatchWumpus() + ANSI_RESET);
        System.out.println("Existen estás salidas: " 
                + this.inTheCavern.getConectionCaverns() + "\n");
        lookAround(p);
    }
    
    /**
     * Muestra mensajes de showHint si están a lado de una caverna que se 
     * especifican dentro del método.
     * @param p Se utliza para poder realizar otros métodos dentro de las
     * clases que especifican.
     */
    public void lookAround(Player p){
       for (Cavern c: this.inTheCavern.getConectionCaverns()){
           if (c.getClass() == (new Wumpus()).getClass()){
               System.out.println(c.showHint(p));
            } else if (c.getClass() == (new Water()).getClass()){
               System.out.println(c.showHint(p));
            }else if (c.getClass() == (new BottomlessPit()).getClass()){
               System.out.println(c.showHint(p));
            }
       }
   }
   
    /**
     * Muestra el mensaje final cuando ganas.
     */
    public void finishGame(){
        if (this.isWin() == true){
            System.out.println(ANSI_YELLOW + "\n\n¡Ganaste! Llegaste al"
                    + " campamento\n\n"
                    + " con Wumpus" + ANSI_RESET);
            System.out.println("------------------------------------");
        }
        if(this.getSumOxygen() <=0){
            System.out.println("\n\n...Perdiste, suerte para la otra...\n\n");
            System.out.println("------------------------------------");
        } 
    }
    
    /**
     * Para poder hacer los espacios y limpiar la pantalla.
     */
    public void space(){
        for (int i = 0; i < 24; i++) {
            System.out.println(""); 
        }
    }
    
    /**
     * Muestra la cantidad de oxigeno.
     * @return Número de oxígeno y si es que es estás en cero de oxígeno.
     */
    @Override
    public String toString() {
        return "Tienes " + sumOxygen + "% de oxigeno. ";
    }
    
    /**
     * Método para poder agregarle color a la consola.
     */
    public static final String ANSI_CYAN = "\u001B[36m";
    
    /**
     * Método para poder agregarle color a la consola.
     */
    public static final String ANSI_YELLOW = "\u001B[33m";
    
    /**
     * Método para poder agregarle color a la consola.
     */
    public static final String ANSI_RESET = "\u001B[0m"; 
    
    /**
     * Método para poder agregarle color a la consola.
     */
    public static final String ANSI_RED = "\u001B[31m";
}
