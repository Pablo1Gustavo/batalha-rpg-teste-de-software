package br.ufrn.batalharpg;

public abstract class Personagem
{
	public static final int TOTAL_ATRIBUTOS_REQUERIDO    = 20;
	public static final int VALOR_MINIMO_ATRIBUTO        = 3;
	public static final int MULTIPLICADOR_VIDA           = 5;
	public static final double MODIFICADOR_ATAQUE_MINIMO = 0.8;
	public static final double MODIFICADOR_ATAQUE_MAXIMO = 1.2;
	
	private Integer ataque, defesa, velocidade, resistencia, vida;

	Personagem() {}

	public Personagem(Integer ataque, Integer defesa, Integer velocidade, Integer resistencia)
	{
		this.ataque = ataque;
		this.defesa = defesa;
		this.velocidade = velocidade;
		this.resistencia = resistencia;
		this.vida = MULTIPLICADOR_VIDA * resistencia;

		checarTotal();
		checarValorMinimo();
		checarRegraDeClasse();
	}

	abstract void checarRegraDeClasse();

	private final void checarValorMinimo()
	{
		if (
			ataque < VALOR_MINIMO_ATRIBUTO ||
			defesa < VALOR_MINIMO_ATRIBUTO ||
			velocidade < VALOR_MINIMO_ATRIBUTO ||
			resistencia < VALOR_MINIMO_ATRIBUTO
		) {
			throw new IllegalStateException(
				String.format(
					"Todos os atributos devem ter pelo menos %d pontos.",
					VALOR_MINIMO_ATRIBUTO
			));
		}
	}

	public final void checarTotal()
	{
		var total = this.ataque + this.defesa + this.velocidade + this.resistencia;
		if (total != TOTAL_ATRIBUTOS_REQUERIDO)
		{
			throw new IllegalStateException("Somatório dos atributos deve ser igual a 20.");
		}
	}

	public void atacar(Personagem defensor, double modificadorAtaque, boolean ehGolpeCritico)
	{
		int danoBase = this.calcularDanoBase(modificadorAtaque);
		int dano = this.calcularDanoInfringindo(danoBase, defensor.getDefesa(), ehGolpeCritico);
		defensor.receberDano(dano);
	}

	int calcularDanoInfringindo(int danoBase, int defesa, boolean eGolpeCritico)
	{
		int dano = Math.max(danoBase + this.ataque - defesa, 1);

		if (eGolpeCritico) {
			dano = (int) Math.round(dano * 1.5);
		}

		return dano;
	}

	private void receberDano(int danoInfringido) 
	{
		this.vida = Math.max(this.vida  - this.resistencia, 0);
	}

	public int calcularDanoBase(double modificadorAtaque)
	{
		boolean modificadorEstaNoIntervalo =
			modificadorAtaque >= MODIFICADOR_ATAQUE_MINIMO &&
			modificadorAtaque <= MODIFICADOR_ATAQUE_MAXIMO;

		if (!modificadorEstaNoIntervalo)
		{
			throw new IllegalArgumentException(
				String.format(
					"Modificador de ataque deve estar entre %.2f (inclusive) e %.2f (exclusive).",
					MODIFICADOR_ATAQUE_MINIMO,
					MODIFICADOR_ATAQUE_MAXIMO
				));
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
