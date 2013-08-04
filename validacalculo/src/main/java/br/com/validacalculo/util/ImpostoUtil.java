package br.com.validacalculo.util;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author armandocouto
 * @email coutoarmando@gmail.com
 * @date 03/08/2013
 */
public class ImpostoUtil implements Serializable {

	/**
	 * Serial UID.
	 */
	private static final long serialVersionUID = 6370866682559058036L;

	private static ImpostoUtil instance;
	
	private BigDecimal porcentagem;

	private ImpostoUtil() {
		porcentagem = new BigDecimal(Double.valueOf(100));
	}

	public static ImpostoUtil getInstance() {
		if (instance == null)
			instance = new ImpostoUtil();
		return instance;
	}

	public Character comparar(BigDecimal valorImposto, BigDecimal valor, BigDecimal aliquota) {
		BigDecimal calculo = valor.multiply(aliquota).divide(porcentagem, 2);
		if(valorImposto.doubleValue() == calculo.doubleValue())
			return 'S';
		else
			return 'N';
	}
}