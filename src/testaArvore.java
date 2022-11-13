import java.util.Scanner;

public class testaArvore {

	public static void main(String[] args) {
		Integer valorDigitado = null;
		Arvore arvore = new Arvore();

		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.print("Digite o valor a ser inserido na árvore: ");
			String text = sc.nextLine();
		    try {
		    	valorDigitado = Integer.parseInt(text);
		    	arvore.insere(valorDigitado);
		    } catch (NumberFormatException exp) {
		        if (text.isEmpty()) {
		            break;
		        } else {
		            System.out.println(text + " não é um inteiro");
		            continue;
		        }
		    }
		}
		
		sc.close();
		
		arvore.preOrdem();
		arvore.inOrdem();
		arvore.posOrdem();
	}

}
