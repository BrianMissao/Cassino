import classes.Jogador;
import classes.Jogo;
import classes.Mesa;

import java.util.Scanner;

public class Cassino {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Bem-vindo ao cassino da fortuna!\nOlá, com quem tenho o prazer de jogar?");
        String nomeJogador = teclado.nextLine();
        System.out.println("Muito bem " + nomeJogador + ", vou levá-lo a mesa do jogo de alto ou baixo.");
        Jogador jogador = new Jogador(nomeJogador);
        Jogo jogo = new Jogo(jogador);
        Mesa mesa = new Mesa(jogo);
        mesa.iniciarPartida();
    }
}
