package clase1;

public class Estudiante {

    private String nombre;
    private String apellido;
    private int comision;
    private String email;
    private String direccion;

    public Estudiante() {

    }

    public Estudiante(String unNombre, String unApellido, int unaComision, String unEmail, String unaDirecc) {
        this.setNombre(unNombre);
        this.setApellido(unApellido);
        this.setComision(unaComision);
        this.setEmail(unEmail);
        this.setDireccion(unaDirecc);
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nom) {
        this.nombre = nom;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String ape) {
        this.apellido = ape;
    }

    public int getComision() {
        return comision;
    }

    public void setComision(int com) {
        this.comision = com;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String dir) {
        this.direccion = dir;
    }

    public String tusDatos() {
        return "soy " + getNombre() + " " + getApellido() + ", comision -> " + getComision() + ", mi email es " + getEmail() + ", direccion: " + getDireccion();
    }
}
