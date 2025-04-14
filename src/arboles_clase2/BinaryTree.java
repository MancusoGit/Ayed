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
                    if (ar.hasLeftChild()) {
                        cola.enqueue(ar.getLeftChild());
                    }
                    if (ar.hasRightChild()) {
                        cola.enqueue(ar.getRightChild());
                    }
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


    public boolean esPrefijo(BinaryTree<T> ar1, BinaryTree<T> ar2) {

        if (!ar1.getData().equals(ar2.getData())) {
            return false;
        }

        if (ar1.isLeaf()) {
            return true;
        }

        if ((ar1.hasLeftChild() != ar2.hasLeftChild()) || (ar1.hasRightChild() != ar2.hasRightChild())) {
            return false;
        }

        boolean leftSide = true;
        if (ar1.hasLeftChild() && ar2.hasLeftChild()) {
            leftSide = esPrefijo(ar1.getLeftChild(),ar2.getLeftChild());
        }

        boolean rightSide = true;
        if (ar1.hasRightChild() && ar2.hasRightChild()) {
            rightSide = esPrefijo(ar1.getRightChild(),ar2.getRightChild());
        }
        return leftSide && rightSide;
    }

    public boolean isLeftTree(int num) {
        BinaryTree<T> ar = buscar(this, num);

        if (ar == null) {
            return false;
        }

        int cantIzq = ar.hasLeftChild() ? contarUnicoHijo(ar.getLeftChild()) : -1;

        int cantDer = ar.hasRightChild() ? contarUnicoHijo(ar.getRightChild()) : -1;

        return cantIzq > cantDer;
    }

    private int contarUnicoHijo(BinaryTree<T> ar) {
        if (ar == null || ar.isLeaf()) {
            return 0;
        }

        int contador = 0;

        if (ar.hasLeftChild() ^ ar.hasRightChild()) {
            contador = 1;
        }

        if (ar.hasLeftChild()) {
            contador += contarUnicoHijo(ar.getLeftChild());
        }

        if (ar.hasRightChild()) {
            contador += contarUnicoHijo(ar.getRightChild());
        }

        return contador;
    }

    public void recorridoPorNiveles() {
        BinaryTree<T> ab = null;
        Queue<BinaryTree<T>> cola = new Queue<BinaryTree<T>>();
        cola.enqueue(this);
        cola.enqueue(null);
        while (!cola.isEmpty()) {
            ab = cola.dequeue();
            if (ab != null) {
                System.out.println(ab.getData());
                if (ab.hasLeftChild()) {
                    cola.enqueue(ab.getLeftChild());
                }
                if (ab.hasRightChild()) {
                    cola.enqueue(ab.getRightChild());
                }
            } else if (!cola.isEmpty()) {
                System.out.println();
                cola.enqueue(null);
            }
        }
    }


    private BinaryTree<T> buscar(BinaryTree<T> arbol, int valor) {
        if (arbol == null) {
            return null;
        }

        if (arbol.getData().equals(valor)) {
            return arbol;
        }

        BinaryTree<T> ar = null;

        if (arbol.hasLeftChild()) {
            ar = buscar(arbol.getLeftChild(),valor);
        }

        if (arbol.hasRightChild()) {
            ar = buscar(arbol.getRightChild(),valor);
        }

        return ar;
    }


/*    private boolean contarhijos(BinaryTree<T> ar, int num, boolean encontre) {

    }

*/
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
