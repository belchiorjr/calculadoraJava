package br.com.belchiorjr.calc.visao;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;

import javax.swing.JLabel;
import javax.swing.JPanel;

import br.com.belchiorjr.calc.modelo.Memoria;
import br.com.belchiorjr.calc.modelo.MemoriaObservador;

@SuppressWarnings("serial")
public class Display extends JPanel implements MemoriaObservador {

	private JLabel label;
	
	public Display() {
		
		//Registrar a classe atual no observer 
		Memoria.getInstancia().adicionarObservador(this);
		
		setBackground(new Color(46, 49, 50));
		label = new JLabel(Memoria.getInstancia().getTextoAtual());
		label.setForeground(Color.WHITE);
		label.setFont(new Font("courier", Font.PLAIN, 30));
		
		setLayout(new FlowLayout(FlowLayout.RIGHT, 10, 20));
		add(label);
	}

	@Override
	public void valorAlterado(String novoValor) {
		label.setText(novoValor);
	}
}
