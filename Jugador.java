/**
 * franciscoJ
 */
class Jugador {

    private String nameJugador;
    private Carta[] cartasDelJugador;
    // cuenta las cartas recibidas.
    private int numCartaRecibidas;

    public Jugador(String nameJugador) {
        this.nameJugador = nameJugador;
        cartasDelJugador = new Carta[5];
        numCartaRecibidas = 0;
    }

    /**
     * recibe una carta pasada por parámetro.
     * @param recibirCarta
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
     * imprima por pantalla las cartas del jugador,
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
     * y la carta tirada. Devuelve la carta tirada
     * @param String que indica el nombre de la carta a tirar
     */
    public Carta tirarCarta(String nameCarta){
        Carta cartaTirada = null;
        if(numCartaRecibidas > 0){
            int cont = 0;
            boolean encontrado = false;
            while(cont < cartasDelJugador.length && !encontrado){
                if(cartasDelJugador[cont] != null ){
                    if( cartasDelJugador[cont].toString().equals(nameCarta)){
                        cartaTirada = cartasDelJugador[cont];
                        encontrado = true;
                        numCartaRecibidas--;
                    }
                }
                cont ++;
            }
            if( cartaTirada != null){
                System.out.println("Carta jugada por.-  " +nameJugador
                    + "\n================= " +cartaTirada.toString());
            }
        }
        return cartaTirada;
    }

    /**
     * devuelve el nombre del jugador.
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
    public void tirarCartaInteligentemente(int paloPrimerCarta, Carta carta, int paloQuePinta){

    }
}



