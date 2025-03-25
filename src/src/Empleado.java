package src;

import java.util.Random;

public class Empleado extends Persona {

    Random random = new Random();
    private static int cantEmpleados = 0;
    private String puesto;
    private int id;

    public Empleado() {

    }

    public Empleado(String unNombre, int unaEdad, long unDni, String unPuesto) {
        super(unNombre,unaEdad,unDni);
        setPuesto(unPuesto);
        this.id = random.nextInt(100);
        cantEmpleados++;
    }

    public String getPuesto() {
        return puesto;
    }

    public void setPuesto(String puesto) {
        this.puesto = puesto;
    }

    public int getId() {
        return id;
    }

    public void setId(int nuevoId) {
        this.id = nuevoId;
    }

    public static int getCantEmpleados() {
        return cantEmpleados;
    }

    public String toString() {
        return super.toString() + ", mi puesto de trabajo es " + this.puesto + ", y mi id es = " + this.id;
    }

}

