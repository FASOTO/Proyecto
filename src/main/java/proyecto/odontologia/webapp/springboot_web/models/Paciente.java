package proyecto.odontologia.webapp.springboot_web.models;

import java.time.LocalDate;

public class Paciente {

    private String nombreApellido;
    // private String lugar;
    // private Date fecha;
    // private int nroAfiliado;
    // private String obraSocial;
    private LocalDate fechaNacimiento;
    private int nroTelefono;
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

    public Paciente(String nombreApellido, int nroTelefono, String nacionalidad, int dni, LocalDate fechaNacimiento) {
        this.nombreApellido = nombreApellido;
        this.nroTelefono = nroTelefono;
        this.nacionalidad = nacionalidad;
        this.dni = dni;
        this.fechaNacimiento = fechaNacimiento;
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

    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    
    


    

}
