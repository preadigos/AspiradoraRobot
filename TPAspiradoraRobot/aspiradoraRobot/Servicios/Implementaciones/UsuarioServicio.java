package Servicios.Implementaciones;

import Errores.AspiradoraApagadaError;
import Errores.CepillosSuciosError;
import Errores.SinBateriaError;
import Modelos.Aspiradora;
import Servicios.iUsuario;

import java.util.Scanner;


public class UsuarioServicio implements iUsuario{

    private AmbienteServicio ambienteServicio = new AmbienteServicio(cargarFilas(), cargarColumnas());
    private AspiradoraServicio aspiradoraServicio = new AspiradoraServicio();

    @Override
    public int cargarFilas (){
        System.out.print("Ingrese la cantidad de filas: ");
        return Integer.parseInt(readInput());
    }

    @Override
    public int cargarColumnas (){
        System.out.print("Ingrese la cantidad de columnas: ");
        return Integer.parseInt(readInput());
    }

    @Override
    public int cargarVelocidad() {
        System.out.print("Ingrese la velocidad [1/2]: ");
        return Integer.parseInt(readInput());
    }

    @Override
    public String readInput (){
        Scanner readInput = new Scanner(System.in);
        return readInput.nextLine();
    }

    @Override
    public void comenzarALimpiar() throws CepillosSuciosError, SinBateriaError, AspiradoraApagadaError {
        aspiradoraServicio.encender();
        aspiradoraServicio.cambiarVelocidad(cargarVelocidad());
        aspiradoraServicio.inicializarCepillos();
        ambienteServicio.inicializarAmbiente();
        mostrarAmbiente();
        aspiradoraServicio.mover(ambienteServicio.getAmbiente());
        mostrarAmbiente();
    }

    @Override
    public void mostrarAmbiente() {
        for(int i = 0; i < ambienteServicio.obtenerAmbienteSuelo().length; ++i) {
            for(int j = 0; j < ambienteServicio.obtenerAmbienteSuelo()[0].length; ++j) {
                ambienteServicio.obtenerAmbienteSuelo()[i][j].mostrarSuelo();
                System.out.print("\t");
            }

            System.out.print("\n");
        }
    }

}
