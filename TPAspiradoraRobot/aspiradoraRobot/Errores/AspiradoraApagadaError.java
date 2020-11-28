package Errores;

public class AspiradoraApagadaError extends Exception{
    public AspiradoraApagadaError(){
        super("La aspiradora esta apagada. Por favor enciéndala para comenzar la limpieza");
    }
}
