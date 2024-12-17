package br.ufrn.batalharpg;

public abstract class Personagem {
	private Integer ataque;

	private Integer defesa;

	private Integer velocidade;

	private Integer resistencia;

	private Integer vida;

	Personagem() {
	}

	public Personagem(Integer ataque, Integer defesa, Integer velocidade, Integer resistencia) {
		this.ataque = ataque;
		this.defesa = defesa;
		this.velocidade = velocidade;
		this.resistencia = resistencia;

		checarTotal();
		checarValorMinimo();
		checarRegraDeClasse();

		this.vida = 5 * this.resistencia;
	}

	abstract void checarRegraDeClasse();

	private void checarValorMinimo() {
		checarValorMinimo(ataque);
		checarValorMinimo(defesa);
		checarValorMinimo(velocidade);
		checarValorMinimo(resistencia);
	}

	final void checarValorMinimo(Integer atributo) {
		if (atributo < 3) {
			throw new IllegalStateException("Todos os atributos devem ter pelo menos 3 pontos.");
		}
	}

	final void checarTotal() {
		if (this.ataque + this.defesa + this.velocidade + this.resistencia != 20) {
			throw new IllegalStateException("Somatório dos atributos deve ser igual a 20.");
		}
	}

	public void atacar(Personagem defensor, double modificadorAtaque, boolean eGolpeCritico) {
		int danoBase = this.calcularDanoBase(modificadorAtaque);
		int dano = this.calcularDanoInfringindo(danoBase, defensor.getDefesa(), eGolpeCritico);
		defensor.receberDano(dano);
	}

	int calcularDanoInfringindo(int danoBase, int defesa, boolean eGolpeCritico) {
		int dano = danoBase + this.ataque - defesa;

		if (dano < 1) {
			dano = 1;
		}

		if (eGolpeCritico) {
			dano = (int) Math.round(dano * 1.5);
		}

		return dano;
	}

	private void receberDano(int danoInfringido) {
		this.vida -= danoInfringido;

		if (this.vida < 0) {
			this.vida = 0;
		}
	}

	public int calcularDanoBase(double modificadorAtaque) {
		if (modificadorAtaque < 0.8 || modificadorAtaque >= 1.2) {
			throw new IllegalArgumentException(
					"Modificador de ataque deve estar entre 0.8 (inclusive) e 1.2 (exclusive).");
		}
		double danoBase = this.ataque * modificadorAtaque;

		return (int) Math.round(danoBase);
	}

	public Integer getAtaque() {
		return ataque;
	}

	void setAtaque(Integer ataque) {
		this.ataque = ataque;
	}

	public Integer getDefesa() {
		return defesa;
	}

	void setDefesa(Integer defesa) {
		this.defesa = defesa;
	}

	public Integer getVelocidade() {
		return velocidade;
	}

	void setVelocidade(Integer velocidade) {
		this.velocidade = velocidade;
	}

	public Integer getResistencia() {
		return resistencia;
	}

	void setResistencia(Integer resistencia) {
		this.resistencia = resistencia;
	}

	public Integer getVida() {
		return vida;
	}

	public void setVida(Integer vida) {
		this.vida = vida;
	}
}
