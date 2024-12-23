package proyecto.odontologia.webapp.springboot_web.models;

import java.time.LocalDate;
import java.time.Period;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "pacientes")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;
    private String apellido;

    @Column(name = "fecha_nacimiento")
    private LocalDate fechaNacimiento;
    private String telefono;

    // private String estadoCivil;
    private String nacionalidad;
    private int dni;

//     <script src="/js/dobleClickPaciente.js"></script>
// <script src="/js/jquery-3.7.1.min.js"></script>

    // private String profesionActividad;
    // private String lugarTrabajo;

    // Constructores:
    public Paciente() {
        this.id= null;
    }

    public Paciente(int id, String nombre, String apellido, LocalDate fechaNacimiento, String nroTelefono,
            String nacionalidad, int dni) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = nroTelefono;
        this.nacionalidad = nacionalidad;
        this.dni = dni;
    }

    public int getEdad()
    {
        LocalDate hoy = LocalDate.now();       
        int edadCalculada = Period.between(this.getFechaNacimiento(), hoy).getYears();
        return edadCalculada;
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public void setTelefono(String nroTelefono) {
        this.telefono = nroTelefono;
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
