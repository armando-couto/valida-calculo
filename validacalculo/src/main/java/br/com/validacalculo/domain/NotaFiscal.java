package br.com.validacalculo.domain;

import java.io.Serializable;
import java.math.BigDecimal;

import br.com.validacalculo.constant.Classificacao;
import br.com.validacalculo.constant.Operacao;

/**
 * @author armandocouto
 * @email coutoarmando@gmail.com
 * @date 02/08/2013
 */
public class NotaFiscal implements Serializable {

	/**
	 * Serial UID.
	 */
	private static final long serialVersionUID = 1955043568607319492L;

	private Integer numero;
	
	private Operacao operacao;
	
	private Classificacao classificacao;
	
	private BigDecimal valor;
	
	private BigDecimal valorImposto;
	
	public NotaFiscal() {}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("NotaFiscal [numero=");
		builder.append(numero);
		builder.append(", operacao=");
		builder.append(operacao);
		builder.append(", classificacao=");
		builder.append(classificacao);
		builder.append(", valor=");
		builder.append(valor);
		builder.append(", valorImposto=");
		builder.append(valorImposto);
		builder.append("]");
		return builder.toString();
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#hashCode()
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((numero == null) ? 0 : numero.hashCode());
		return result;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		NotaFiscal other = (NotaFiscal) obj;
		if (numero == null) {
			if (other.numero != null)
				return false;
		} else if (!numero.equals(other.numero))
			return false;
		return true;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Operacao getOperacao() {
		return operacao;
	}

	public void setOperacao(Operacao operacao) {
		this.operacao = operacao;
	}

	public Classificacao getClassificacao() {
		return classificacao;
	}

	public void setClassificacao(Classificacao classificacao) {
		this.classificacao = classificacao;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public BigDecimal getValorImposto() {
		return valorImposto;
	}

	public void setValorImposto(BigDecimal valorImposto) {
		this.valorImposto = valorImposto;
	}
}