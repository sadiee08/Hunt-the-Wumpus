/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package huntthewumpus;
import java.util.Scanner;

import static huntthewumpus.HuntTheWumpus.connectedCaverns;

/**
 * Tiene todos los atributos y métodos de los objetos de tipo Witcher.
 * @author abbys
 */
public class Witcher extends Cavern implements Decreaseable {

    public Witcher() {
        this.oxygen = -10;
    }

    public Witcher(int id) {
        super(id);
    }

    /**
     * Juego de piedra y papel y tijera.
     * @param p se lo manda a decreaseOxygen.
     * @return regresa si es que gano o no.
     */
    public boolean extraGame(Player p){
        RockPaperScissors game = new RockPaperScissors();
        Scanner sc =  new Scanner(System.in);
        boolean win = game.extraGame();
        if (win == false){
            decreaseOxygen(p);
        }else if(win == true){
            p.modiOxygen(this.oxygen= -1);
            System.out.print(ANSI_GREEN + "Cuidado haz de tener para"
                    + " regresar, un gran gusto me llevo\n" + ANSI_GREEN + 
                    "por jugar con Usted.\n"
                    + ANSI_RESET);
            System.out.println("");
            char charAt = sc.next().charAt(0);
        }       
        return win;
    }
    
    /**
     * Si es que ganas, te lleva a donde esta Wumpus.
     * @return retorna un número random si le ganaste a Witcher; 
     * si no, regresa null.
     */
    public Cavern moveToWumpus(){
        for (int i = 0; i < connectedCaverns.size(); i++) {
            if(connectedCaverns.get(i).getClass() == (new Wumpus()).getClass()){
                return connectedCaverns.get(i);
            }
        }
        return null;
    }
     
    /**
     * Muestra el contenido de lo que pasa cuando entras a la caverna 
     * de Wumpus.
     * @param p
     * @return
     */
    @Override
    public Cavern move(Player p){
        p.space();
        System.out.println(ANSI_GREEN + "¡Hay un brujo en está caverna!"
                + "\n" + ANSI_RESET);
        if(p.isYouCatchWumpus() == false){
            if (extraGame(p) == true){
                return moveToWumpus();   
            }
        } else if (p.isYouCatchWumpus() == true){
            System.out.println(ANSI_GREEN + "¡PUF!... Se esfumo al ver "
                    + "a Wumpus" + ANSI_RESET);
            return null;
        }
        return null;
    }

    /**
     * Disminuye tu oxigeno.Te quita 10 si pierdes.
     * @param p
     */
    @Override
    public void decreaseOxygen(Player p) {
        p.modiOxygen(this.oxygen = -10);
    }
    
    /**
     * Muestra el normbre de la caverna en la que estás.
     * @return El número y nombre de la caverna.
     */
    @Override
    public String toString() {
        return getId() + "Witcher";
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
