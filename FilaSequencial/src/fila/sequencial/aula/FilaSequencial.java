package fila.sequencial.aula;

public class FilaSequencial {
	String vetor[] = new String[100];
	int inicio = 0;
	int fim = -1;
	int total = 0;
	
	boolean isVazia() {
		return (this.total == 0);
	}
	
	boolean isCheia() {
		return (this.total == this.vetor.length);
	}
	
	boolean inserir(String dado) {
		if(this.isCheia())
			return false;
		
		this.fim = (this.fim + 1) % this.vetor.length;
		this.vetor[fim] = dado;
		this.total++;
		return true;
	}
	
	String remover() {
		if(this.isVazia())
			return null;
		
		String v = this.vetor[inicio];
		this.vetor[this.inicio] = null;
		this.inicio = (this.inicio + 1) % this.vetor.length;
		
		this.total--;
		return v;
	}
	
	void exibir() {
		if(this.isVazia()) {
			System.out.println("Fila vazia");
			return;
		}
		
		for(int i = this.inicio; i != this.fim + 1; i = (i + 1) % this.vetor.length) {
			System.out.println(this.vetor[i]);
		}
	}
	
	void esvaziar() {
		if(this.isVazia()) {
			System.out.println("A fila j‡ estava vazia");
			return;
		}
		
		for(int i = this.inicio; i != this.fim + 1; i = (i + 1) % this.vetor.length) {
			this.vetor[i] = null;
			this.total--;
		}
		System.out.println("A fila foi esvaziada");
	}
	
	public static void main(String[] args) {
		FilaEncadeada fila = new FilaEncadeada();
		fila.inserir("joao");
		fila.inserir("jose");
		fila.inserir("maria");
		fila.inserir("pedro");
		fila.inserir("joyce");
		
		fila.exibir();
		System.out.println("----------");
		System.out.println(fila.remover() + " saiu da fila");
		fila.exibir();
		
		System.out.println("----------");
		fila.exibir();
		
		System.out.println("----------");
		fila.esvaziar();
		fila.exibir();
	}
}
