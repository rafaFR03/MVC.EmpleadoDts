
package modelo;


public class DatosPersonales {
    private String nombre;
    private String apellidoP;
    private String apellidoM;
    //private int dni;
    //private String Direccion;

    public DatosPersonales(String nombre, String apellidoP, String apellidoM) {
        this.nombre = nombre;
        this.apellidoP = apellidoP;
        this.apellidoM = apellidoM;
        //this.dni = dni;
        //this.Direccion = Direccion;
    }

    /*public String getDireccion() {
        return Direccion;
    }*/

   /*public void setDireccion(String Direccion) {
        this.Direccion = Direccion;
    }*/

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidoP() {
        return apellidoP;
    }

    public void setApellidoP(String apellidoP) {
        this.apellidoP = apellidoP;
    }

    public String getApellidoM() {
        return apellidoM;
    }

    public void setApellidoM(String apellidoM) {
        this.apellidoM = apellidoM;
    }

    /*public int getDni() {
        return dni;
    }*/

   /* public void setDni(int dni) {
        this.dni = dni;
    }*/
    
    
}
