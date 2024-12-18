package br.ufrn.batalharpg;

public class Guerreiro extends Personagem
{
    public Guerreiro(Integer ataque, Integer defesa, Integer velocidade, Integer resistencia)
    {
        super(ataque, defesa, velocidade, resistencia);
    }

    @Override
    final void checarRegraDeClasse()
    {
        if (this.resistencia != this.ataque)
        {
            throw new IllegalStateException("Para um Guerreiro, Resistência e Ataque devem ser iguais ou empatados.");
        }
        if (
            this.defesa > this.resistencia || this.defesa > this.ataque ||
            this.velocidade > this.resistencia || this.velocidade > this.ataque
        ){
            throw new IllegalStateException("Para um Guerreiro, Defesa e Velocidade não podem exceder Resistência ou Ataque.");
        }
    }
}
