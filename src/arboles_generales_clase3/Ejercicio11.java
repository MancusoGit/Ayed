package arboles_generales_clase3;

import clase1.Queue;

public class Ejercicio11 {

    public static void main(String[] args) {
        GeneralTree<Integer> root = new GeneralTree<>(3);
        GeneralTree<Integer> h1 = new GeneralTree<>(5);
        GeneralTree<Integer> h2 = new GeneralTree<>(4);
        h1.addChild(new GeneralTree<>(7));
        h1.addChild(new GeneralTree<>(1));
        h2.addChild(new GeneralTree<>(2));
        root.addChild(h1);
        root.addChild(h2);


        System.out.println(resolver(root));
    }

    public static boolean resolver(GeneralTree<Integer> arbol) {
        Queue<GeneralTree<Integer>> cola = new Queue<>();
        GeneralTree<Integer> aux = new GeneralTree<>();
        boolean creciente = true;
        cola.enqueue(arbol);
        cola.enqueue(null);
        int nivel = 1;
        int contadorHijos = 0;
        while ((!cola.isEmpty()) && (creciente)) {
            aux = cola.dequeue();
            if (aux != null) {
                if (aux.hasChildren()) {
                    for (GeneralTree<Integer> hijo : aux.getChildren()) {
                        cola.enqueue(hijo);
                        contadorHijos++;
                    }
                }
            } else if (!cola.isEmpty()) {
                creciente = (contadorHijos == (nivel + 1));
                contadorHijos = 0;
                nivel++;
                cola.enqueue(null);
            }
        }
        return creciente;
    }

}
