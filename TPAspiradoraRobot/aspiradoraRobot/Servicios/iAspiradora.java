package Servicios;

import Errores.AspiradoraApagadaError;
import Errores.CepillosSuciosError;
import Errores.SinBateriaError;
import Modelos.Ambiente;

public interface iAspiradora {
    public void inicializarCepillos();
    public void cambiarVelocidad (int velocidad);
    public boolean limpiar(Ambiente ambiente);
    public void limpiarUltimaCelda(Ambiente ambiente);
    public boolean terminoDeLimpiar(Ambiente ambiente);
    public void mover(Ambiente ambiente) throws SinBateriaError, CepillosSuciosError, AspiradoraApagadaError;
    public void encender() throws SinBateriaError;
    public void moverArriba(Ambiente ambiente) throws SinBateriaError, CepillosSuciosError, AspiradoraApagadaError;
    public void moverAbajo(Ambiente ambiente) throws SinBateriaError, CepillosSuciosError, AspiradoraApagadaError;
    public void finalizarLimpieza (Ambiente ambiente) throws CepillosSuciosError, SinBateriaError;
    public void determinarError() throws SinBateriaError, CepillosSuciosError;
    public void bajarBateria();
    public void ensuciarCepillos();
    public boolean cepillosLimpios ();
}
