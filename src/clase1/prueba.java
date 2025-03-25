package clase1;

public class prueba {
    public static void sw1(int x, int y) {
        int temp = x;
        x = y;
        y = temp;
    }

    public static void main(String[] args) {
        int x = 5;
        int y = 6;
        sw1(x,y);
        System.out.println("valor x = " + x + " valor y = " + y);
    }
}
