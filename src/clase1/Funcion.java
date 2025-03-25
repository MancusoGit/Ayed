package clase1;

import java.util.List;
import java.util.ArrayList;

public class Funcion {

    public static void main(String[] args) {
        List <Integer> lista = Funcion.Cascara(8);
        System.out.println(lista);
    }

    private static void calcularSucesion(int n, List<Integer> sucesion) {
        int num;
        sucesion.add(n);
        if (n != 1) {
            if ((n % 2) == 0) {
                num = n / 2;
            } else {
                num = (3 * n) + 1;
            }
            calcularSucesion(num,sucesion);
        }
    }

    public static List <Integer> Cascara(int num) {
        List <Integer> sucesionNums = new ArrayList<>();
        calcularSucesion(num,sucesionNums);
        return sucesionNums;
    }
}
