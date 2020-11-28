package Servicios.Implementaciones;

import Errores.AspiradoraApagadaError;
import Errores.CepillosSuciosError;
import Errores.SinBateriaError;
import Modelos.Ambiente;
import Modelos.Aspiradora;
import Modelos.Cepillo;
import Servicios.iAspiradora;

public class AspiradoraServicio implements iAspiradora {

    Aspiradora aspiradora = new Aspiradora();

    @Override
    public void inicializarCepillos() {
        aspiradora.getCepillos()[0] = new Cepillo();
        aspiradora.getCepillos()[1] = new Cepillo();
    }

    @Override
    public void cambiarVelocidad (int velocidad) {
        aspiradora.setVelocidad(velocidad);
    }

    @Override
    public boolean limpiar(Ambiente ambiente) {
        if (aspiradora.getBateria() > 0 && cepillosLimpios() && !terminoDeLimpiar(ambiente)){
            ambiente.getAmbiente()[aspiradora.getPosicionFila()][aspiradora.getPosicionColumna()].setEstaLimpio(true);
            ensuciarCepillos();
        }
        return ambiente.getAmbiente()[aspiradora.getPosicionFila()][aspiradora.getPosicionColumna()].getEstaLimpio();
    }

    @Override
    public void limpiarUltimaCelda(Ambiente ambiente) {
        ambiente.getAmbiente()[aspiradora.getPosicionFila()][aspiradora.getPosicionColumna()].setEstaLimpio(true);
        ensuciarCepillos();
    }

    @Override
    public boolean terminoDeLimpiar(Ambiente ambiente) {
        if (ambiente.getAmbiente()[0].length % 2 == 0) {
            return (ambiente.getAmbiente()[aspiradora.getPosicionFila()][aspiradora.getPosicionColumna()].getBordes().get("arriba") &&
                    ambiente.getAmbiente()[aspiradora.getPosicionFila()][aspiradora.getPosicionColumna()].getBordes().get("derecha"));
        } else {
            return (ambiente.getAmbiente()[aspiradora.getPosicionFila()][aspiradora.getPosicionColumna()].getBordes().get("abajo") &&
                    ambiente.getAmbiente()[aspiradora.getPosicionFila()][aspiradora.getPosicionColumna()].getBordes().get("derecha"));
        }
    }

    @Override
    public void mover(Ambiente ambiente) throws SinBateriaError, CepillosSuciosError, AspiradoraApagadaError {
        if (!aspiradora.getEstaPrendida()) {
            throw new AspiradoraApagadaError();
        }
        if (ambiente.getAmbiente()[0].length == aspiradora.getPosicionColumna() || !limpiar(ambiente)){
            finalizarLimpieza(ambiente);
        } else {
            limpiar(ambiente);
            bajarBateria();
            if (aspiradora.getPosicionColumna() %2 == 1) {
                moverArriba (ambiente);
            } else {
                moverAbajo(ambiente);
            }
        }
    }

    @Override
    public void encender() throws SinBateriaError {
        if (aspiradora.getBateria() == 0) {
            throw new SinBateriaError();
        }
        aspiradora.setEstaPrendida(true);
    } 

    @Override
    public void moverArriba(Ambiente ambiente) throws SinBateriaError, CepillosSuciosError, AspiradoraApagadaError {
        if (!(ambiente.getAmbiente()[aspiradora.getPosicionFila()][aspiradora.getPosicionColumna()].getBordes().get("arriba"))){

            if (ambiente.getAmbiente()[aspiradora.getPosicionFila() - aspiradora.getPosMover()][aspiradora.getPosicionColumna()].getTieneObstaculo()) {
                aspiradora.setPosicionFila(aspiradora.getPosicionFila() - aspiradora.getPosEsquivar());
                mover(ambiente);
            } else {
                aspiradora.setPosicionFila(aspiradora.getPosicionFila() - aspiradora.getPosMover());
                mover(ambiente);
            }
        } else {
            aspiradora.setPosicionColumna(aspiradora.getPosicionColumna() + 1);
            mover(ambiente);
        }
    }

    @Override
    public void moverAbajo(Ambiente ambiente) throws SinBateriaError, CepillosSuciosError, AspiradoraApagadaError {
        if (!(ambiente.getAmbiente()[aspiradora.getPosicionFila()][aspiradora.getPosicionColumna()].getBordes().get("abajo"))){

            if (ambiente.getAmbiente()[aspiradora.getPosicionFila() + aspiradora.getPosMover()][aspiradora.getPosicionColumna()].getTieneObstaculo()) {
                aspiradora.setPosicionFila(aspiradora.getPosicionFila() + aspiradora.getPosEsquivar());
                mover(ambiente);
            } else {
                aspiradora.setPosicionFila(aspiradora.getPosicionFila() + aspiradora.getPosMover());
                mover(ambiente);
            }
        } else {
            aspiradora.setPosicionColumna(aspiradora.getPosicionColumna() + 1);
            mover(ambiente);
        }
    }

    @Override
    public void finalizarLimpieza (Ambiente ambiente) throws CepillosSuciosError, SinBateriaError {
        limpiarUltimaCelda(ambiente);
        aspiradora.setEstaPrendida(false);
        determinarError();
        System.out.println("El ambiente ha sido limpiado correctamente");
    }

    @Override
    public void determinarError() throws SinBateriaError, CepillosSuciosError {
        if (aspiradora.getBateria() == 0) {
            throw new SinBateriaError();
        }
        if (!cepillosLimpios()) {
            throw new CepillosSuciosError();
        }
    }

    @Override
    public void bajarBateria() {
        aspiradora.setBateria(aspiradora.getBateria() - 1);
    }

    @Override
    public void ensuciarCepillos() {
        aspiradora.getCepillos()[0].ensuciarCepillo();
        aspiradora.getCepillos()[1].ensuciarCepillo();
    }

    @Override
    public boolean cepillosLimpios (){
        return (aspiradora.getCepillos()[0].getEstaLimpio() && aspiradora.getCepillos()[1].getEstaLimpio());
    }

}
