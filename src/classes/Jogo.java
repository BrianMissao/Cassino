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
        if (aposta > jogador.getMoney() || aposta == 0) {
            throw new ExcecaoDeApostaInvalida(jogador.getMoney());
        }
        if (altoOuBaixa.equals("a")) {
            apostarEmCartaAlta(aposta, altoOuBaixa.equals("a"));
        } else {
            apostarEmCartaBaixa(aposta);
        }
    }

    void definirResultadoJogo() {
        if (jogador.getMoney() >= 1000000.00) {
            jogador.ganharJogo();
            System.out.println("O recorde anterior era de Brian que começou com 30000 e conseguiu chegar a 10000000 em 180 jogadas.\nVocê conseguiu chegar a " + jogador.getMoney() + " em " + (getTurno()-1) + " jogadas.");
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

    private void apostarEmCartaBaixa(double aposta) {
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
        System.out.println("Você perdeu.\nA outra carta era " + getSegundaCarta().getNome() + ".\nVocê tem agora " + jogador.getMoney() + " reais.");
    }

    private void executarApostaGanha(double aposta) {
        jogador.ganhar(aposta);
        System.out.println("Você ganhou.\nA outra carta era " + getSegundaCarta().getNome() + ".\nVocê tem agora " + jogador.getMoney() + " reais.");
    }

    public void atualizarTurno() {
        turno++;
    }

    private Carta sortearUmaCarta() {
        Random random = new Random();
        int posicaoDaCarta = random.nextInt(13);
        return Carta.values()[posicaoDaCarta];
    }
}
