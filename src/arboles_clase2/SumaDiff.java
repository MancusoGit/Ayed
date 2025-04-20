package arboles_clase2;

public class SumaDiff {
    private int sumaValores;

    private int diffValores;

    public SumaDiff(int suma, int diff) {
        this.sumaValores = suma;
        this.diffValores = diff;
    }

    public SumaDiff() {

    }

    public int getSumaValores() {
        return sumaValores;
    }

    public void setSumaValores(int result) {
        this.sumaValores = result;
    }

    public int getDiffValores() {
        return diffValores;
    }

    public void setDiffValores(int resultado) {
        this.diffValores = resultado;
    }

    public String toString() {
        return "valor suma " + this.getSumaValores() + ", valor diferencia " + this.getDiffValores();
    }

}

