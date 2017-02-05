/*
 * Tenga un constructor que admita dos parametros. El primero es un entero que indica el número de
 *jugadores que van a tirar carta y el segundo es otro entero que indica el palo que pinta.
 */
import java.util.ArrayList;

/**
 *franciscoJavier
 */
class Baza {
    private int numJugadores; // ---ndica el número de jugadores que van a tirar carta.
    private int paloQuePinta; //----es otro entero que indica el palo que pinta.
    private String nombreJugador;
    
    private ArrayList<Carta> bazasDelJugador;
    /**
     * constructor para inicializar los atributos.
     * @param numJugadores
     * @param paloQuePinta 
     */
    public Baza(int numJugadores, int paloQuePinta) {
        this.numJugadores = numJugadores;
        this.paloQuePinta = paloQuePinta;
        nombreJugador = "";
        
        bazasDelJugador = new ArrayList<>();//---- para poder añadir cartas a la baza.
    }

    /**
     * El primer parámetro representa la carta que tira un jugador a la mesa y que, por 
     * tanto, se añade a la baza. No hace falta comprobar que la carta añadida 
     * sea o no null, se supone que es una carta. El segundo parámetro indica el
     * nombre del jugador que tiro la carta
     */
    public void addCarta(Carta carta, String nombreJ){
        bazasDelJugador.add(carta);//----  añade cartas a la baza.
        nombreJugador = nombreJ;
    }
}

