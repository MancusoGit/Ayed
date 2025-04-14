package arboles_clase2;

public class Transformacion {

    public static void main(String[] args) {
        BinaryTree<Integer> root = new BinaryTree<>(1);
        BinaryTree<Integer> hi = new BinaryTree<>(2);
        hi.addRightChild(new BinaryTree<>(4));
        BinaryTree<Integer> hd = new BinaryTree<>(3);
        BinaryTree <Integer> hdaux1 = new BinaryTree<>(5);
        BinaryTree <Integer> hdaux2 = new BinaryTree<>(6);
        hdaux1.addLeftChild(new BinaryTree<>(7));
        hdaux1.addRightChild(new BinaryTree<>(8));
        hd.addLeftChild(hdaux1);
        hd.addRightChild(hdaux2);
        root.addRightChild(hd);
        root.addLeftChild(hi);
        System.out.println();
        root.recorridoPorNiveles();
        System.out.println();

        Transformacion aux = new Transformacion();
        root = aux.suma(root);
        root.recorridoPorNiveles();
    }


    private int sumaPrivada(BinaryTree<Integer> ar) {
        int valor = ar.getData();

        if (ar.isLeaf()) {
            ar.setData(0);
            return valor;
        }

        int sumaIzq = 0;
        int sumaDer = 0;
        if (ar.hasLeftChild()) {
            sumaIzq = sumaPrivada(ar.getLeftChild());
        }
        if (ar.hasRightChild()) {
            sumaDer = sumaPrivada(ar.getRightChild());
        }

        ar.setData(sumaIzq + sumaDer);
        return valor + sumaIzq + sumaDer;
    }

    public BinaryTree<Integer> suma(BinaryTree<Integer> ar) {
        sumaPrivada(ar);
        return ar;
    }

}
