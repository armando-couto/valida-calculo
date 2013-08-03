package br.com.validacalculo.util;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFileChooser;

import br.com.validacalculo.constant.Classificacao;
import br.com.validacalculo.constant.Operacao;
import br.com.validacalculo.domain.NotaFiscal;
import br.com.validacalculo.domain.Regra;

/**
 * @author armandocouto
 * @email coutoarmando@gmail.com
 * @date 03/08/2013
 */
public class ArquivoUtil implements Serializable {

	/**
	 * Serial UID.
	 */
	private static final long serialVersionUID = -6378624772541574133L;

	private List<NotaFiscal> notasFiscais;
	private List<Regra> regras;
	private JFileChooser chooser;
	private FileReader fr;
	private BufferedReader br;
	private String[] colunas;
	private NotaFiscal notaFiscal;
	private Regra regra;

	public ArquivoUtil() {
		chooser = new JFileChooser();
		notasFiscais = new ArrayList<NotaFiscal>();
		regras = new ArrayList<Regra>();
	}

	public List<NotaFiscal> lerArquivoEntrada() {
		this.abrirArquivo();
		if (chooser.showOpenDialog(null) == 0) {
			try {
				fr = new FileReader(chooser.getSelectedFile());
				br = new BufferedReader(fr);

				while (br.ready()) {
					colunas = br.readLine().split(",");
					notaFiscal = new NotaFiscal();
					notaFiscal.setNumero(Integer.parseInt(colunas[0]));
					notaFiscal.setOperacao(Operacao.valueOf(colunas[1]));
					notaFiscal.setClassificacao(Classificacao.valueOf(colunas[2]));
					notaFiscal.setValor(BigDecimal.valueOf(Double.valueOf(colunas[3])));
					notaFiscal.setValorImposto(BigDecimal.valueOf(Double.valueOf(colunas[4])));
					notasFiscais.add(notaFiscal);
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return notasFiscais;
	}

	public List<Regra> lerArquivoRegra() {
		this.abrirArquivo();
		if (chooser.showOpenDialog(null) == 0) {
			try {
				fr = new FileReader(chooser.getSelectedFile());
				br = new BufferedReader(fr);
				while (br.ready()) {
					colunas = br.readLine().split(",");
					regra = new Regra();
					regra.setCodigo(Integer.parseInt(colunas[0]));
					if(colunas[1].equals("*"))
						regra.setOperacao(Operacao.OUTRO);
					else
						regra.setOperacao(Operacao.valueOf(colunas[1]));
					if(colunas[2].equals("*"))
						regra.setClassificacao(Classificacao.OUTRO);
					else
					regra.setClassificacao(Classificacao.valueOf(colunas[2]));
					regra.setAliquota(BigDecimal.valueOf(Double.valueOf(colunas[3])));
					regras.add(regra);
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		return regras;
	}

	private void abrirArquivo() {
		// Diretório raiz.
		chooser.setCurrentDirectory(new File("C:" + File.separator));
		// restringe a amostra a diretorios apenas.
		chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
		// Permite selecionar vários arquivos.
		chooser.setMultiSelectionEnabled(false);
	}
}