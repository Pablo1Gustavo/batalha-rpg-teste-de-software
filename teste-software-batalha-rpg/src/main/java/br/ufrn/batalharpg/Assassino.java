package br.ufrn.batalharpg;

public class Assassino extends Personagem {

    public Assassino(Integer ataque, Integer defesa, Integer velocidade, Integer resistencia) {
        super(ataque, defesa, velocidade, resistencia);
    }

    @Override
    final void checarRegraDeClasse() {
        if (getAtaque() < getVelocidade() || getVelocidade() < getAtaque()) {
            throw new IllegalStateException("Para um Assassino, Ataque e Velocidade devem ser iguais ou empatados.");
        }
        if (getResistencia() > getAtaque() || getResistencia() > getVelocidade() ||
                getDefesa() > getAtaque() || getDefesa() > getVelocidade()) {
            throw new IllegalStateException("Para um Assassino, Resistência e Defesa devem ser menores ou iguais a Ataque e Velocidade.");
        }
    }

}
