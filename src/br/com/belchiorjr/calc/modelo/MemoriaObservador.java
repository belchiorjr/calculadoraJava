package br.com.belchiorjr.calc.modelo;

/**
 *  Interface para ser utilizado 
 *  o padr�o observer, que ser� 
 *  utilizado no display, observando.
 * 
 * */
public interface MemoriaObservador {
	
	
	public void valorAlterado(String novoValor);
}
