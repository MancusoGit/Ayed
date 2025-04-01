package arboles_clase2;

public class Arbolito {

    public static void main(String[] args) {
        BinaryTree<Integer> root = new BinaryTree<>(40);
        BinaryTree<Integer> hi = new BinaryTree<>(25);
        hi.addLeftChild(new BinaryTree<Integer>(11));
        hi.addRightChild(new BinaryTree<>(34));
        BinaryTree<Integer> hd = new BinaryTree<>(72);
        hd.addLeftChild(new BinaryTree<>(66));
        hd.addRightChild(new BinaryTree<>(88));
        root.addRightChild(hd);
        root.addLeftChild(hi);
        System.out.println(root.contarHojas() + "\n");

        System.out.println("arbol original");
        root.imprimirContenido();
        BinaryTree<Integer> rootNew = root.espejo();
        System.out.println("arbol espejo");
        rootNew.imprimirContenido();
    }


}
