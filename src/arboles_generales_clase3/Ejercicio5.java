package arboles_generales_clase3;

public class Ejercicio5 {

    public static void main(String[] args) {
        GeneralTree<Integer> root = new GeneralTree<>();
        GeneralTree<Integer> h1 = new GeneralTree<>();
        GeneralTree<Integer> h2 = new GeneralTree<>();
        GeneralTree<Integer> h3 = new GeneralTree<>();
        GeneralTree<Integer> h4 = new GeneralTree<>();

        GeneralTree<Integer> h5 = new GeneralTree<>();
        GeneralTree<Integer> h6 = new GeneralTree<>();

        GeneralTree<Integer> h7 = new GeneralTree<>();

        h2.addChild(h5);
        h2.addChild(h6);

        h3.addChild(h7);

        root.addChild(h1);
        root.addChild(h2);
        root.addChild(h3);
        root.addChild(h4);

        Ejercicio5 aux = new Ejercicio5();

        aux.caudal(root,1000);

    }

    public void caudal(GeneralTree<Integer> ar, int caudal) {
        ar.setData(caudal);
        System.out.println(ar.getData());
        if (ar.hasChildren()) {
            for (GeneralTree<Integer> hijo : ar.getChildren()) {
                caudal(hijo, (caudal/ar.getChildren().size()));
            }
        }
    }

}
