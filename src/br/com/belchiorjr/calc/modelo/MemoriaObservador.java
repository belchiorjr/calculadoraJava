package br.com.belchiorjr.calc.modelo;

/**
 *  Interface para ser utilizado 
 *  o padrão observer, que será 
 *  utilizado no display, observando.
 * 
 * */
public interface MemoriaObservador {
	
	
	public void valorAlterado(String novoValor);
}
