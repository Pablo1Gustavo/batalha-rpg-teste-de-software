package br.ufrn.batalharpg;

public class Guerreiro extends Personagem {

    public Guerreiro(Integer ataque, Integer defesa, Integer velocidade, Integer resistencia) {
        super(ataque, defesa, velocidade, resistencia);
    }

    @Override
    final void checarRegraDeClasse() {
        if (getResistencia() < getAtaque() || getAtaque() < getResistencia()) {
            throw new IllegalStateException("Para um Guerreiro, Resistência e Ataque devem ser iguais ou empatados.");
        }
        if (getDefesa() > getResistencia() || getDefesa() > getAtaque() ||
                getVelocidade() > getResistencia() || getVelocidade() > getAtaque()) {
            throw new IllegalStateException("Para um Guerreiro, Defesa e Velocidade não podem exceder Resistência ou Ataque.");
        }
    }


}
