package clase1;

public class Valores {
    private int max;
    private int min;
    private double prom;

    public Valores() {
        this.max = -9999;
        this.min = 9999;
        this.prom = 0;
    }

    public int getMax() {
        return max;
    }

    public void setMax(int num) {
        this.max = num;
    }

    public int getMin() {
        return min;
    }

    public void setMin(int num) {
        this.min = num;
    }

    public double getProm() {
        return prom;
    }

    public void setProm(double num) {
        this.prom = num;
    }

    @Override
    public String toString() {
        return "max = " + getMax() + " min = " + getMin() + " promedio = " + getProm();
    }
}


