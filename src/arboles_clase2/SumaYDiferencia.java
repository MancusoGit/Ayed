package arboles_clase2;

public class SumaYDiferencia {

    public static void main(String[] args) {
        BinaryTree<Integer> root = new BinaryTree<>(20);
        BinaryTree<Integer> hi = new BinaryTree<>(5);
        hi.addRightChild(new BinaryTree<>(10));
        BinaryTree<Integer> hd = new BinaryTree<>(30);
        BinaryTree <Integer> hdaux1 = new BinaryTree<>(50);
        BinaryTree <Integer> hdaux2 = new BinaryTree<>(-9);
        hdaux1.addLeftChild(new BinaryTree<>(7));
        hdaux1.addRightChild(new BinaryTree<>(8));
        hd.addLeftChild(hdaux1);
        hd.addRightChild(hdaux2);
        root.addRightChild(hd);
        root.addLeftChild(hi);
        System.out.println();
        root.recorridoPorNiveles();
        System.out.println();

        SumaYDiferencia aux = new SumaYDiferencia();

        BinaryTree<SumaDiff> ar = aux.sumAndDif(root);
        aux.imprimirContenido(ar);
    }

    public void imprimirContenido(BinaryTree<SumaDiff> ar) {
        System.out.print("suma de valores del nodo: ");
        System.out.println(ar.getData().getSumaValores());
        System.out.println();
        System.out.print("diferencia del nodo y el padre: ");
        System.out.println(ar.getData().getDiffValores());
        System.out.println();
        System.out.println("----------------------------------");
        System.out.println();
        if (ar.hasLeftChild()) {
            imprimirContenido(ar.getLeftChild());
        }
        if (ar.hasRightChild()) {
            imprimirContenido(ar.getRightChild());
        }
    }

    public BinaryTree<SumaDiff> sumAndDif(BinaryTree<Integer> arbol) {
        //preguntar hoja, vacio y null
        return sumAndDifPrivate(arbol, 0, 0);
    }

    private BinaryTree<SumaDiff> sumAndDifPrivate(BinaryTree<Integer> ar, int valorPadre, int sumaDeValores) {
        BinaryTree<SumaDiff> arNue = new BinaryTree<SumaDiff>();
        SumaDiff info = new SumaDiff();
            int suma = ar.getData() + sumaDeValores;
            info.setSumaValores(suma);

            int diferencia = ar.getData() - valorPadre;
            info.setDiffValores(diferencia);

            arNue.setData(info);

            if (ar.hasLeftChild()) {
                arNue.addLeftChild(sumAndDifPrivate(ar.getLeftChild(),ar.getData(),suma));
            }

            if (ar.hasRightChild()) {
                arNue.addRightChild(sumAndDifPrivate(ar.getRightChild(), ar.getData(),suma));
            }
        return arNue;
    }
}
