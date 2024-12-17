package br.ufrn.batalharpg;

import static java.lang.Math.min;

import java.security.SecureRandom;

public class Batalha {

	private final Personagem primeiroAtacante;

	private final Personagem segundoAtacante;

	private final SecureRandom geradorRandomico;

	Batalha(Personagem p1, Personagem p2, int randomico) {
		this.geradorRandomico = new SecureRandom();

		if (p1.getVelocidade() > p2.getVelocidade()) {
			this.primeiroAtacante = p1;
			this.segundoAtacante = p2;
		} else if (p1.getVelocidade() < p2.getVelocidade()) {
			this.primeiroAtacante = p2;
			this.segundoAtacante = p1;
		} else {
			if (randomico == 0) {
				this.primeiroAtacante = p1;
				this.segundoAtacante = p2;
			} else {
				this.primeiroAtacante = p2;
				this.segundoAtacante = p1;
			}
		}
	}

	public Batalha(Personagem p1, Personagem p2) {
		this(p1, p2, new SecureRandom().nextInt(2));
	}

	public void realizarPrimeiroAtaque() {
		realizarAtaque(primeiroAtacante, segundoAtacante);
	}

	public void realizarSegundoAtaque() {
		realizarAtaque(segundoAtacante, primeiroAtacante);
	}

	private void realizarAtaque(Personagem atacante, Personagem defensor) {
		int chanceEvasao = calcularChanceEvasao(atacante, defensor);
		int randomicoEvasao = geradorRandomico.nextInt(100);

		if (this.evadiu(chanceEvasao, randomicoEvasao)) {
			System.out.println(atacante.getClass().getSimpleName() + " atacou, mas "
					+ defensor.getClass().getSimpleName() + " evadiu o ataque!");
		} else {
			double modificadorAtaque = 0.8 + (geradorRandomico.nextDouble() * 0.4);
			boolean eGolpeCritico = geradorRandomico.nextInt(100) < 10;

			atacante.atacar(defensor, modificadorAtaque, eGolpeCritico);

			if (eGolpeCritico) {
				System.out.println(atacante.getClass().getSimpleName() + " realizou um golpe crítico!");
			}

			System.out.println(atacante.getClass().getSimpleName() + " atacou " + defensor.getClass().getSimpleName()
					+ " causando " + (eGolpeCritico ? "dano crítico." : "dano normal.") + " Vida restante de "
					+ defensor.getClass().getSimpleName() + ": " + defensor.getVida());
		}
	}

	public Personagem obterVencedor() {
	    if (primeiroAtacante.getVida() > 0 && segundoAtacante.getVida() <= 0) {
	        return primeiroAtacante;
	    } else if (segundoAtacante.getVida() > 0 && primeiroAtacante.getVida() <= 0) {
	        return segundoAtacante;
	    }
	    return null;
	}
	
	boolean evadiu(int chanceEvasao, int randomico) {
		return randomico <= chanceEvasao;
	}

	int calcularChanceEvasao(Personagem atacante, Personagem defensor) {
		return Batalha.calcularChanceEvasao(atacante.getVelocidade(), defensor.getVelocidade());
	}

	static int calcularChanceEvasao(int velocidadeAtacante, int velocidadeDefensor) {
		int chanceEvasao = min(50, (velocidadeDefensor - velocidadeAtacante) * 2);
		return chanceEvasao < 0 ? 0 : chanceEvasao;
	}

	public boolean temVencedor() {
		return primeiroAtacante.getVida() <= 0 || segundoAtacante.getVida() <= 0;
	}

	public Personagem getPrimeiroAtacante() {
		return primeiroAtacante;
	}

	public Personagem getSegundoAtacante() {
		return segundoAtacante;
	}

}
