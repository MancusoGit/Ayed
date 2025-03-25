package clase1;

public class tp1_ej1 {
    public static void main(String[] args) {
        System.out.println("imprimir con for: ");
        imprimirSeguidosFor(5, 21);
        System.out.println();

        System.out.println("imprimir con while: ");
        imprimirSeguidosWhile(3,14);
        System.out.println();

        System.out.println("imprimir sin estructura: ");
        imprimirPrime(-23,56);
        System.out.println();
    }

    public static void imprimirSeguidosFor(int a, int b) {
        for (int i = a; i <= b; i++) {
            System.out.println(i);
        }
    }

    public static void imprimirSeguidosWhile(int a, int b) {
        while (a <= b) {
            System.out.println(a);
            a++;
        }
    }

    public static void imprimirPrime(int a, int b) {
        if (a <= b) {
            System.out.println(a);
            imprimirPrime(a+1,b);
        }
    }
}
