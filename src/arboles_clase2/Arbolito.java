package arboles_clase2;

import java.sql.SQLOutput;

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

        System.out.println("contenido entre los niveles 0 y 1");
        root.entreNiveles(0,2 );

        BinaryTree<Integer> root2 = new BinaryTree<>(40);
        BinaryTree<Integer> hi2 = new BinaryTree<>(25);
        hi.addLeftChild(new BinaryTree<Integer>(11));
        hi.addRightChild(new BinaryTree<>(34));
        BinaryTree<Integer> hd2 = new BinaryTree<>(72);
        hd2.addRightChild(new BinaryTree<Integer>(92));
        root2.addLeftChild(hi2);
        root2.addRightChild(hd2);
        System.out.println();
        System.out.print("es prefijo: ");
        System.out.println(root.esPrefijo(root2,root));
    }

}
