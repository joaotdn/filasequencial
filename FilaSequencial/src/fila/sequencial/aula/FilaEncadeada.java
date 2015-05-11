package fila.sequencial.aula;

public class FilaEncadeada {
	/**
	 * Caracteristicas:
	 * Referencia para o primeiro
	 *     ||     para o segundo
	 * Info. p/ qtde. de elementos na fila
	 */
	No inicio;
	No fim;
	int qtdeElementos;
	
	boolean isVazia() {
		return (qtdeElementos == 0);
	}
	
	void inserir(String dado) {
		No novo = new No();
		novo.dado = dado;
		
		if(isVazia())
			inicio = novo;
		else
			fim.prox = novo;
		
		fim = novo;
		qtdeElementos++;
	}
	
	String remover() {
		if(isVazia())
			return null;
		String n = inicio.dado;
		if(inicio.equals(fim))
			fim = null;
		inicio = inicio.prox;
		qtdeElementos++;
		return n;
	}
	
	public void exibir() {
		if(isVazia()) {
			System.out.println("Fila vazia");
			return;
		}
		No aux = inicio;
		int i = 0;
		while(i < qtdeElementos && aux != null) {
			System.out.println(aux.dado);
			aux = aux.prox;
			i++;
		}
	}
	
	public void esvaziar() {
		if(isVazia()) {
			System.out.println("Fila vazia");
			return;
		}
		
		No aux = inicio;
		int i = 0;
		while(i < qtdeElementos && aux != null) {
			aux.dado = null;
			aux = aux.prox;
			i++;
			qtdeElementos--;
		}
		
		qtdeElementos--;
		System.out.println("Fila esvaziada");
	}
	
	public static void main(String[] args) {
		FilaEncadeada fila = new FilaEncadeada();
		fila.inserir("Joao");
		fila.inserir("Jose");
		fila.inserir("Maria");
		
		System.out.println(fila.remover() + " saiu da fila");
		
		fila.exibir();
		
		fila.esvaziar();
		fila.exibir();
	}
}
