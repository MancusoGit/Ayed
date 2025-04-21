package arboles_generales_clase3;

import java.util.LinkedList;
import java.util.List;
import clase1.Queue;

public class GeneralTree<T>{

    private T data;

    private List<GeneralTree<T>> children = new LinkedList<GeneralTree<T>>();

    public GeneralTree() {

    }

    public GeneralTree(T data) {
        this.data = data;
    }

    public GeneralTree(T data, List<GeneralTree<T>> children) {
        this(data);
        this.children = children;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public List<GeneralTree<T>> getChildren() {
        return this.children;
    }

    public void setChildren(List<GeneralTree<T>> children) {
        if (children != null)
            this.children = children;
    }

    public void addChild(GeneralTree<T> child) {
        this.getChildren().add(child);
    }

    public boolean isLeaf() {
        return !this.hasChildren();
    }

    public boolean hasChildren() {
        return !this.children.isEmpty();
    }

    public boolean isEmpty() {
        return this.data == null && !this.hasChildren();
    }

    public void removeChild(GeneralTree<T> child) {
        if (this.hasChildren())
            children.remove(child);
    }

    public List<T> traversalLevel(GeneralTree<T> tree) {

        List<T> listaResultante = new LinkedList<T>();

        GeneralTree<T> ar_aux;

        Queue <GeneralTree<T>> cola = new Queue<GeneralTree<T>>();

        cola.enqueue(tree);

        while (!cola.isEmpty()) {
            ar_aux = cola.dequeue();
            listaResultante.add(ar_aux.getData());
            List<GeneralTree<T>> hijos = ar_aux.getChildren();
            for (GeneralTree<T> hijo: hijos) {
                cola.enqueue(hijo);
            }
        }
        
        return listaResultante;
    }

    public int altura() {

        return 0;
    }

    public int nivel(T dato){
            return 0;
    }

    public int ancho(){
        return 0;
    }

}

