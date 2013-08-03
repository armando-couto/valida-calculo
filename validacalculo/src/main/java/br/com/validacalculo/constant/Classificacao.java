package br.com.validacalculo.constant;

/**
 * @author armandocouto
 * @email coutoarmando@gmail.com
 * @date 02/08/2013
 */
public enum Classificacao {

	A 	  (0, "A"),
	B 	  (1, "B"),
	C 	  (2, "C"),
	D 	  (3, "D"),
	OUTRO (4, "*");

	private Integer codigo;
	
	private String descricao;

	/**
	 * @param codigo
	 * @param descricao
	 */
	private Classificacao(Integer codigo, String descricao) {
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