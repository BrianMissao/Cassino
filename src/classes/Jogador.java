package classes;

public class Jogador {
    private String nome;
    private double money;

    public Jogador(String nome) {
        this.nome = nome;
    }

    public void ganhar(double money) {
        this.money += money;
    }
    public void perder (double money) {
        this.money -= money;
    }

    public String getNome() {
        return nome;
    }

    public double getMoney() {
        return money;
    }
}
