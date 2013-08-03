package br.com.validacalculo.main;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import br.com.validacalculo.constant.Classificacao;
import br.com.validacalculo.constant.Operacao;
import br.com.validacalculo.domain.NotaFiscal;
import br.com.validacalculo.domain.Regra;
import br.com.validacalculo.domain.Resposta;
import br.com.validacalculo.util.ArquivoUtil;
import br.com.validacalculo.util.ImpostoUtil;

/**
 * @author armandocouto
 * @email coutoarmando@gmail.com
 * @date 03/08/2013
 */
public class Principal implements Serializable {

	/**
	 * Serial UID.
	 */
	private static final long serialVersionUID = 4170667140261994153L;

	private ArquivoUtil arquivoUtil;
	private List<NotaFiscal> notasFiscais;
	private List<Regra> regras;
	private List<Resposta> respostas;
	private Resposta resposta;
	private File file;
	private FileWriter fw;
	private BufferedWriter bw;
	
	public Principal() {
		arquivoUtil = new ArquivoUtil();
		respostas = new ArrayList<Resposta>();
	}
	
	public static void main(String[] args) {
		Principal p = new Principal();
		JOptionPane.showMessageDialog(null, "Selecione o arquivo de entrada.");
		p.notasFiscais = p.arquivoUtil.lerArquivoEntrada();
		JOptionPane.showMessageDialog(null, "Selecione o arquivo de regras.");
		p.regras = p.arquivoUtil.lerArquivoRegra();
		
		for (NotaFiscal nf : p.notasFiscais) {
			for (Regra r : p.regras) {
				if ((nf.getOperacao().equals(r.getOperacao()) || 
						r.getOperacao().equals(Operacao.OUTRO)) &&
					(nf.getClassificacao().equals(r.getClassificacao()) || 
						r.getClassificacao().equals(Classificacao.OUTRO))) {
					p.resposta = new Resposta();
					p.resposta.setNumero(nf.getNumero());
					p.resposta.setRegra(r);
					p.resposta.setCorreto(ImpostoUtil.getInstance().comparar(nf.getValorImposto(), nf.getValor(), r.getAliquota()));
					p.respostas.add(p.resposta);
				}
			}
		}
		
		p.file = new File("saida.txt");
		
		try {
			p.file.createNewFile();
			p.fw = new FileWriter(p.file);
			p.bw = new BufferedWriter(p.fw);
			p.bw.write("NUMERO,REGRA,CORRETO");
			p.bw.newLine();
			for (Resposta r : p.respostas) {
				p.bw.write(r.getNumero()+","+r.getRegra().getCodigo()+","+r.getCorreto());
				p.bw.newLine();
			}
			p.bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
        JOptionPane.showMessageDialog(null, "Arquivo gerado com sucesso.");
	}
}