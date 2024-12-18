package br.ufrn.batalharpg;

public class PersonagemBuilder
{
    private Integer ataque, defesa, velocidade, resistencia;

    public static PersonagemBuilder criar()
    {
        return new PersonagemBuilder();
    }

    public PersonagemBuilder comAtaque(Integer ataque)
    {
        this.ataque = ataque;
        return this;
    }

    public PersonagemBuilder comDefesa(Integer defesa)
    {
        this.defesa = defesa;
        return this;
    }

    public PersonagemBuilder comVelocidade(Integer velocidade)
    {
        this.velocidade = velocidade;
        return this;
    }

    public PersonagemBuilder comResistencia(Integer resistencia)
    {
        this.resistencia = resistencia;
        return this;
    }

    public Assassino doTipoAssassino()
    {
        return new Assassino(ataque, defesa, velocidade, resistencia);
    }

    public Guerreiro doTipoGuerreiro()
    {
        return new Guerreiro(ataque, defesa, velocidade, resistencia);
    }
}

