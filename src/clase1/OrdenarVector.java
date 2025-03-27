package clase1;

import java.util.List;
import java.util.ArrayList;

public class OrdenarVector {

    public static void main(String[] args) {
        List<Integer> lista = new ArrayList<>();
        lista.add(2);
        lista.add(3);
        lista.add(4);
        lista.add(5);
        lista.add(6);
        System.out.println(lista);
        invertirLista(lista);
        System.out.println(lista);
    }

    public static void invertirLista(List<Integer> vec) {
        int j = 0;
        int temp;
        for (int i = (vec.size()-1); i >= (vec.size()/2); i--) {
            temp = vec.get(i);
            vec.set(i,vec.get(j));
            vec.set(j,temp);
            j = j + 1;
        }
    }
}
