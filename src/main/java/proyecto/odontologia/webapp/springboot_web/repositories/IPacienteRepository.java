package proyecto.odontologia.webapp.springboot_web.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import proyecto.odontologia.webapp.springboot_web.models.Paciente;

@RepositoryRestResource(path = "pacientes")
public interface IPacienteRepository extends CrudRepository <Paciente,Integer>{

    Paciente findByDni (int dni);
    

    
}
