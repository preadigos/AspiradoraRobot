import Errores.AspiradoraApagadaError;
import Errores.CepillosSuciosError;
import Errores.SinBateriaError;
import Modelos.Aspiradora;
import Servicios.Implementaciones.UsuarioServicio;

public class Main {


    public static void main(String[] args) throws SinBateriaError, CepillosSuciosError, AspiradoraApagadaError {

        UsuarioServicio usuarioServicio = new UsuarioServicio();
        usuarioServicio.comenzarALimpiar();
    }

}
