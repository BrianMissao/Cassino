package classes;

import java.util.Scanner;

public class Mesa {
    private Jogo jogo;
    private double aposta;
    private Scanner teclado;
    private String altoOuBaixo;

    public Mesa(Jogo jogo) {
        this.jogo = jogo;
        this.teclado = new Scanner(System.in);
    }

    public void iniciarPartida() {

        jogo.sortearCarta();
        jogo.sortearProximaCarta();
        while (jogo.getMoneyJogador() > 0 && jogo.getMoneyJogador() < 1000000.00) {
            trataRespostasDigitadasPeloUsuario();
            jogo.sortearCarta();
            jogo.sortearProximaCarta();
            jogo.atualizaTurno();
        }
        jogo.definirResultadoJogo();
    }

    private void trataRespostasDigitadasPeloUsuario() {
        while (true) {
            System.out.println("Rodada " + jogo.getTurno() + "\nVocê tirou " + jogo.getPrimeiraCarta().getNome() + ".\nA próxima carta será mais alta ou baixa?");
            altoOuBaixo = teclado.nextLine();
            if (altoOuBaixo.equals("s")) {
                mostrarValorDeJogadorNaMesa();
                continue;
            } else if (altoOuBaixo.equals("abandonar")) {
                sair();
                break;
            } else if (altoOuBaixo.equals("")) {
                continue;
            } else if (altoOuBaixo.equals("a") || altoOuBaixo.equals("b")) {
                obtemETrataApostaDoUsuario();
                break;
            } else {
                System.out.println("Opção inválida.");
                continue;
            }
        }
    }

    private void obtemETrataApostaDoUsuario() {
        while (true) {
            System.out.println("Quanto dinheiro você aposta?\nNo máximo " + jogo.getMoneyJogador() + ".");
            try {
                aposta = Double.parseDouble(teclado.nextLine());
                break;
            } catch (Exception e) {
                System.out.println("Só tecle números, por favor.");
                continue;
            }
        }
        jogo.apostar(altoOuBaixo, aposta);
    }

    private void sair() {
        System.out.println("Ok.\nSaindo...");
        System.exit(0);
    }

    public void mostrarValorDeJogadorNaMesa() {
        System.out.println("Você tem " + jogo.getMoneyJogador() + " reais na mesa agora.");
    }
}
