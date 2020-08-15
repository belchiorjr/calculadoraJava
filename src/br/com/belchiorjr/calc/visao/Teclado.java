package br.com.belchiorjr.calc.visao;

import java.awt.Color;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

import br.com.belchiorjr.calc.modelo.Memoria;

@SuppressWarnings("serial")
public class Teclado extends JPanel implements ActionListener {

	private final Color COR_CINZA_ESCURO = new Color(68,68,68);
	private final Color COR_CINZA_CLARO = new Color(99,99,99);
	private final Color COR_LARANJA = new Color(242,163,60);

	
	public Teclado() {

		GridBagLayout layout = new GridBagLayout();
		GridBagConstraints c = new GridBagConstraints();
		
		setLayout(layout);
		c.weightx= 1;
		c.weighty= 1;
		c.fill = GridBagConstraints.BOTH;
		
		
		c.gridwidth = 2;
		adicionarBotao("AC", COR_CINZA_ESCURO, c, 0,0);
		c.gridwidth = 1;
		adicionarBotao("±", COR_CINZA_ESCURO, c, 0,2);
		//adicionarBotao("%", COR_CINZA_ESCURO, c, 0,2);
		
		adicionarBotao("/", COR_LARANJA, c, 0,3);
		
		adicionarBotao("7", COR_CINZA_CLARO, c, 1,0);
		adicionarBotao("8", COR_CINZA_CLARO, c, 1,1);
		adicionarBotao("9", COR_CINZA_CLARO, c, 1,2);
		adicionarBotao("*", COR_LARANJA, c, 1,3);
		
		adicionarBotao("4", COR_CINZA_CLARO, c, 2,0);
		adicionarBotao("5", COR_CINZA_CLARO, c, 2,1);
		adicionarBotao("6", COR_CINZA_CLARO, c, 2,2);
		adicionarBotao("-", COR_LARANJA, c, 2,3);
		
		adicionarBotao("1", COR_CINZA_CLARO, c, 3,0);
		adicionarBotao("2", COR_CINZA_CLARO, c, 3,1);
		adicionarBotao("3", COR_CINZA_CLARO, c, 3,2);
		adicionarBotao("+", COR_LARANJA , c, 3,3);
		
		c.gridwidth = 2;
		adicionarBotao("0", COR_CINZA_CLARO, c, 4,0);
		
		c.gridwidth = 1;
		adicionarBotao("0", COR_CINZA_CLARO, c, 4,1);
		adicionarBotao(",", COR_CINZA_CLARO, c, 4,2);
		adicionarBotao("=", COR_LARANJA , c, 4,3);
	}


	private void adicionarBotao(String texto, Color cor, GridBagConstraints c, int y, int x) {
		c.gridy = y;
		c.gridx = x;
		Botao botao = new Botao(texto, cor);
		add(botao, c);
		
		// Registra o botao com o evento click
		botao.addActionListener(this);
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		// Acessa o Botão que foi clicado.
		if (e.getSource() instanceof JButton) {
			JButton botao = (JButton) e.getSource();
			
			// Após o clicado o botão o valor é passado para a memória
			// E o evento de alteração de informação do texto é avisado a display
			Memoria.getInstancia().processarComando(botao.getText());
			//System.out.println("Print no btn" + botao.getText());
		}
	}
}
