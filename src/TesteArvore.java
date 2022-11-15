import java.util.Scanner;

public class TesteArvore {

	public static void main(String[] args) {
		Integer valorDigitado = null;
		Arvore arvore = new Arvore();

		Scanner sc = new Scanner(System.in);
		
		while(true) {
			System.out.print("Digite o valor a ser inserido na árvore [ENTER] para sair: ");
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
		
		while(true) {
			System.out.println("\n\nComo deseja visualizar a árvore? [ENTER] para sair: ");
			System.out.print("\t1-Pré-Ordem\n\t2-In-Ordem\n\t3-Pós-Ordem\n\t4-Remover um valor\n\nDigite uma opção: ");
			String text = sc.nextLine();
		    try {
		    	valorDigitado = Integer.parseInt(text);
		    	switch(valorDigitado) {
		    	case 1:
		    		arvore.preOrdem();
		    		continue;
		    	case 2:
		    		arvore.inOrdem();
		    		continue;
		    	case 3:
		    		arvore.posOrdem();
		    		continue;
		    	case 4:
		    		while(true) {
		    			System.out.print("Digite o valor: ");
		    			text = sc.nextLine();
		    		    try {
		    		    	valorDigitado = Integer.parseInt(text);
		    		    	arvore.remove(valorDigitado);
		    		    } catch (NumberFormatException exp) {
		    		        if (text.isEmpty()) {
		    		            break;
		    		        } else {
		    		            System.out.println(text + " não é um inteiro");
		    		            continue;
		    		        }
		    		    }
		    		}
		    		continue;
		    	default:
		    		break;
		    	}
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

	}

}
