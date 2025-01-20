package proyecto.odontologia.webapp.springboot_web.models;

import java.time.LocalDate;
import java.time.Period;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
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
    private String localidad;
    private int dni;

    @OneToMany(cascade = CascadeType.ALL)
    private List<Imagen> imagenes = new ArrayList<>();

//     <script src="/js/dobleClickPaciente.js"></script>
// <script src="/js/jquery-3.7.1.min.js"></script>

    // private String profesionActividad;
    // private String lugarTrabajo;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "domicilio_id", referencedColumnName = "id")
    private Domicilio domicilio;

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    // Constructores:
    public Paciente() {
        this.id= null;
    }

    public Domicilio getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(Domicilio domicilio) {
        this.domicilio = domicilio;
    }

    public List<Imagen> getImagenes() {
        return imagenes;
    }

    public void setImagenes(List<Imagen> imagenes) {
        this.imagenes = imagenes;
    }

    public Paciente(int id, String nombre, String apellido, LocalDate fechaNacimiento, String nroTelefono,
            String nacionalidad, int dni,String localidad,Domicilio domicilio, List<Imagen> imagenes) {
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
        this.fechaNacimiento = fechaNacimiento;
        this.telefono = nroTelefono;
        this.nacionalidad = nacionalidad;
        this.dni = dni;
        this.localidad = localidad;
        this.domicilio = domicilio;
        this.imagenes = imagenes;
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
