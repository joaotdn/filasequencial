package filas.teste;

public class Encadeada {
	No inicio;
	No fim;
	int totalElementos;
	
	boolean isVazia() {
		return (this.totalElementos == 0);
	}
	
	boolean inserir(String valor) {
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
		
		String valor = this.inicio.dado;
		this.inicio = this.inicio.prox;
		
		this.totalElementos--;
		return valor;
	}
	
	void exibir() {
		if(this.isVazia()) {
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
	
	void esvasiar() {
		if(this.isVazia()) {
			System.out.println("Fila ja vazia");
			return;
		}
		
		while(this.inicio != null) {
			this.inicio = inicio.prox;
			this.totalElementos--;
		}
		
		System.out.println("Fila esvaziada");
	}
	
	public static void main(String[] args) {
		Encadeada fila = new Encadeada();
		fila.inserir("joao");
		fila.inserir("jose");
		fila.inserir("maria");
		fila.inserir("pedro");
		
		fila.exibir();
		
		fila.remover();
		System.out.println("----------");
		fila.exibir();
		
		System.out.println("----------");
		fila.esvasiar();
		fila.exibir();
	}
}
