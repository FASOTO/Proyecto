package proyecto.odontologia.webapp.springboot_web.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "domicilio")
public class Domicilio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String calle;
    private String nroCalle;
    private String barrio;
    private String localidad;

//Constructores
    public Domicilio() {
    }

    public Domicilio(String calle, String nroCalle, String barrio, String localidad) {
        this.calle = calle;
        this.nroCalle = nroCalle;
        this.barrio = barrio;
        this.localidad = localidad;
    }

//Getters y Setters
    public String getCalle() {
        return calle;
    }

    public void setCalle(String calle) {
        this.calle = calle;
    }

    public String getNroCalle() {
        return nroCalle;
    }

    public void setNroCalle(String nroCalle) {
        this.nroCalle = nroCalle;
    }

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    
}
