package arboles_clase2;

import java.util.Collection;
import java.util.Iterator;
import java.util.Queue;
import java.util.Stack;

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
    public void entreNiveles(int n, int m){
        //hacer un recorrido iterativo siempre que sea por niveles
    }

}
