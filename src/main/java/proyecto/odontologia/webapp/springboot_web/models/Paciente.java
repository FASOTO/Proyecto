package proyecto.odontologia.webapp.springboot_web.models;

// import java.util.Date;

public class Paciente {

    private String nombreApellido;
    // private String lugar;
    // private Date fecha;
    // private int nroAfiliado;
    // private String obraSocial;
    // private Date fechaNacimiento;
    private int nroTelefono;
    private int edad;
    // private String estadoCivil;
    private String nacionalidad;
    private int dni;
    // private int nroCelular;
    //private String calle;
    //private String nroCalle;
    //private String barrio;
    //private String localidad;
    // private String profesionActividad;
    // private String lugarTrabajo;
    // private String jerarquia;

//Constructores:
    public Paciente() 
    {

    }

    public Paciente(String nombreApellido, int nroTelefono, int edad, String nacionalidad, int dni) 
    {
        this.nombreApellido = nombreApellido;
        this.nroTelefono = nroTelefono;
        this.edad = edad;
        this.nacionalidad = nacionalidad;
        this.dni = dni;
    }

//Getters & Setters:
    public String getNombreApellido() {
        return nombreApellido;
    }

    public void setNombreApellido(String nombreApellido) {
        this.nombreApellido = nombreApellido;
    }

    public int getNroTelefono() {
        return nroTelefono;
    }

    public void setNroTelefono(int nroTelefono) {
        this.nroTelefono = nroTelefono;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }
    


    

}
