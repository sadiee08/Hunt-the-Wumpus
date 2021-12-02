/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huntthewumpus;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * El environment del programa.
 * @author abbys
 */
public class HuntTheWumpus {
    
    /**
     * Creación de un jugador nuevo.
     */
    public static Player myPlayer = new Player();
    
    /**
     * Creación de los niveles.
     */
    public static Level[] myLevels = {
        new Level ("Facil", 1, 2, 1, 3, 20, 50, 1, 1, 1),
        new Level ("Normal", 2, 6, 2, 2, 30, 45, 1, 1, 1),
        new Level ("Dificil", 3, 8, 4, 1, 40, 40, 1, 1, 1),
        new Level ("Muy dificil", 4, 10, 8, 1, 50, 30, 1, 1, 1)
    };
    
    /**
     * Método que contiene un for y muestra los niveles antes declarados.
     */
    public static void showLevels(){
        for (Level myLevel : myLevels) {
            System.out.println(myLevel);
        }
    }
    
    /**
     * Muestra menú, seleccionamos el nivel deseado.
     * @return Número que ingresó el jugador referente al nivel.
     */
    public static int showMenu(){
        Scanner sc = new Scanner(System.in);
        int num;
        boolean aceptable= false;
        System.out.println("\nSelecciona un nivel: ");
        showLevels();
        do{
            num= sc.nextInt()-1;
            try{
                if (num < 0 || num >= 4){
                    throw new Exception();
                }
                aceptable = true;
            } catch (Exception e){
                System.out.println("Ese nivel no existe, selecciona otra "
                        + "vez: ");
            } 
        } while (!aceptable);
        return num;
    }
    
    /**
     * Arraylist con las cavernas aleatorias, laberinto listo.
     */
    public static ArrayList<Cavern> connectedCaverns = new ArrayList<>();
    
    /**
     * Se lleva acabo el muestreo de las cavernas. 
     */
    public static void showCaverns(){
        System.out.println("Cavernas= " + connectedCaverns);
    }
    
    /**
     * Creación de cavernas, estan en orden.
     * @param selectedLevel Para poder sacar la cantidad de 
     * los tipos de cavernas.
     */
    public static void creationCaverns(Level selectedLevel){
        ArrayList<Cavern> creationCaverns = new ArrayList<>();        
        //Se crea campamento.
        for (int i = 0; i < selectedLevel.getNumCamp(); i++) {
            connectedCaverns.add(new Camp(0));    
        }
        //Se crea wumpus.
        for (int i = 0; i < selectedLevel.getNumWumpus(); i++) {
            creationCaverns.add(new Wumpus());
        }
        //Se crea los pozos sin fin.
        for (int i = 0; i < selectedLevel.getNumBottomlessPit(); i++) {
            creationCaverns.add(new BottomlessPit());
        }
        //Se crean los murcielagos.
        for (int i = 0; i < selectedLevel.getNumGiantBat(); i++) {
            creationCaverns.add(new GiantBat()); 
        }
        //Se crean las cavernas con agua.
        for (int i = 0; i < selectedLevel.getNumWater(); i++) {
            creationCaverns.add(new Water());
        }
        //Se crean los tanques de oxigeno.
        for (int i = 0; i < selectedLevel.getNumOxygenTank(); i++) {
            creationCaverns.add(new OxygenTank());
        }
        //Se crea el brujo.
        for (int i = 0; i < selectedLevel.getNumWitcher(); i++) {
            creationCaverns.add(new Witcher());
        } 
        //Se crean cavernas normales.
        for(int i = creationCaverns.size() + 1; i < selectedLevel.getNumCaverns(); i++){
            creationCaverns.add(new Cavern());
        }
        int numCreationCaverns = creationCaverns.size();
        for (int i = 0; i < numCreationCaverns; i++) {
            int random = (int)(Math.random()*creationCaverns.size());
            Cavern selectedCavern = creationCaverns.get(random);
            creationCaverns.remove(random);
            selectedCavern.setId(connectedCaverns.size());
            connectedCaverns.add(selectedCavern);
        }
        //showCaverns();
    }
    
    /**
     * Se encarga de conectar las cavernas entre ellas del arraylist 
     * connectedCaverns.
     */
    public static void conectionCaverns(){
        for (int i = 0; i < connectedCaverns.size(); i++) {
            for (int j = 0; j < 3; j++) {
                int ran = (int) (Math.random() * connectedCaverns.size());
                if (i != ran && !connectedCaverns.get(i).isAlreadyConnected
                    (connectedCaverns.get(ran))){
                        connectedCaverns.get(i).connectCavern(connectedCaverns
                                .get(ran));
                        connectedCaverns.get(ran).connectCavern(connectedCaverns
                                .get(i));
                }
            }
        }
    }

    /**
     * Método que se encarga de juntar todo y empezar a jugar.
     */
    public static void game(){
        Level selectedLevel = myLevels[showMenu()];
        creationCaverns(selectedLevel);
        myPlayer.movePlayer(connectedCaverns.get(0), selectedLevel);
        conectionCaverns();
        do{
            myPlayer.lookUp(myPlayer);
            Scanner sc =  new Scanner(System.in);
            System.out.print("A que caverna quieres ir: ");
            try{
                int numCavernToGo = sc.nextInt();
                System.out.println("");
                if (myPlayer.getInTheCavern().isAlreadyConnected
                    (connectedCaverns.get(numCavernToGo))){
                        myPlayer.movePlayer(connectedCaverns.get(numCavernToGo),
                            selectedLevel);
                } else{
                    throw new Exception();
                }
            }catch(Exception e){
                myPlayer.space();
                System.out.println("No existe ese número de caverna, "
                        + "intentalo de nuevo...");
            }
        }while (!(myPlayer.isWin() || (myPlayer.getSumOxygen() <= 0)));
        myPlayer.finishGame();
    }
    
    /**
     * Método que se encarga de repetir el juego hasta que ya no 
     * quieras jugar más.
     */
    public static void play(){
        System.out.println("\n"+ ANSI_PURPLE + "---- Hunt The Wumpus ----" 
            + ANSI_RESET);
        game();
            
    }

    /**
     * Método para poder agregarle color a la consola.
     */
    public static final String ANSI_RESET = "\u001B[0m";

    /**
     * Método para poder agregarle color a la consola.
     */
    public static final String ANSI_PURPLE = "\u001B[35m";
    
    /**
     * El main, principal método que muestra el juego.
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        play();
    }
}
