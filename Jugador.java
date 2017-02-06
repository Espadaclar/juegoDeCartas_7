import java.util.Random;
import java.util.ArrayList;
/**
 * franciscoJ
 */
class Jugador {

    private String nameJugador;
    private Carta[] cartasDelJugador;
    private ArrayList<Baza> bazasGanadas;

    // cuenta las cartas recibidas.
    private int numCartaRecibidas;
    private int numeroBazasGanadas;

    public Jugador(String nameJugador) {
        this.nameJugador = nameJugador;
        cartasDelJugador = new Carta[5];
        bazasGanadas = new ArrayList<>();

        numCartaRecibidas = 0;
        numeroBazasGanadas = 0;
    }

    /**
     * recibe una carta pasada por parámetro.
     * @param recibirCarta -------------------------------------------------------------------------------------------- 1
     */
    public void recibirCarta(Carta recibeCarta) {
        int cont = 0;
        boolean encontrado = false;
        while(cont < cartasDelJugador.length && !encontrado){
            if(cartasDelJugador[cont] == null){
                cartasDelJugador[cont] = recibeCarta;
                encontrado = true;
            }
            cont ++;
            numCartaRecibidas++;
        }
    }

    /**
     * imprima por pantalla las cartas del jugador,---------------------------------------------------------------------- 2
     */
    public void verCartasJugador() {
        for (int i = 0; i < cartasDelJugador.length; i++) {
            if (cartasDelJugador[i] != null) {
                System.out.println(cartasDelJugador[i]);
            }
        }
    }

    /**
     * El método muestra por pantalla el nombre del jugador que ha tirado la carta
     * y la carta tirada. Devuelve la carta tirada. En caso de que el jugador no 
     * tenga cartas o de que el nombre especificado como parámetro no coincida 
     * con ninguna carta, devuelve null
     * @param String que indica el nombre de la carta a tirar       ------------------------------------------------------- 3
     */
    public Carta tirarCarta(String nameCarta){
        Carta cartaTirada = null;
        if(numCartaRecibidas > 0){ // si el jugador tiene cartas en la mano.
            int cont = 0;
            boolean encontrado = false;
            while(cont < cartasDelJugador.length && !encontrado){
                if(cartasDelJugador[cont] != null ){
                    if( cartasDelJugador[cont].toString().equals(nameCarta)){
                        cartaTirada = cartasDelJugador[cont]; // si son iguales, almaceno la carta para devolverla.
                        cartasDelJugador[cont] = null; // la anulo de la posición donde estaba.
                        encontrado = true;
                        numCartaRecibidas--;// descuento una carta al total que tiene el jugador.
                    }
                }
                cont ++;
            }
            if( cartaTirada != null){
                System.out.println("Carta jugada por.-  " +nameJugador
                    + "\n================= " +cartaTirada);
            }
        }
        return cartaTirada;
    }

    /**
     * muestra por pantalla el nombre del jugador que ha tirado la carta y la carta tirada.
     * Devuelve la carta tirada. En caso de que el jugador no tenga cartas, devuelve null. ------------------------------- 4
     */
    public Carta tirarCartAleatoria() {
        Carta cartaTirada = null;
        if (numCartaRecibidas > 0) {
            // montamos un bucle para recorrer el arrays de cartas.
            int cont = 0;
            boolean encontrado = false;
            while (cont < cartasDelJugador.length && !encontrado) {
                Random ale = new Random();
                int aux = ale.nextInt(cartasDelJugador.length);
                if (cartasDelJugador[aux] != null) {
                    cartaTirada = cartasDelJugador[aux];
                    cartasDelJugador[aux] = null;
                    numCartaRecibidas--;// descuento una carta al total que tiene el jugador.
                }
                cont++;
            }

        }
        if (cartaTirada != null) {
            System.out.println("Carta jugada por.-  " + nameJugador
                + "\n================= " + cartaTirada);
        }
        return cartaTirada;
    }

    /**
     * devuelve el nombre del jugador.                      ---------------------------------------------------------------- 5
     */
    public String getNameJugador() {
        return nameJugador;
    }

    /**
     * un jugador pueda decidir inteligentemente que carta tirar
     * @param int, palo de la primer carta
     * @param Carta, el valor y palo de la carta que va ganando
     * @param int , palo que pinta.
     */
    public Carta tirarCartaInteligentemente(int paloPrimerCarta, Carta carta, int paloQuePinta){
        Carta cartaInteligente = null;

        //cartaInteligente = tirarCartAleatoria();
        return tirarCartAleatoria();
    }

    /**
     * se invocará cuando el jugador gana una baza y se la lleva. El método admite 
     * un parámetro de tipo Baza (la baza que ha ganado el jugador) que se asume 
     * nunca va a ser null. El método no devuelve nada. -------------------------------------------------- 6
     */
    public void addBaza(Baza bazaGanada){
        bazasGanadas.add(bazaGanada);
        numeroBazasGanadas ++;
    }

    /**
     * devuelve el número de bazas que el jugador lleva ganadas en el momento 
     * actual.                          ------------------------------------------------------------------ 7
     */
    public int getNumeroBazasGanadas(){
        return numeroBazasGanadas;
    }
}


