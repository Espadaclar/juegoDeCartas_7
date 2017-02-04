/**
 * franciscoJ
 */
class Jugador {

    private String name;
    private Carta[] cartasDelJugador;
    // cuenta las cartas recibidas.
    private int numCartaRecibidas;

    public Jugador(String name) {
        this.name = name;
        cartasDelJugador = new Carta[5];
        numCartaRecibidas = 0;
    }

    /**
     * recibe una carta pasada por parámetro.
     *
     * @param recibirCarta
     */
    public void recibirCarta(Carta recibirCarta) {
        cartasDelJugador[numCartaRecibidas] = recibirCarta;
        numCartaRecibidas++;
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
     * devuelve el nombre del jugador.
     *
     * @return
     */
    public String getNameJugador() {
        return name;
    }

}