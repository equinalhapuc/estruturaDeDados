
public class Arvore {
	private No raiz;
	
	public void insere(Integer valor) {
		insere(raiz, valor);
	}
	
	public void insere(No no, Integer valor) {
		if (no == null) {
			this.raiz = new No(valor);
		}
		
		else if (valor > no.getValor()) {
			if (no.getDireita() == null) {
				no.setDireita(new No(valor));
			}
			else {
				insere(no.getDireita(), valor);
			}
		}
		
		else {
			if (no.getEsquerda() == null) {
				no.setEsquerda(new No(valor));
			}
			else {
				insere(no.getEsquerda(), valor);
			}
		}
	}
	
	public void preOrdem() {
		System.out.print("[ ");
		preOrdem(raiz);
		System.out.println("]");
	}
	
	public void preOrdem(No no) {
		if (no != null) {
			System.out.print(no.getValor() + " ");
			preOrdem(no.getEsquerda());
			preOrdem(no.getDireita());
		}
	}
	
	public void inOrdem() {
		System.out.print("[ ");
		inOrdem(raiz);
		System.out.println("]");
	}
	
	public void inOrdem(No no) {
		if (no != null) {
			inOrdem(no.getEsquerda());
			System.out.print(no.getValor() + " ");
			inOrdem(no.getDireita());
		}
	}
	
	public void posOrdem() {
		System.out.print("[ ");
		posOrdem(raiz);
		System.out.println("]");
	}
	
	public void posOrdem(No no) {
		if (no != null) {
			posOrdem(no.getEsquerda());
			posOrdem(no.getDireita());
			System.out.print(no.getValor() + " ");
		}
	}
}
