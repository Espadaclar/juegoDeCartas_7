
/**
 *franciscoJavier
 */
class Carta {
    private int valor;//indica el valor de la carta y puede ser desde 1 a 7 o desde 10 a 12
    private int palo;//indica el palo de la carta y puede ser de 0 a 3 (0 es oros, 
                        //1 es copas, 2 es espadas y 3 es bastos)

    public Carta(int valor, int palo) {
        this.valor = valor;
        this.palo = palo;
    }

    public int getValor() {
        return valor;
    }

    public int getPalo() {
        return palo;
    }
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

    @Override
    public String toString() {
        String valor = getNombreValor() ;
        String palo = getNombrePalo();
        return valor+ " " + palo ;
    }
    
    
}



















