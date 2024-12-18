package br.ufrn.batalharpg;

public class Assassino extends Personagem
{
    public Assassino(Integer ataque, Integer defesa, Integer velocidade, Integer resistencia)
    {
        super(ataque, defesa, velocidade, resistencia);
    }

    @Override
    final void checarRegraDeClasse()
    {
        if (this.velocidade != this.ataque) {
            throw new IllegalStateException("Para um Assassino, Velocidade e Ataque devem ser iguais ou empatados.");
        }
        if (
            this.resistencia > this.velocidade || this.resistencia > this.ataque ||
            this.defesa > this.velocidade || this.defesa > this.ataque
        ) {
            throw new IllegalStateException("Para um Assassino, Resistência e Defesa não podem exceder Velocidade ou Ataque.");
        }
    }
}
