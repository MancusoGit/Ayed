package src;

import java.util.Scanner;
import java.util.Random;

public class Program {

    static void cambiar(Empleado e) {
        Scanner scan = new Scanner(System.in);
        Random random = new Random();

        System.out.print("ingrese el nuevo nombre: ");
        String nuevoNombre = scan.nextLine();
        e.setNombre(nuevoNombre);

        System.out.println("generando nuevo id...");
        int nuevoId = random.nextInt();
        e.setId(nuevoId);

        System.out.println("dentro del metodo : ");
        System.out.println(e.toString());
    }

    public static void main(String[] args) {

        Empleado emp1 = new Empleado("Jorge",26,23423423,"Ingeniero");

        System.out.println(emp1.toString());
        System.out.println();
        cambiar(emp1);
        System.out.println("fuera del metodo : ");
        System.out.println(emp1.toString());

    }

}
