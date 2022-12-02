package controlador;

import modelo.DatosPersonales;
import modelo.Empleado;

public class ArregloEmpleado {

    Empleado datos[];
    DatosPersonales dtsP[];
    int numEmp;

    public ArregloEmpleado() {
        datos = new Empleado[100];
        dtsP = new DatosPersonales[100];
        numEmp = 0;
    }

    public void agregarDatosGenerales(long codigo, String nombre, String apellidoP, String apellidoM, double sueldo) {
        if (numEmp == datos.length) {
            aumentar();
        }
        Empleado objEmpleado = new Empleado(codigo, sueldo);
        datos[numEmp] = objEmpleado;

        DatosPersonales objDatosPer = new DatosPersonales(nombre, apellidoP, apellidoM);
        dtsP[numEmp] = objDatosPer;

        numEmp++;
    }

    public String obtenerDatos() {
        String mostrarDatos = "";
        for (int i = 0; i < numEmp; i++) {
            mostrarDatos += datos[i].getCodigo() + " - " + dtsP[i].getNombre() + " - "
                    + dtsP[i].getApellidoP() + " - " + dtsP[i].getApellidoM() + " - "
                    + datos[i].getSueldo() + "\n";
        }
        return mostrarDatos;
    }

    public String obtenerDatosEmpleado(long codigo) {
        String mostrarDatos = "--Datos del empleado--";
        for (int i = 0; i < numEmp; i++) {
            if (codigo == datos[i].getCodigo()) {
                mostrarDatos += "\nCodigo: " + datos[i].getCodigo();
                mostrarDatos += "\nNombre: " + dtsP[i].getNombre();
                mostrarDatos += "\nApellido P: " + dtsP[i].getApellidoP();
                mostrarDatos += "\nApellido M: " + dtsP[i].getApellidoM();
                mostrarDatos += "\nSueldo: " + datos[i].getSueldo();
            }

        }
        return mostrarDatos;
    }

    public void modificarDatos(int pos, String nombre, String apellidoP, String apellidoM, double sueldo) {

        dtsP[pos].setNombre(nombre);
        dtsP[pos].setApellidoP(apellidoP);
        dtsP[pos].setApellidoM(apellidoM);
        datos[pos].setSueldo(sueldo);
    }

    public void eliminarDatos(int pos) {
        if (pos != -1) {
            for (int i = pos; i < numEmp - 1; i++) {
                datos[i] = datos[i + 1];
                dtsP[i] = dtsP[i + 1];
            }
        }
        numEmp--;
    }

    public String maxSueldoPromedio() {
        int cont = 0;
        double prom = promedio(datos);
        String lista = "Promedio :" + prom + "\n";
        for (int i = 0; i < numEmp; i++) {
            if (datos[i].getSueldo() > prom) {
                lista += datos[i].getCodigo() + " - " + dtsP[i].getNombre() + " - "
                        + dtsP[i].getApellidoP() + " - " + dtsP[i].getApellidoM() + " - "
                        + datos[i].getSueldo() + "\n";

                cont++;
            }
        }
        lista += "Total de empleados: " + cont;
        return lista;
    }

    public String minSueldoPromedio() {
        int cont = 0;
        double prom = promedio(datos);
        String lista = "Promedio: " + prom + "\n";
        for (int i = 0; i < numEmp; i++) {
            if (datos[i].getSueldo() < prom) {
                lista += datos[i].getCodigo() + " - " + dtsP[i].getNombre() + " - "
                        + dtsP[i].getApellidoP() + " - " + dtsP[i].getApellidoM() + " - "
                        + datos[i].getSueldo() + "\n";

                cont++;
            }
        }
        lista += "Total de empleados: " + cont;
        return lista;
    }

    public double promedio(Empleado datos[]) {
        double prom = 0;
        double acum = 0;
        for (int i = 0; i < numEmp; i++) {
            acum += datos[i].getSueldo();
        }
        prom = acum / numEmp;
        return prom;
    }

    public int buscarCodigo(long codigo) {
        for (int i = 0; i < numEmp; i++) {
            if (codigo == datos[i].getCodigo()) {
                return i;
            }
        }
        return -1;
    }

    public void aumentar() {
        Empleado datostmp[] = new Empleado[numEmp + 5];
        for (int i = 0; i < numEmp; i++) {
            datostmp[i] = datos[i];

        }
        datos = datostmp;
    }

    public void ordenarDatos() {
        //ordenando los datos de forma ascendente
        Empleado tmp;
        DatosPersonales tempD;
        for (int i = 0; i < numEmp - 1; i++) {
            for (int j = i + 1; j < numEmp; j++) {
                if (datos[i].getCodigo() > datos[j].getCodigo()) {
                    tmp = datos[i];
                    datos[i] = datos[j];
                    datos[j] = tmp;

                    tempD = dtsP[i];
                    dtsP[i] = dtsP[j];
                    dtsP[j] = tempD;
                }
            }
        }
    }

}
