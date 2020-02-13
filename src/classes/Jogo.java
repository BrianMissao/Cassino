package classes;

import java.util.Random;

public class Jogo {
    private Jogador jogador;
    private Carta sorteada;
    private Carta proximaSorteada;
    private int turno;

    public Jogo(Jogador jogador) {
        this.jogador = jogador;
        this.turno = 1;
    }

    double getMoneyJogador() {
        return jogador.getMoney();
    }
    int getTurno() {
        return turno;
    }

    void apostar(String altoOuBaixa, double aposta) {
        if (altoOuBaixa.equals("a")) {
            usuarioAchaQueACartaEhAlta(aposta);
        } else {
            usuarioAchaQueACartaEhBaixa(aposta);
        }
    }

    void definirResultadoJogo() {
        if (jogador.getMoney() >= 1000000.00) {
            jogador.ganharJogo();
        } else {
            jogador.perderJogo();
        }
    }

    void sortearProximaCarta() {
        Random random = new Random();
        proximaSorteada = new Carta(random.nextInt(14));
    }

    void sortearCarta() {
        Random random = new Random();
        sorteada = new Carta(random.nextInt(14));
    }

    Carta getSorteada() {
        return sorteada;
    }

    Carta getProximaSorteada() {
        return proximaSorteada;
    }

    private void usuarioAchaQueACartaEhBaixa(double aposta) throws RuntimeException, NumberFormatException {
        if (getProximaSorteada().getValorInt() < getSorteada().getValorInt()) {
            jogador.ganhar(aposta);
            System.out.println("Você ganhou.\nA outra carta era " + getProximaSorteada().getValorString() + ".\nVocê tem agora " + jogador.getMoney() + " reais.");
        } else {
            jogador.perder(aposta);
            System.out.println("Você perdeu.\nA outra carta era " + getSorteada().getValorString() + ".\nVocê tem agora " + jogador.getMoney() + " reais.");
        }
    }

    private void usuarioAchaQueACartaEhAlta(double aposta) {
        if (getProximaSorteada().getValorInt() > getSorteada().getValorInt()) {
            jogador.ganhar(aposta);
            System.out.println("Você ganhou.\nA outra carta era " + getProximaSorteada().getValorString() + ".\nVocê tem agora " + jogador.getMoney() + " reais.");
        } else {
            jogador.perder(aposta);
            System.out.println("Você perdeu.\nA outra carta era " + getSorteada().getValorString() + ".\nVocê tem agora " + jogador.getMoney() + " reais.");
        }
    }

    public void atualizaTurno() {
        turno ++;
    }
}
