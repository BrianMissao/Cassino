package classes;

import java.util.Random;
import java.util.Scanner;

public class Mesa {
    private Jogador jogador;
    private Carta sorteada;
    private Carta proximaSorteada;
    private int turno;
    private double aposta;
    private Scanner teclado = new Scanner(System.in);

    public Mesa(Jogador jogador) {
        this.jogador = jogador;
        this.turno = 1;
    }

    public void turno() {
        sortearCarta();
        sortearProximaCarta();

        while (jogador.getMoney() > 0 && jogador.getMoney() < 1000000.00) {
            System.out.println("Rodada "+turno+"\nVocê tirou "+getSorteada().getValorString()+".");
            System.out.println("A próxima carta será mais alta ou baixa?");
            switch (teclado.nextLine()) {
                case "s":
                    mostrarValorDeJogadorNaMesa();
                    continue;
                case "":
                    continue;
                case "a":
                    usuarioAchaQueACartaEhAlta();
                break;
                case "b":
                    usuarioAchaQueACartaEhBaixa();
                    break;
                default:
                    System.out.println("Opção inválida.");
                    continue;
            }
            sortearCarta();
            sortearProximaCarta();
            turno++;
        }
        if (jogador.getMoney() >= 1000000.00) {
            jogador.ganharJogo();
        }
        else {
            jogador.perderJogo();
        }
    }
    private void usuarioAchaQueACartaEhBaixa() throws RuntimeException, NumberFormatException {
        while (true) {
            System.out.println("Quanto dinheiro você aposta?\nNo máximo " + jogador.getMoney() + ".");
            String respostaUsuario = teclado.nextLine();
            if (respostaUsuario.equals("s") || respostaUsuario.equals("")) {
                mostrarValorDeJogadorNaMesa();
                continue;
            }
            try {
                aposta = Double.parseDouble(respostaUsuario);
                break;
            } catch (NumberFormatException e) {
                System.out.println("Só tecle números, por favor.");
                continue;
            }
        }
        if (getProximaSorteada().getValorInt() < getSorteada().getValorInt()) {
            jogador.ganhar(aposta);
            System.out.println("Você ganhou.\nA outra carta era " + getProximaSorteada().getValorString() + ".\nVocê tem agora " + jogador.getMoney() + ".");
        } else {
            jogador.perder(aposta);
            System.out.println("Você perdeu.\nA outra carta era " + getSorteada().getValorString() + ".\nVocê tem agora " + jogador.getMoney() + ".");
        }
    }

    private void usuarioAchaQueACartaEhAlta() {
        while (true) {
            System.out.println("Quanto dinheiro você aposta?\nNo máximo " + jogador.getMoney() + ".");
            String respostaUsuario = teclado.nextLine();
            if (respostaUsuario.equals("s") || respostaUsuario.equals("")) {
                mostrarValorDeJogadorNaMesa();
                continue;
            }
            try {
                aposta = Double.parseDouble(respostaUsuario);
                break;
            } catch (Exception e) {
                System.out.println("Só tecle números, por favor.");
                continue;
            }
        }
        if (getProximaSorteada().getValorInt() > getSorteada().getValorInt()) {
            jogador.ganhar(aposta);
            System.out.println("Você ganhou.\nA outra carta era " + getProximaSorteada().getValorString() + ".\nVocê tem agora " + jogador.getMoney() + ".");
        } else {
            jogador.perder(aposta);
            System.out.println("Você perdeu.\nA outra carta era " + getSorteada().getValorString() + ".\nVocê tem agora " + jogador.getMoney() + ".");
        }
    }

    private void sortearProximaCarta() {
        Random random = new Random();
        proximaSorteada = new Carta(random.nextInt(14));
    }

    private void sortearCarta() {
        Random random = new Random();
        sorteada = new Carta(random.nextInt(14));
    }

    private Carta getSorteada() {
        return sorteada;
    }

    public void mostrarValorDeJogadorNaMesa() {
        System.out.println("Você tem " + jogador.getMoney() + " na mesa agora.");
    }

    private Carta getProximaSorteada() {
        return proximaSorteada;
    }
}
