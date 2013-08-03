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
public class Regra implements Serializable {

	/**
	 * Serial UID.
	 */
	private static final long serialVersionUID = -3019410088437782546L;

	private Integer codigo;
	
	private Operacao operacao;
	
	private Classificacao classificacao;
	
	private BigDecimal aliquota;

	public Regra() {}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Regra [codigo=");
		builder.append(codigo);
		builder.append(", operacao=");
		builder.append(operacao);
		builder.append(", classificacao=");
		builder.append(classificacao);
		builder.append(", aliquota=");
		builder.append(aliquota);
		builder.append("]");
		return builder.toString();
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((codigo == null) ? 0 : codigo.hashCode());
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
		Regra other = (Regra) obj;
		if (codigo == null) {
			if (other.codigo != null)
				return false;
		} else if (!codigo.equals(other.codigo))
			return false;
		return true;
	}

	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
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

	public BigDecimal getAliquota() {
		return aliquota;
	}

	public void setAliquota(BigDecimal aliquota) {
		this.aliquota = aliquota;
	}
}