package clase1;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public class ListaRecursiva {

    public static void main(String[] args) {
        List <Integer> listita = new ArrayList<>();
        listita.add(1);
        listita.add(2);
        listita.add(3);
        listita.add(4);
        listita.add(5);
        listita.add(7);
        System.out.println(listita);
        int j = 0;
        int i = (listita.size() - 1);
        listaRecursivo(listita,i,j);
        System.out.println(listita);
    }

    public static void listaRecursivo(List<Integer> vec, int i, int j) {
        if (i >= (vec.size()/2)) {
            int temp = vec.get(i);
            vec.set(i, vec.get(j));
            vec.set(j, temp);
            listaRecursivo(vec, i - 1, j + 1);
        }
    }

}
