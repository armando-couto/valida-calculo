package br.com.validacalculo.constant;

/**
 * @author armandocouto
 * @email coutoarmando@gmail.com
 * @date 02/08/2013
 */
public enum Operacao {

	VENDA         (0, "Venda"),
	TRANSFERENCIA (1, "Transferência"),
	DOACAO		  (2, "Doação"),
	OUTRO		  (3, "*");

	private Integer codigo;
	
	private String descricao;

	/**
	 * @param codigo
	 * @param descricao
	 */
	private Operacao(Integer codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}
	
	public Integer getCodigo() {
		return codigo;
	}

	public void setCodigo(Integer codigo) {
		this.codigo = codigo;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
}