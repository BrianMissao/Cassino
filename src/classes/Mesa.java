package classes;

import java.util.Random;
import java.util.Scanner;

public class Mesa {
    private Jogador jogador;
    private Carta sorteada;
    private int turno;

    public Mesa(Jogador jogador) {
        this.jogador = jogador;
    }

    public void turno() {
        Scanner teclado = new Scanner(System.in);
        turno++;
        sortearCarta();
        System.out.println("Rodada "+turno+".\nVocê tirou "+getSorteada().getValorString()+".\nA próxima carta será mais alta ou baixa?");
        while (true){
            System.out.println("Quanto dinheiro você aposta?\nNo máximo "+jogador.getMoney()+".");
            if (teclado.nextLine().equals("s")) {
                mostrarValorDeJogadorNaMesa();
                continue;
            }
        }
    }
    private void sortearCarta() {
        Random random = new Random();
        sorteada = new Carta(random.nextInt(14));
    }

    private Carta getSorteada() {
        return sorteada;
    }
    public String mostrarValorDeJogadorNaMesa() {
        return "Você tem "+jogador.getMoney()+" na mesa agora.";
    }
}
