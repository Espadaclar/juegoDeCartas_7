import java.util.ArrayList;
import java.util.Random;
/*
 *En el constructor de Juego se crean tantos jugadores como se especifiquen por parametro y un mazo. 
 *Sabemos que nunca se van a especificar menos de 3 ni más de 5 jugadores. 

 *Los nombres de los jugadores deben ser asignados de forma aleatoria entre un conjunto de nombres
 *(dos jugadores no pueden tener el mismo nombre).

 *Implementar en esa clase un método llamado repartir que coja el mazo y de 5 cartas a los jugadores
 *creados. La entrega de cartas debe ser al estilo del reparto que se hace en la realidad, es decir,
 *primero se baraja y luego se entrega una carta a cada jugador. La última carta entregada indica el
 *palo que pinta, que debe registrarse de alguna foma.

 *Implementa en la clase Jugador un metodo llamado getNombre que devuelva como String el nombre del jugador.

 *Implementa un método llamado verCartasJugador que muestre por pantalla las cartas de un jugador. 
 *Para saber qué jugador mostrar, indicamos como parámetro del método el nombre del Jugador.
 */

/**
 * franciscoJavier.
 */
class Juego {

    private int numJugadores;
    private String nameJugador;
    private String nameJugadorHumano;
    private String paloQuePinta;// almacena el palo que pinta después de repartir cartas.

    private Mazo mazo;
    private Carta carta;
    private ArrayList<Jugador> jugadores;

    public static String[] NOMBRES_JUGADORES = {"Juán", "Francisco Javier", "Lorenzo", "Israel", "Cristian", "Ricardo", "Emilio", "José Ricardo",
            "Luis Enrique", "Luis Federico", "Mario", "Nasrrudín", "José Manuel", "Aquiles", "Merquiades", "Francisco José",
            "Narciso", "Gregorio", "Isidoro", "Raquel", "María", "Milagros", "Eva Carmina", "Jacinta", "Blas", "Fulgencio",
            "Salusitano", "Elena", "Gemma", "Fermín", "Amancio", "Esther", "Ángela"};
    public static int NUM_CARTAS = 5; // Nº DE CARTAS QUE SE DÁ A LOS JUGADORES.

    /*
     *construtor d la clase Juego, para inicializar los atributos.
     */
    public Juego(int numJugadores, String nameJugadorHumano) {
        this.numJugadores = (numJugadores < 3 || numJugadores > 5) ? 4 : numJugadores;
        this.nameJugadorHumano = nameJugadorHumano;
        paloQuePinta = "";

        mazo = new Mazo();
        carta = null;
        jugadores = new ArrayList<>();

        //el nameJugadorHumano será el primero de la colección de jugadores;
        Jugador jugadorH = new Jugador(nameJugadorHumano);
        jugadores.add(jugadorH);

        // el  bucle for crea el nº de jugadores pasado como parámetro, y los almacena.
        for( int i = 1; i < numJugadores; i++ ) {//-----i = 1, porque hemos añadido ya al jugadorHumano.
            nameJugador = creaNombreAleatorio(); // ------creaNombreAleatorio() mt___11.
            Jugador jugador = new Jugador(nameJugador);            
            jugadores.add(jugador);// -------- ArrayList<Jugador> jugadores;.
        }

        //damos la bien benida a todos los jugadores.   mt______12.
        bienVenidosALaPartida();

    }

    /**
     * muestra por pantalla el nombre de todos los jugadores.    ---------------------------------------------------- 0
     */
    public void verNombreJugadores() {
        for (Jugador jugador : jugadores) {
            System.out.println(jugador.getNameJugador());
        }
    }

    /**
     * coja el mazo y dÉ¡ 5 cartas a los jugadores creados. La entrega de cartas
     * debe ser al estilo del reparto que se hace en la realidad, es decir,
     * primero se baraja y luego se entrega una carta a cada jugador. La última
     * carta entregada indica el palo que pinta, que debe registrarse de alguna
     * foma.                                    ----------------------------------------------------------------------- 1
     */
    public int repartir() {
        int triunfo = 0;
        mazo.barajar();
        int contCartas = 0;
        while (contCartas < NUM_CARTAS) {
            int contJugadores = 0;
            while (contJugadores < jugadores.size()) {
                carta = mazo.sacarCarta();
                jugadores.get(contJugadores).recibirCarta(carta);
                paloQuePinta = "======== Pintan " + carta.getNombrePalo();
                triunfo = carta.getPalo();
                contJugadores++;
            }
            contCartas++;
        }
        System.out.println("");
        //para mostrar las cartas que recibe el jugador humano y el palo que pinta.
        System.out.println("=== Las Cartas están repartidas.");
        verCartasJugador(nameJugadorHumano);//-----invoca al mt________78
        System.out.println(paloQuePinta);
        return triunfo;
    }

    /**
     * muestra por pantalla las cartas de un jugador. Para saber qué jugador
     * mostrar, indicamos como parámetro del método el nombre del Jugador               ------------------------------------------ 2
     */
    public void hacerTrampasYVerCartasDeJugador(String nombreJugador) {
        System.out.println("");
        System.out.println("Cartas del jugador.- " + nombreJugador);
        int cont = 0;

        for (Jugador jugador : jugadores) {
            if (jugador.getNameJugador().equals(nombreJugador)) {
                jugador.verCartasJugador();
            }
            cont++;
        }
    }

    /**
     * muestra las cartas del jugadorHumano             --------------------------------------------------------------------------- 3
     */
    public void verCartasJugadorHumano(){
        verCartasJugador(nameJugadorHumano); //------------ invoca al mt________78.
    }

    /**
     * mt para asignar un nombre al jugador, de forma
     * aleatoria.------------------------------------------------- 11
     */
    private String creaNombreAleatorio() {
        Random ale = new Random();
        boolean encontrado = false;
        while (!encontrado) {
            // VL almacena un nº aletorio entre 0 y el nº de elementos de Array.
            int aux = ale.nextInt(NOMBRES_JUGADORES.length);
            if (NOMBRES_JUGADORES[aux] != null && NOMBRES_JUGADORES[aux] != nameJugadorHumano) {
                nameJugador = NOMBRES_JUGADORES[aux];
                encontrado = true;
            }
        }
        return nameJugador;
    }

    /**
     * dá la bienVenida a todos los jugadores
     * -------------------------------------------------------------- 12
     */
    private void bienVenidosALaPartida() {
        System.out.println("");
        System.out.println("Bien venidos a la partida.\nComo jugador humano tenemos a ========= "
            + nameJugadorHumano + "\nNombre de todos los jugadores.- \n");
        verNombreJugadores();
    }

    /**
     * muestra por pantalla las cartas de todos los jugador.               **************************************************** 77
     */
    public void verCartasTodosJugadores() {
        int contJugadores = 0;
        while (contJugadores < jugadores.size()) {
            System.out.println("");
            System.out.println("Cartas del jugador.- " + jugadores.get(contJugadores).getNameJugador());
            jugadores.get(contJugadores).verCartasJugador();
            contJugadores++;
        }
    }

    /**
     * muestra por pantalla las cartas de un jugador. Para saber qué jugador
     * mostrar, indicamos como parámetro del método el nombre del Jugador    *************************************************  78
     */
    private void verCartasJugador(String nombreJugador) {
        System.out.println("Cartas del jugador.- " + nombreJugador);
        int cont = 0;

        for (Jugador jugador : jugadores) {
            if (jugador.getNameJugador().equals(nombreJugador)) {
                jugador.verCartasJugador();
            }
            cont++;
        }
    }
}

