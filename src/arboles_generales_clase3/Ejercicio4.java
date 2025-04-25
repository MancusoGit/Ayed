package arboles_generales_clase3;

import clase1.Queue;

public class Ejercicio4 {


    public static void main(String[] args) {
        AreaEmpresa a1 = new AreaEmpresa("area 1", 40);
        AreaEmpresa p1a2 = new AreaEmpresa("area 2",200);
        AreaEmpresa p2a2 = new AreaEmpresa("area 2",20);
        AreaEmpresa p3a2 = new AreaEmpresa("area 2", 10);
        AreaEmpresa p1a3 = new AreaEmpresa("area 3",300);
        AreaEmpresa p2a3 = new AreaEmpresa("area 3",45);

        GeneralTree<AreaEmpresa> root = new GeneralTree<AreaEmpresa>(a1);
        GeneralTree<AreaEmpresa> h1 = new GeneralTree<AreaEmpresa>(p1a2);
        GeneralTree<AreaEmpresa> h2 = new GeneralTree<AreaEmpresa>(p2a2);
        GeneralTree<AreaEmpresa> h3 = new GeneralTree<AreaEmpresa>(p3a2);
        GeneralTree<AreaEmpresa> h4 = new GeneralTree<AreaEmpresa>(p1a3);
        GeneralTree<AreaEmpresa> h5 = new GeneralTree<AreaEmpresa>(p2a3);

        h1.addChild(h4);
        h3.addChild(h5);
        root.addChild(h1);
        root.addChild(h2);
        root.addChild(h3);

        Ejercicio4 aux = new Ejercicio4();

        double prom = aux.devolverMaximoPromedio(root);

        System.out.println("el promedio maximo por nivel de la empresa es: " + prom);
    }

    public double devolverMaximoPromedio(GeneralTree<AreaEmpresa> ar) {
        GeneralTree<AreaEmpresa> arAct = new GeneralTree<>();
        Queue <GeneralTree<AreaEmpresa>> cola = new Queue<GeneralTree<AreaEmpresa>>();
        cola.enqueue(ar);
        cola.enqueue(null);
        double totalMax = 0;
        double promAct = 0;
        int cantAct = 0;
        while(!cola.isEmpty()) {
            arAct = cola.dequeue();
            if (arAct != null) {
                promAct += arAct.getData().getTransmision();
                cantAct += 1;
                if (arAct.hasChildren()) {
                    for(GeneralTree<AreaEmpresa> hijo: arAct.getChildren()) {
                        cola.enqueue(hijo);
                    }
                }
            } else if (!cola.isEmpty()) {
                promAct /= cantAct;
                if (cantAct > 0) {totalMax = maximo(totalMax,(promAct));}
                cola.enqueue(null);
                promAct = 0;
                cantAct = 0;
            }
        }
        if (cantAct > 0) {
            promAct /= cantAct;
            totalMax = maximo(totalMax,(promAct));
        }
        return totalMax;
    }

    private double maximo(double a, double b) {
        if (a >= b) { return a; }
        else return b;
    }
}
