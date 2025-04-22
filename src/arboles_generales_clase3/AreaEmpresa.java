package arboles_generales_clase3;

public class AreaEmpresa {
    private String identificacion;

    private int transmision;

    public AreaEmpresa() {

    }

    public AreaEmpresa(String id, int tardanza) {
        this.setIdentificacion(id);
        this.setTransmision(tardanza);
    }

    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String id) {
        this.identificacion = id;
    }

    public int getTransmision() {
        return transmision;
    }

    public void setTransmision(int time) {
        this.transmision = time;
    }
}
