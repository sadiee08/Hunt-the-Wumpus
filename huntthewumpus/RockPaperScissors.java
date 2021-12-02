/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huntthewumpus;

import java.util.Scanner;

/**
 * Tiene todos los atributos y métodos de los objetos de tipo RockPaperScissors.
 * @author abbys
 */
public class RockPaperScissors {
    private int id;

    public RockPaperScissors() {
    }

    public RockPaperScissors(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    
    /**
     * Método que contiene todo lo que dice el brujo.
     */
    public void speachWitcher(){
        System.out.println(ANSI_GREEN + "Brujo: \nBienvenido, para salvar"
                + " tu vida,"
                + " ganarme haz de hacerlo."+ ANSI_GREEN + "\nSe sabio, "
                        + "oportunidad sólo hay una..."+ ANSI_RESET);
        System.out.println(ANSI_GREEN + "El juego es: Pidra, Papel o "
                + "Tijera\n" + ANSI_RESET);
        System.out.println(ANSI_GREEN + "He escogido mi respuesta, "
                + "tu turno es el siguiente..." + ANSI_RESET);
    }
    
    /**
     * Método que contiene lo que dice el brujo cuando se empata.
     */
    public void loose(){
       System.out.println(ANSI_GREEN + "Empatamos, pero desgraciadamente "
               + "para ti," + "\n" + ANSI_GREEN +  "ando cansado, así que "
               + "como quiera te quitaré 10% de oxigeno.\n" + ANSI_RESET);
   } 
    
    /**
     * Para quitar líneas de método de election(), agregue método 
     * que guarda Strings.
     * @param chooseWitcher para poder ver que String imprimir.
     */
    public void speachElection(int chooseWitcher){
        System.out.print(ANSI_GREEN + "\nMi elección fue..." 
                        + ANSI_RESET);
        switch (chooseWitcher){
            case 1: System.out.println(ANSI_GREEN + " piedra" 
                    + ANSI_RESET); break;
            case 2: System.out.println(ANSI_GREEN + " papel" 
                    + ANSI_RESET); break;
            case 3: System.out.println(ANSI_GREEN + " tijeras" 
                    + ANSI_RESET); break;   
        }
    }
    
    /**
     * Te pide la repuesta, y manda hablar el método tableGame para realizar
     * la comparación de las respuestas para regresar un dato booleano.
     * @return dato booleano.
     */
    public boolean election(){
        Scanner sc = new Scanner (System.in);
        speachWitcher();
        boolean result = false;
        boolean aceptable= false;
        System.out.print("1. Piedra \n2. Papel \n3. Tijeras "
                + "\nEscoge tu respuesta: ");
        do{
            int chooseNumber = sc.nextInt();
            int chooseWitcher = (int)(Math.random()*3) + 1;
            try{
                if (chooseNumber < 1 || chooseNumber > 3){
                    throw new Exception();
                }
                speachElection(chooseWitcher);
                result = tableGame((chooseNumber - 1), (chooseWitcher - 1));
                aceptable = true;
            } catch (Exception e){
                System.out.print("Ese número en el menú no existe, "
                        + "intentalo de nuevo. \nEscoge tu respuesta: ");
            } 
        } while (!aceptable);
        return result;
    }
    
    /**
     * Contiene la matriz del juego, y realiza la comparación para poder
     * decirte si ganaste o perdiste.
     * @param numPlayer Número de menú que elegiste.
     * @param numWitcher Número de menú que se eligió random.
     * @return
     */
    public boolean tableGame(int numPlayer, int numWitcher){
        boolean result = false;
        int table[][]= {
            {0, 0, 1},
            {1, 0, 0},
            {0, 1, 0}
        };
        if (table[numPlayer][numWitcher] == 0){
            if ((numPlayer == 0) && (numWitcher == 0)){
                loose();
            } else if((numPlayer == 1) && (numWitcher == 1)){
                loose();
            } else if((numPlayer == 2) && (numWitcher == 2)){
                loose();
            }else if(table[numPlayer][numWitcher] == 0){
            System.out.println(ANSI_GREEN + "Perdiste, que la suerte "
                    + "te acompañe" + ANSI_RESET);
            System.out.println(ANSI_GREEN + "El mago te ha quitado 10% de "
                    + "tu oxigeno\n" + ANSI_RESET);
            }
        }else if (table[numPlayer][numWitcher] == 1){
            System.out.println(ANSI_GREEN + "Haz ganado, tu merecer es ser "
                    + "llevado directo a Wumpus\n" + ANSI_RESET);
            result = true;   
        }
        return result;
    } 
    
    /**
     * Método que trae el método de election.
     * @return booleando para ver si ganas y si es así, para que le pase
     * el dato a un método y te lleve a wumpus.
     */
    public boolean extraGame(){ 
        return election();
    }
    
    /**
     * Método para poder agregarle color a la consola.
     */
    public static final String ANSI_GREEN = "\u001B[32m";
    
    /**
     * Método para poder agregarle color a la consola.
     */
    public static final String ANSI_RESET = "\u001B[0m";
}
