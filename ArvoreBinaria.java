import java.util.LinkedList;
import java.util.Queue;

public class ArvoreBinaria {
    No raiz;

    public ArvoreBinaria() {
        this.raiz = null;
    }

    public void inserir(int valor) {
        raiz = inserirRecursivo(raiz, valor);
    }

    private No inserirRecursivo(No no, int valor) {
        if (no == null) {
            return new No(valor);
        }
        if (valor < no.valor) {
            no.esquerdo = inserirRecursivo(no.esquerdo, valor);
        } else if (valor > no.valor) {
            no.direito = inserirRecursivo(no.direito, valor);
        }
        return no;
    }

    public void remover(int valor) {
        raiz = removerRecursivo(raiz, valor);
    }

    private No removerRecursivo(No no, int valor) {
        if (no == null) {
            return null;
        }
        if (valor < no.valor) {
            no.esquerdo = removerRecursivo(no.esquerdo, valor);
        } else if (valor > no.valor) {
            no.direito = removerRecursivo(no.direito, valor);
        } else {
            if (no.esquerdo == null) {
                return no.direito;
            } else if (no.direito == null) {
                return no.esquerdo;
            }
            No menor = encontrarMenor(no.direito);
            no.valor = menor.valor;
            no.direito = removerRecursivo(no.direito, menor.valor);
        }
        return no;
    }

    private No encontrarMenor(No no) {
        while (no.esquerdo != null) {
            no = no.esquerdo;
        }
        return no;
    }

    public void preOrdem(No no) {
        if (no != null) {
            System.out.print(no.valor + " ");
            preOrdem(no.esquerdo);
            preOrdem(no.direito);
        }
    }

    public void inOrdem(No no) {
        if (no != null) {
            inOrdem(no.esquerdo);
            System.out.print(no.valor + " ");
            inOrdem(no.direito);
        }
    }

    public void posOrdem(No no) {
        if (no != null) {
            posOrdem(no.esquerdo);
            posOrdem(no.direito);
            System.out.print(no.valor + " ");
        }
    }

    public void emNivel() {
        if (raiz == null) {
            return;
        }
        Queue<No> fila = new LinkedList<>();
        fila.add(raiz);
        while (!fila.isEmpty()) {
            No atual = fila.poll();
            System.out.print(atual.valor + " ");
            if (atual.esquerdo != null) {
                fila.add(atual.esquerdo);
            }
            if (atual.direito != null) {
                fila.add(atual.direito);
            }
        }
    }
}
