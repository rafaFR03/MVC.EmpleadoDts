package modelo;

public class Empleado {

    private long codigo;
    private double sueldo;

    //Metodo constructor
    public Empleado(long codigo, double sueldo) {
        this.codigo = codigo;

        this.sueldo = sueldo;
    }

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }

}
