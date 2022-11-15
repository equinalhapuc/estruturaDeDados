
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
			} else {
				insere(no.getDireita(), valor);
			}
		}

		else {
			if (no.getEsquerda() == null) {
				no.setEsquerda(new No(valor));
			} else {
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

	public No remove(Integer valor) {
		No balaceado = remove(raiz, valor, null);
		return balaceado;
	}

	public No remove(No no, Integer valor, No pai) {
		// Somente executa o código se o nó recebido for diferente de nulo
		if (no != null) {
			// Se o nó atual corresponde ao valor que se deseja remover
			if (no.getValor() == valor) {
				// Se o nó a ser removido for um nó folha
				if (no.getDireita() == null && no.getEsquerda() == null) {
					
					if (pai == null) {
						this.raiz = null;
						
					} else if(valor >= pai.getValor()) {
						pai.setDireita(null);
						
					} else {
						pai.setEsquerda(null);
					}
					// Se o nó a ser removido tiver apenas um filho a direita
				} else if (no.getEsquerda() == null) {
					
					if (valor >= pai.getValor()) {
						pai.setDireita(no.getDireita());
						
					} else {
						pai.setEsquerda(no.getDireita());
					}
					// Se o nó a ser removido tiver apenas um filho a esquerda
				} else if (no.getDireita() == null) {
					
					if (valor >= pai.getValor()) {
						pai.setDireita(no.getEsquerda());
						
					} else {
						pai.setEsquerda(no.getEsquerda());
					}
					// Se o nó a ser removido tiver dois filhos
				} else {
					int maior = maiorEsquerda(no).getValor();
					int noRemover = remove(maior).getValor();
					no.setValor(noRemover);
				}
				return no;
			} else if (valor > no.getValor()) {
				remove(no.getDireita(), valor, no);

			} else if (valor < no.getValor()) {
				remove(no.getEsquerda(), valor, no);
			}
		}
		return null;
	}
	
	private No maiorEsquerda(No no) {
		if (no.getEsquerda() != null) {
			no = no.getEsquerda();
			while (no.getDireita() != null) {
				no = no.getDireita();
			}
		}
		return no;
	}
}
