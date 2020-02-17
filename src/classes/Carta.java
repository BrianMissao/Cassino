package classes;

public enum Carta {
    AS(1),
    VALETE(11),

    DAMA(12),

    REI(13);

    private int valor;

    Carta(int valor) {
        this.valor = valor;
    }

    public int getValor() {
        return valor;
    }
}
