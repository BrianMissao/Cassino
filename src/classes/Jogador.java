package classes;

public class Jogador {
    private String nome;
    private double money;

    public Jogador(String nome) {
        this.nome = nome;
        this.money = 30000.00;
    }

    public void ganhar(double money) {
        this.money += money;
    }

    public void perder(double money) {
        this.money -= money;
    }

    public String getNome() {
        return nome;
    }

    public double getMoney() {
        return money;
    }
    public void perderJogo() {
        System.out.println("Você perdeu o jogo.");
    }

    public void ganharJogo() {
        System.out.println("Você ganhou o jogo!");
    }
}
