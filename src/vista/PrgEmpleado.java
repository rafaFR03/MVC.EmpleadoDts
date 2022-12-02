package vista;

import controlador.ArregloEmpleado;
import javax.swing.JOptionPane;

public class PrgEmpleado {

    ArregloEmpleado objArray;

    public PrgEmpleado() {
        objArray = new ArregloEmpleado();
    }

    public static void main(String[] args) {
        PrgEmpleado x = new PrgEmpleado();
        x.menu();
        System.out.println("Este es un mensaje nuevo");
    }

    public void menu() {
        int op = 0;
        String menu;
        menu = """
               ------------------------------------------------
               --Menu de opciones--
               [1] Ingresar datos del empleado
               [2] Mostrar datos
               [3] Mostrar datos del empleado
               [4] Ordenar datos
               [5] Modificar datos
               [6] Eliminar datos
               [7] Sueldos mayores al promedio
               [8] Sueldos menores al promedio
               [0] Salir
               Elija su opcion
               ------------------------------------------------""";
        
        do {
            op = Integer.parseInt(JOptionPane.showInputDialog(menu));
            switch (op) {
                case 1:
                    ingresarDatos();
                    break;
                case 2:
                    mostrarDatos();
                    break;
                case 3:
                    mostrarDatosEmpleado();
                    break;
                case 4:
                    ordenarDatos();
                    mostrarDatos();
                    break;
                case 5:
                    modificarDatos();
                    break;
                case 6:
                    eliminarDatos();
                    break;
                case 7:
                    maxPromedioSueldo();
                    break;
                case 8:
                    minPromedioSueldo();
                case 0:
                    break;
                default:
                    JOptionPane.showMessageDialog(null, "Opcion incorrecta");
            }

        } while (op != 0);
    }

    public void ingresarDatos() {
        long codigo = 0;
        String nombre = "";
        String apellidoP = "";
        String apellidoM = "";
        double sueldo = 0;
        int op = 0;
        do {
            codigo = Long.parseLong(JOptionPane.showInputDialog("Ingresa el codigo:"));

            int pos = objArray.buscarCodigo(codigo);

            if (pos == -1) {
                nombre = JOptionPane.showInputDialog("Ingresa el nombre:");
                apellidoP = JOptionPane.showInputDialog("Ingresa el apellido paterno");
                apellidoM = JOptionPane.showInputDialog("Ingresa el apellido materno");
                sueldo = Double.parseDouble(JOptionPane.showInputDialog("Ingresa el sueldo: "));

                objArray.agregarDatosGenerales(codigo, nombre, apellidoP, apellidoM, sueldo);
            } else {
                JOptionPane.showMessageDialog(null, "El empleado ya se cuencuentra registrado");
            }

            op = JOptionPane.showConfirmDialog(null, "Decea continuar?", "Pregunta", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
        } while (op == JOptionPane.YES_OPTION);
    }

    public void mostrarDatos() {
        String mostrarDatos = objArray.obtenerDatos();
        if (mostrarDatos != "") {
            JOptionPane.showMessageDialog(null, mostrarDatos);
        } else {
            JOptionPane.showMessageDialog(null, "No hay dadtos que mostrar");
        }
    }

    public void mostrarDatosEmpleado() {
        long codigo = Long.parseLong(JOptionPane.showInputDialog("Ingresa el codigo del empleado que deceas buscar: "));
        String mostrar = objArray.obtenerDatosEmpleado(codigo);
        if (mostrar != "") {
            JOptionPane.showMessageDialog(null, mostrar);
        } else {
            JOptionPane.showMessageDialog(null, "El empleado que esta buscando no se encuentra registrado");
        }

    }

    public void modificarDatos() {
        long codigo = Long.parseLong(JOptionPane.showInputDialog("Ingrese el codigo del empleado cuyos datos deseas modificar: "));
        int pos = objArray.buscarCodigo(codigo);
        if (pos != -1) {
            int op = JOptionPane.showConfirmDialog(null, "Esta seguro de modificar los datos de:\n" + objArray.obtenerDatosEmpleado(codigo) , " ?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (op == JOptionPane.YES_OPTION) {
                
                String nombre = JOptionPane.showInputDialog("Ingresa el nuevo nombre: ");
                String apellidoP = JOptionPane.showInputDialog("Ingresa el apellido paterno");
                String apellidoM= JOptionPane.showInputDialog("Ingresa el apellido materno");
                double sueldo = Double.parseDouble(JOptionPane.showInputDialog("Ingresa el nuevo sueldo"));
                objArray.modificarDatos(pos, nombre, apellidoP, apellidoM, sueldo);
            }

        } else {
            JOptionPane.showMessageDialog(null, "El codigo no existe");
        }
    }

    public void eliminarDatos() {
        long codigo = Long.parseLong(JOptionPane.showInputDialog("Ingrese el codigo del empleado cuyos datos deseas eliminar: "));
        int pos = objArray.buscarCodigo(codigo);
        if (pos != -1) {
            int op = JOptionPane.showConfirmDialog(null, "Esta seguro de eliminar los datos de:\n" + objArray.obtenerDatosEmpleado(codigo), " ?", JOptionPane.YES_NO_OPTION, JOptionPane.QUESTION_MESSAGE);
            if (op == JOptionPane.YES_OPTION) {
                objArray.eliminarDatos(pos);
            }

        } else {
            JOptionPane.showMessageDialog(null, "El codigo no existe");
        }
    }

    public void maxPromedioSueldo() {
        String mensaje = "--Empleados que superan el promedio de sueldos--\n";
        mensaje += objArray.maxSueldoPromedio();
        JOptionPane.showMessageDialog(null, mensaje);
    }

    public void minPromedioSueldo() {
        String mensaje = "--Empleados que estan por debajo del sueldo promedio--\n";
        mensaje += objArray.minSueldoPromedio();
        JOptionPane.showMessageDialog(null, mensaje);
    }

    public void ordenarDatos() {
        objArray.ordenarDatos();
    }
}
