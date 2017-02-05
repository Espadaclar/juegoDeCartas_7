
/**
 *franciscoJavier
 */
class Carta {
    private int valor;//indica el valor de la carta y puede ser desde 1 a 7 o desde 10 a 12
    private int palo;//indica el palo de la carta y puede ser de 0 a 3 (0 es oros, 
                        //1 es copas, 2 es espadas y 3 es bastos)
    private int cambiaValor; // para modificar  el valor en las cartas As y tres.
    
    /**
     * constructor para inicializar los atributos.
     * @param valor
     * @param palo 
     */
    public Carta(int valor, int palo) {
        this.valor = valor;
        this.palo = palo;
        cambiaValor = 0;
    }

    /**
     * devuelve el valor de la carta en forma de entero -------------------------------------------- 1 
     */
    public int getValor() {
        return valor;
    }

    /**
     * devuelve el palo de la carta en forma de entero, 0 oros, 1 copas, 
     *  2 espadas, 3 bastos                              ------------------------------------------- 2
     */
    public int getPalo() {
        return palo;
    }
    
    /**
     * pone nombre a las cartas con valor 1, 10, 11, y 12 ------------------------------------------ 3
     */
     public String getNombreValor() {
         String nomValor = String.valueOf(valor);
         if(valor == 1){
             nomValor = "as de ";
         }
         else if(valor == 10){
             nomValor = "sota de ";
         }
         else if(valor == 11){
             nomValor = "caballo de ";
         }
         else if(valor == 12){
             nomValor = "rey de ";
         }
         
        return nomValor;
    }

    /**
     * pone nombre a los palos que eran enteros; oros para el 0, copas para el 1, 
     * espadas para el 2 y bastos para el 3.        -------------------------------------------------- 4
     */
    public String getNombrePalo() {
         String nomPalo = String.valueOf(valor);
         if(palo == 0){
             nomPalo = "oros ";
         }
         else if(palo == 1){
             nomPalo = "copas ";
         }
         else if(palo == 2){
             nomPalo = "espadas ";
         }
         else if(palo == 3){
             nomPalo = "bastos ";
         }
        return nomPalo;
    }

    /**
     * El método devuelve true en caso de que la carta sea superior a la carta pasada
     * como parámetro conforme a las reglas del tute.----------------------------------------------- 5
     * @return 
     */
        public boolean ganaA(Carta carta, int paloQuePinta){
        
        boolean cartaGanadora = false;
        if(palo == carta.getPalo() && modificaValor() > carta.modificaValor()){
            cartaGanadora = true;
        }
        else if(palo != carta.getPalo() && carta.getPalo() != paloQuePinta){
            cartaGanadora = true;
        }
        return cartaGanadora;
    }
    
    /**
     * mt para modificar  el valor en las cartas As y tres.
     * @return 
     */
    private int modificaValor(){
        int cambiaValor = valor;
        if(valor == 1){
            cambiaValor = 14;
        }
        else if(valor == 3){
            cambiaValor = 13;
        }
        return cambiaValor;
    }
    
    @Override
    public String toString() {
        String valor = getNombreValor() ;
        String palo = getNombrePalo();
        return valor+ " " + palo ;
    }
    
    
}



















