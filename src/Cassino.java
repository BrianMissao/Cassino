import classes.Jogador;
import classes.Mesa;

import java.util.Scanner;

public class Cassino {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        System.out.println("Bem-vindo ao cassino da fortuna!\nOlá, com quem tenho o prazer de jogar?");
        String nomeJogador = teclado.nextLine();
        Jogador jogador = new Jogador(nomeJogador);
        Mesa mesa = new Mesa(jogador);
        mesa.turno();
    }
}
