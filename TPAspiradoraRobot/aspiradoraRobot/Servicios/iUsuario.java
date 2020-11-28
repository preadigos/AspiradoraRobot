package Servicios;

import Errores.AspiradoraApagadaError;
import Errores.CepillosSuciosError;
import Errores.SinBateriaError;

public interface iUsuario {
    public int cargarFilas ();
    public int cargarColumnas ();
    public int cargarVelocidad();
    public String readInput ();
    public void mostrarAmbiente();
    public void comenzarALimpiar() throws CepillosSuciosError, SinBateriaError, AspiradoraApagadaError;
}
