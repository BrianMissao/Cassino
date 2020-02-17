package classes;

import java.util.Random;

public class Jogo {
    private Jogador jogador;
    private Carta primeiraCarta;
    private Carta segundaCarta;
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
            apostarEmCartaAlta(aposta, altoOuBaixa.equals("a"));
        } else {
            apostarEmCartaBaixa(aposta);
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
        segundaCarta = sortearUmaCarta();
    }

    void sortearCarta() {
        primeiraCarta = sortearUmaCarta();
    }

    Carta getPrimeiraCarta() {
        return primeiraCarta;
    }

    Carta getSegundaCarta() {
        return segundaCarta;
    }

    private void apostarEmCartaBaixa(double aposta) throws RuntimeException, NumberFormatException {
        if (getSegundaCarta().getValor() < getPrimeiraCarta().getValor()) {
            executarApostaGanha(aposta);
        } else {
            executarApostaPerdida(aposta);
        }
    }

    private void apostarEmCartaAlta(double aposta, boolean apostadorApostouEmCartaAlta) {
        boolean apostaEmCartaAlta = apostadorApostouEmCartaAlta && segundaCarta.getValor() > primeiraCarta.getValor();
        boolean apostaEmCartaBaixa = !apostadorApostouEmCartaAlta && primeiraCarta.getValor() > segundaCarta.getValor();
        if (apostaEmCartaAlta || apostaEmCartaBaixa) {
            executarApostaGanha(aposta);
        } else {
            executarApostaPerdida(aposta);
        }
    }

    private void executarApostaPerdida(double aposta) {
        jogador.perder(aposta);
        System.out.println("Você perdeu.\nA outra carta era " + getPrimeiraCarta().name() + ".\nVocê tem agora " + jogador.getMoney() + " reais.");
    }

    private void executarApostaGanha(double aposta) {
        jogador.ganhar(aposta);
        System.out.println("Você ganhou.\nA outra carta era " + getSegundaCarta().name() + ".\nVocê tem agora " + jogador.getMoney() + " reais.");
    }

    public void atualizaTurno() {
        turno++;
    }

    private Carta sortearUmaCarta() {
        Random random = new Random();
        int posicaoDaCarta = random.nextInt(14);
        return Carta.values()[posicaoDaCarta];
    }

    private int sortearValorDaCarta() {
        Random random = new Random();
        return random.ints(1, 14).findFirst().getAsInt();
    }
}
