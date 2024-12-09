package proyecto.odontologia.webapp.springboot_web.models.dto;

import java.time.LocalDate;
import java.time.Period;

import proyecto.odontologia.webapp.springboot_web.models.Paciente;

public class PacienteDto extends Paciente {

    private String nombre;
    private String apellido;
    private LocalDate fechaNacimiento;
    private String telefono;
    private String nacionalidad;
    private int dni;

    
    public int getEdad()
    {
        LocalDate hoy = LocalDate.now();       
        int edadCalculada = Period.between(this.getFechaNacimiento(), hoy).getYears();
        return edadCalculada;
    }


    public PacienteDto(Paciente paciente)
    {
        this.nombre = paciente.getNombre();
        this.apellido = paciente.getApellido();
        this.fechaNacimiento = paciente.getFechaNacimiento();
        this.telefono = paciente.getTelefono();
        this.nacionalidad = paciente.getNacionalidad();
        this.dni = paciente.getDni();
    }


    public String getNombre() {
        return nombre;
    }


    public void setNombre(String nombre) {
        this.nombre = nombre;
    }


    public String getApellido() {
        return apellido;
    }


    public void setApellido(String apellido) {
        this.apellido = apellido;
    }


    public LocalDate getFechaNacimiento() {
        return fechaNacimiento;
    }


    public void setFechaNacimiento(LocalDate fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }


    public String getTelefono() {
        return telefono;
    }


    public void setTelefono(String telefono) {
        this.telefono = telefono;
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
