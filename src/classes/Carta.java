package classes;

public class Carta {
    private String valorString;
    private int valorInt;

    public Carta(int valor) {
        this.valorInt = valor == 0 ? 1 : valor;
        definirStringValor();
    }

    private void definirStringValor() {
        if (getValorInt() == 1 ) {
            this.valorString = "As";
        }
        else if (getValorInt() == 11) {
            this.valorString = "Valete";
        } else if (getValorInt() == 12) {
            this.valorString = "Dama";
        } else if (getValorInt() == 13) {
            this.valorString = "rei";
        } else {
            this.valorString = String.valueOf(getValorInt());
        }
    }

    public String getValorString() {
        return valorString;
    }

    public int getValorInt() {
        return valorInt;
    }
}
