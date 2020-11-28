package Servicios;

import Modelos.Ambiente;
import Modelos.Suelo;

public interface iAmbiente {
    public void inicializarAmbiente();
    public void ubicarObstaculos();
    public void determinarBordes();
    public Suelo[][] obtenerAmbienteSuelo();
    public Ambiente getAmbiente();
}
