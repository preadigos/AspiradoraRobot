package Modelos;

public class Aspiradora {

    static final int posEsquivar = 2;
    static final int posMover = 1;

    private Cepillo[] cepillos;
    private int velocidad;
    private int bateria;
    private int posicionColumna;
    private int posicionFila;
    private boolean estaPrendida;

    public Aspiradora(){
        this.cepillos = new Cepillo[2];
        this.velocidad = 0;
        this.bateria = 100;
        this.posicionColumna = 0;
        this.posicionFila = 0;
        this.estaPrendida = false;
    }

    //GETTERS Y SETTERS
    public Cepillo[] getCepillos() {
        return cepillos;
    }

    public void setCepillos(Cepillo[] cepillos) {
        this.cepillos = cepillos;
    }

    public int getVelocidad() {
        return velocidad;
    }

    public void setVelocidad(int velocidad) {
        this.velocidad = velocidad;
    }

    public int getBateria() {
        return bateria;
    }

    public void setBateria(int bateria) {
        this.bateria = bateria;
    }

    public int getPosicionColumna() {
        return posicionColumna;
    }

    public void setPosicionColumna(int posicionColumna) {
        this.posicionColumna = posicionColumna;
    }

    public int getPosicionFila() {
        return posicionFila;
    }

    public void setPosicionFila(int posicionFila) {
        this.posicionFila = posicionFila;
    }

    public static int getPosEsquivar() {
        return posEsquivar;
    }

    public static int getPosMover() {
        return posMover;
    }

    public boolean getEstaPrendida() {
        return estaPrendida;
    }

    public void setEstaPrendida(boolean estaPrendida) {
        this.estaPrendida = estaPrendida;
    }
}