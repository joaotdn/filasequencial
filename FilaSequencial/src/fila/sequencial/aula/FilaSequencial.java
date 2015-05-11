package fila.sequencial.aula;

public class FilaSequencial {
	String dados[] = new String[100];
	int inicio = 0;
	int fim = 1;
	int total = 0;
	
	boolean isCheia() {
		return (total == dados.length);
	}
	
	boolean isVazia() {
		return (total == 0);
	}
	
	boolean inserir(String valor) {
		if(isCheia()) return false;
		
		total++;
		fim = (fim + 1) % dados.length;
		dados[fim] = valor;
		return true;
	}
	
	String remover() {
		if(isVazia()) return null;
		
		String n = dados[inicio];
		total--;
		dados[inicio] = null;
		inicio = (inicio + 1) % dados.length;
		
		return n;
	}
	
	public void mostraFila() {
		if(isVazia()) {
			System.out.println("Fila vazia");
			return;
		}
		
		for(int i = inicio; i != fim + 1; i = (i + 1) % dados.length) {
			System.out.println(dados[i]);
		}
	}
	
	public static void main(String[] args) {
		FilaSequencial fila = new FilaSequencial();
		fila.inserir("Aluno 1");
		fila.inserir("Aluno 2");
		fila.inserir("Aluno 3");
		fila.inserir("Aluno 4");
		
		fila.mostraFila();
	}
}
