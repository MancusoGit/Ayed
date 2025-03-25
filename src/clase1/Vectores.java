package clase1;

import java.util.Scanner;

public class Vectores {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int [] vector = new int [7];
        for (int i = 0; i < vector.length; i++) {
            System.out.print("ingrese un numero: ");
            vector[i] = scan.nextInt();
        }
        Valores resultVec = moduloVec(vector);
        System.out.println(resultVec.toString());
    }

    public static Valores moduloVec(int [] vec) {
        Valores nums = new Valores();
        int cant = vec.length;
        for (int j = 0; j < vec.length; j++) {
            if (j > nums.getMax()) {
                nums.setMax(vec[j]);
            }
            if (j < nums.getMin()) {
                nums.setMin(vec[j]);
            }
            nums.setProm(nums.getProm() + vec[j]);
        }
        nums.setProm(nums.getProm()/cant);

        return nums;
    }

}
