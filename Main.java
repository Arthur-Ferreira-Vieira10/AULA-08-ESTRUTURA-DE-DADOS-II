import java.util.Random;

public class Main {
    public static void main(String[] args) {
        ArvoreBinaria arvore = new ArvoreBinaria();
        Random random = new Random();

        int[] numeros = new int[20];
        System.out.print("Números sorteados: ");
        for (int i = 0; i < 20; i++) {
            numeros[i] = random.nextInt(101);
            System.out.print(numeros[i] + " ");
            arvore.inserir(numeros[i]);
        }
        System.out.println();

        System.out.println("\n--- Pré-ordem ---");
        arvore.preOrdem(arvore.raiz);
        System.out.println();

        System.out.println("\n--- In-ordem ---");
        arvore.inOrdem(arvore.raiz);
        System.out.println();

        System.out.println("\n--- Pós-ordem ---");
        arvore.posOrdem(arvore.raiz);
        System.out.println();

        System.out.println("\n--- Em nível ---");
        arvore.emNivel();
        System.out.println();

        System.out.print("\nNúmeros removidos: ");
        for (int i = 0; i < 5; i++) {
            int indice = random.nextInt(20);
            System.out.print(numeros[indice] + " ");
            arvore.remover(numeros[indice]);
        }
        System.out.println();

        System.out.println("\n--- Pré-ordem após remoções ---");
        arvore.preOrdem(arvore.raiz);
        System.out.println();

        System.out.println("\n--- In-ordem após remoções ---");
        arvore.inOrdem(arvore.raiz);
        System.out.println();

        System.out.println("\n--- Pós-ordem após remoções ---");
        arvore.posOrdem(arvore.raiz);
        System.out.println();

        System.out.println("\n--- Em nível após remoções ---");
        arvore.emNivel();
        System.out.println();
    }
}
