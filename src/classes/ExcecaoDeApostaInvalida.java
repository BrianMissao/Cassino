package classes;

public class ExcecaoDeApostaInvalida extends RuntimeException{
    public ExcecaoDeApostaInvalida(double money) {
        super("Você só pode apostar entre 0.00  e "+money+".\nSão as regras do jogo.");
    }
}
