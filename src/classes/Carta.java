package classes;

public class Carta {
    private String valorString;
    private int valorInt;
    public Carta(int valor) {
        valorInt = valor;
        if (valor == 11 ) {
            this.valorString = "Valete";
        }
        else if (valor == 12) {
            this.valorString = "Dama";
        }
        else {
            this.valorString = String.valueOf(valor);
        }
    }

    public String getValorString() {
        return valorString;
    }
    public int getValorInt() {
        return valorInt;
    }
}
