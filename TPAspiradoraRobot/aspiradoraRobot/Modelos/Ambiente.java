package Modelos;

public class Ambiente {
    private Suelo[][] ambiente;

    public Ambiente(int filas, int columnas) {
        this.ambiente = new Suelo[filas][columnas];
    }

    public Suelo[][] getAmbiente() {
        return this.ambiente;
    }

    public void setAmbiente(Suelo[][] ambiente) {
        this.ambiente = ambiente;
    }
}
