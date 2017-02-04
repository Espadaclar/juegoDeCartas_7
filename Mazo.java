import java.util.ArrayList;
/**
 * El constructor de la clase Mazo debe encargrse de crear las 40 cartas de la
 * baraja española y de dejarlas guardadas de alguna forma.
 *
 * Crear un método verCartasDelMazo que muestra linea a linea todas los nombres
 * de las cartas existentes en el mazo
 */
class Mazo {

    private ArrayList<Carta> cartas;
    private Carta carta;

    public Mazo() {
        carta = null;
        cartas = new ArrayList<>();
        crearMazo();
    }

    /**
     * creará el mazo de cartas automaticamente, en el constructor.
     */
    public void crearMazo() {
        int cont = 0;// controla en nº de palos.
        while(cont < 4){
            int cont2 = 1;
            while(cont2 <= 12){
                if(cont2 == 8){
                    cont2 = 10;
                }
                carta = new Carta(cont2, cont);
                cartas.add(carta);
                cont2 ++;
            }
            cont ++;
        }
    }

    /**
     *  muestra linea a linea todas los nombres de las cartas existentes en el mazo
     */
    public void verCartasDelMazo(){
          for(Carta carta: cartas){
             System.out.println(carta);
          }
    }
}





