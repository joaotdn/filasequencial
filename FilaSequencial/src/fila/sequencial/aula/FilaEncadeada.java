package fila.sequencial.aula;

public class FilaEncadeada {
	No inicio;
	No fim;
	int totalElementos;
	
	boolean isVazia() {
		return (this.totalElementos == 0);
	}
	
	boolean inserir(String valor) {
		if(valor == null)
			return false;
		
		No novo = new No();
		if(this.isVazia())
			this.inicio = novo;
		else
			this.fim.prox = novo;
		
		novo.dado = valor;
		this.fim = novo;
		this.totalElementos++;
		return true;
	}
	
	String remover() {
		if(this.isVazia())
			return null;
		if(this.inicio.equals(this.fim))
			this.fim = null;
		String n = this.inicio.dado;
		this.inicio = this.inicio.prox;
		return n;
	}
	
	void exibir() {
		if(this.totalElementos == 0) {
			System.out.println("Fila vazia");
			return;
		}
		
		No aux = this.inicio;
		int cont = 0;
		while(cont < this.totalElementos && aux != null) {
			System.out.println(aux.dado);
			aux = aux.prox;
			cont++;
		}
	}
	
	void esvaziar() {
		if(this.isVazia()) {
			System.out.println("A fila j‡ est‡ vazia");
			return;
		}
		
		while(this.inicio != null) {
			this.inicio = this.inicio.prox;
			this.totalElementos--;
		}
		
		this.totalElementos--;
		System.out.println("A fila foi esvaziada");
	}
	
	public static void main(String[] args) {
		FilaEncadeada fila = new FilaEncadeada();
		fila.inserir("Joao");
		fila.inserir("Jose");
		fila.inserir("Maria");
		
		fila.exibir();

		System.out.println("-------");
		System.out.println(fila.remover() + " saiu da fila");
		fila.exibir();
		
		System.out.println("-------");
		fila.exibir();
		
		System.out.println("-------");
		fila.esvaziar();
		fila.exibir();
	}
}
