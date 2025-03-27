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
        System.out.println();
        System.out.println("la suma de los elementos de la lista es: " + sumaRecursiva(listita,0,0));
        System.out.println();
        listaRecursivo(listita,i,j);
        List <Integer> listita2 = new ArrayList<>();
        listita2.add(-1);
        listita2.add(0);
        listita2.add(3);
        listita2.add(4);
        listita2.add(4);
        listita2.add(5);
        listita2.add(6);
        listita2.add(6);
        listita2.add(89);
        ArrayList <Integer> listaSuma = sumarListas(listita,listita2);
        System.out.println(listaSuma);
    }

    public static void listaRecursivo(List<Integer> vec, int i, int j) {
        if (i >= (vec.size()/2)) {
            int temp = vec.get(i);
            vec.set(i, vec.get(j));
            vec.set(j, temp);
            listaRecursivo(vec, i - 1, j + 1);
        }
    }

    public static int sumaRecursiva(List<Integer>ashe, int num, int i) {
        if (i < ashe.size()) {
            return sumaRecursiva(ashe,num+ashe.get(i),i+1);
        } else {
            return num;
        }
    }

    public static ArrayList<Integer> sumarListas(List<Integer> listaUno, List<Integer> listaDos) {
        ArrayList<Integer> listaRetorno = new ArrayList<>();
        int i = 0;
        int j = 0;
        while ((i < listaUno.size()) && (j < listaDos.size())) {
            if (listaUno.get(i) <= listaDos.get(j)) {
                listaRetorno.add(listaUno.get(i));
                i = i+1;
            } else {
                listaRetorno.add(listaDos.get(j));
                j = j+1;
            }
        }
        while (i < listaUno.size()) { //si se termino primero la listaDos sigue agregando los elementos sobrantes de las listaUno
            listaRetorno.add(listaUno.get(i));
            i = i+1;
        }
        while (j < listaDos.size()) { //si se termino primero la listaUno sigue agregando los elementos sobrantes de las listaDos
            listaRetorno.add(listaDos.get(j));
            j = j+1;
        }
        return listaRetorno;
    }

}
