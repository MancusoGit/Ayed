package arboles_clase2;

import java.util.Stack;
import clase1.Queue;


public class BinaryTree <T> {

    private T data;
    private BinaryTree<T> leftChild;
    private BinaryTree<T> rightChild;


    public BinaryTree() {
        super();
    }

    public BinaryTree(T data) {
        this.data = data;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
    /**
     * Preguntar antes de invocar si hasLeftChild()
     * @return
     */
    public BinaryTree<T> getLeftChild() {
        return leftChild;
    }
    /**
     * Preguntar antes de invocar si hasRightChild()
     * @return
     */
    public BinaryTree<T> getRightChild() {
        return this.rightChild;
    }

    public void addLeftChild(BinaryTree<T> child) {
        this.leftChild = child;
    }

    public void addRightChild(BinaryTree<T> child) {
        this.rightChild = child;
    }

    public void removeLeftChild() {
        this.leftChild = null;
    }

    public void removeRightChild() {
        this.rightChild = null;
    }

    public boolean isEmpty(){
        return (this.isLeaf() && this.getData() == null);
    }

    public boolean isLeaf() {
        return (!this.hasLeftChild() && !this.hasRightChild());

    }

    public boolean hasLeftChild() {
        return this.leftChild!=null;
    }

    public boolean hasRightChild() {
        return this.rightChild!=null;
    }
    @Override
    public String toString() {
        return this.getData().toString();
    }

    public  int contarHojas() {
        int contador = 0;
        if (this.isEmpty()) {
            return contador;
        } else {
            Stack<BinaryTree> pila = new Stack<>();
            pila.push(this); //aca iria la raiz
            while (!pila.isEmpty()) {
                BinaryTree<T> nodo = pila.pop();
                if (nodo.isLeaf()) {
                    contador += 1;
                }
                if (nodo.hasLeftChild()) {
                    pila.push(nodo.getLeftChild());
                }
                if (nodo.hasRightChild()) {
                    pila.push(nodo.getRightChild());
                }
            }
            return contador;
        }
    }



    public void imprimirContenido() {
        System.out.println(this.getData() + "\n");
        if (this.hasLeftChild()) {this.getLeftChild().imprimirContenido();}
        if (this.hasRightChild()) {this.getRightChild().imprimirContenido();}
    }

    public BinaryTree<T> espejo() {
        BinaryTree<T> arNue = new BinaryTree<>(this.data);
        if (this.hasLeftChild()) {
            arNue.addRightChild(this.getLeftChild().espejo());
        }
        if (this.hasRightChild()) {
            arNue.addLeftChild(this.getRightChild().espejo());
        }
        return arNue;
    }

    // 0<=n<=m
    public void entreNiveles(int n, int m) {
        BinaryTree<T> ar = null;
        Queue<BinaryTree<T>> cola = new Queue<BinaryTree<T>>();
        int contador = 0;
        cola .enqueue(this);
        cola.enqueue(null);
        while (!cola.isEmpty()) {
            ar = cola.dequeue();
            if (ar != null) {
                if ((contador >= n) && (contador <= m)) {
                    System.out.println(ar.getData());
                }
                if (ar.hasLeftChild()) {
                    cola.enqueue(ar.getLeftChild());
                }
                if (ar.hasRightChild()) {
                    cola.enqueue(ar.getRightChild());
                }
            } else if (!cola.isEmpty()) {
                System.out.println();
                cola.enqueue(null);
                contador += 1;
            }
        }
    }

    public boolean isFull() {
        BinaryTree<T> ar = null;
        Queue<BinaryTree<T>> cola = new Queue<BinaryTree<T>>();
        boolean lleno = true;
        int cant_nodos = 0;
        int nivel = 0;
        cola.enqueue(this);
        cola.enqueue(null);
        while(!cola.isEmpty() && lleno) {
            ar = cola.dequeue();
            if (ar != null) {
                if (ar.hasLeftChild()) {
                    cola.enqueue(ar.getLeftChild());
                    cant_nodos++;
                }
                if (ar.hasRightChild()) {
                    cola.enqueue(ar.getRightChild());
                    cant_nodos++;
                }
            } else if (!cola.isEmpty()) {
                if (cant_nodos == Math.pow(2,++nivel)) {
                    cola.enqueue(null);
                    cant_nodos = 0;
                } else
                    lleno = false;
            }
        }
        return lleno;
    }


    /*
    metodo para generar un arbol

    private static BinaryTree<T> createBinaryTree(<T> Dato) {
        BinaryTree<T> ar = new BinaryTree<T>(dato);
        if (comparacion) {
            ar.addLeftChild(createBinaryTree(dato));
        }
        if (comparacion) {
            ar.addRightChild(createBinaryTree(dato));
        }
        return ar;
    }

     */

}
