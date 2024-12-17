package br.ufrn.batalharpg;

public class Main {

    public static void main(String[] args) {
        Personagem p1 = new Assassino(7, 3, 7, 3);
        Personagem p2 = new Guerreiro(7, 3, 3, 7);

        Batalha batalha = new Batalha(p1, p2);

        while (true) {
            batalha.realizarPrimeiroAtaque();

            if (batalha.temVencedor()) {
                break;
            }

            batalha.realizarSegundoAtaque();

            if (batalha.temVencedor()) {
                break;
            }
        }

        Personagem vencedor = batalha.obterVencedor();
        if (vencedor != null) {
            System.out.println("O vencedor é: " + vencedor.getClass().getSimpleName() + " com " + vencedor.getVida() + " vida restante.");
        } else {
            System.out.println("A batalha terminou em empate.");
        }
    }
}