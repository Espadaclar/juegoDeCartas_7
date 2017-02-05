import java.util.ArrayList;
import java.util.Random;
/**
 * El constructor de la clase Mazo debe encargrse de crear las 40 cartas de la
 * baraja española y de dejarlas guardadas de alguna forma.
 *
 * Crear un método verCartasDelMazo que muestra linea a linea todas los nombres
 * de las cartas existentes en el mazo
 */
class Mazo {

    private ArrayList<Carta> cartas;
    private ArrayList<Carta> copia;
    private Carta carta;

    public Mazo() {
        carta = null;
        cartas = new ArrayList<>();
        crearMazo(); // ---------------------------------------------------------mt___ nº 77.
    }

    /**
     * consige mezclar las cartas existentes en ese momento en el mazo. ----------------------------------- 1.
     */
    public void barajar(){
        Random ale = new Random();
        int cont = 0;
        while(cont < 40){
            int comodin = ale.nextInt(40);
            Carta cartaP = cartas.get(cont);// -------almacena la carta que se va a cambiar de lugar.
            //--cartas.set(...) elimina la carta de la posción cont, y pone la de la posición aleatoria.
            cartas.set(cont, cartas.get(comodin));
            //--cartas.set(...) elimina la carta de la posción comodin, y pone la eliminada anteriormente.
            cartas.set(comodin, cartaP);
            cont ++;
        }
    }
    
    /**
     * devuelva un objeto Carta. Concretamente debe devolver la primera 
     * carta del mazo, eliminando esta del mazo.----------------------------------------------------------- 2
     */
    public Carta sacarCarta(){
        Carta primeraCarta = cartas.remove(0); 
        return primeraCarta;
    }
    
    /**
     *  muestra linea a linea todas los nombres de las cartas existentes en el mazo ------------------------ 76.
     */
    public void verCartasDelMazo(){
         int cont = 1;
          for(Carta carta: cartas){
             System.out.println( cont + ".- " +carta);
             cont ++;
          }
    }
    
    /**
     * creará el mazo de cartas automaticamente, en el constructor. -------------------------------------------- 77
     */
    private void crearMazo() {
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
}





