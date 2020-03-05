package classes;

public enum Carta {
    AS(1, "As"),
    DOIS(2),
    TRES(3),

    QUATRO(4),

    CINCO(5),

    SEIS(6),

    SETE(7),

    OITO(8),

    NOVE(9),

    DEZ(10),

    VALETE(11, "Valete"),

    DAMA(12, "Dama"),

    REI(13, "Rei");

    private int valor;
    private String nome;

    Carta(int valor) {
        this.valor = valor;
        this.nome = String.valueOf(valor);
    }

    Carta(int valor, String nome) {
        this.valor = valor;
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public int getValor() {
        return valor;
    }
}
