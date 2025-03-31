package arboles_clase2;

public class Arbolito {

    public static void main(String[] args) {
        BinaryTree<Integer> root = new BinaryTree<>(40);
        BinaryTree<Integer> hi = new BinaryTree<>(25);
        hi.addLeftChild(new BinaryTree<Integer>(11));
        hi.addRightChild(new BinaryTree<>(34));
        BinaryTree<Integer> hd = new BinaryTree<>(72);
        root.addRightChild(hd);
        root.addLeftChild(hi);
        System.out.println(root.contarHojas());

    }


}
