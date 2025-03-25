package src;

public abstract class Persona {
    private String nombre;
    private int edad;
    private long dni;

    public Persona() {

    }

    public Persona(String nom, int edad, long dni) {
        setNombre(nom);
        setEdad(edad);
        setDni(dni);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad () {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public long getDni() {
        return dni;
    }

    public void setDni(long dni) {
        this.dni = dni;
    }

    public String toString() {
        return "hola soy " + this.nombre + ", tengo " + this.edad + " anios, mi dni es: " + this.dni;
    }

}
