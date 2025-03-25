package clase1;

public class Profesor {
    private String nombre;
    private String apellido;
    private String email;
    private String catedra;
    private String facultad;

    public Profesor() {

    }

    public Profesor(String nombre, String apellido, String email, String catedra, String facultad) {
        this.setNombre(nombre);
        this.setApellido(apellido);
        this.setEmail(email);
        this.setCatedra(catedra);
        this.setFacultad(facultad);
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

    public String getCatedra() {
        return catedra;
    }

    public void setCatedra(String catedra) {
        this.catedra = catedra;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFacultad() {
        return facultad;
    }

    public void setFacultad(String facu) {
        this.facultad = facu;
    }
}
