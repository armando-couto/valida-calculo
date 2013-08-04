package br.com.validacalculo.domain;

import java.io.Serializable;

/**
 * @author armandocouto
 * @email coutoarmando@gmail.com
 * @date 03/08/2013
 */
public class Resposta implements Serializable {

	/**
	 * Serial UID.
	 */
	private static final long serialVersionUID = 7711762084208392015L;

	private Integer numero;
	
	private Regra regra;
	
	private Character correto;
	
	public Resposta() {}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Resposta [numero=");
		builder.append(numero);
		builder.append(", regra=");
		builder.append(regra);
		builder.append(", correto=");
		builder.append(correto);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((correto == null) ? 0 : correto.hashCode());
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		result = prime * result + ((regra == null) ? 0 : regra.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Resposta other = (Resposta) obj;
		if (correto == null) {
			if (other.correto != null)
				return false;
		} else if (!correto.equals(other.correto))
			return false;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		if (regra == null) {
			if (other.regra != null)
				return false;
		} else if (!regra.equals(other.regra))
			return false;
		return true;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Regra getRegra() {
		return regra;
	}

	public void setRegra(Regra regra) {
		this.regra = regra;
	}

	public Character getCorreto() {
		return correto;
	}

	public void setCorreto(Character correto) {
		this.correto = correto;
	}
}