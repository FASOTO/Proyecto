package proyecto.odontologia.webapp.springboot_web.repositories;

import org.springframework.data.repository.CrudRepository;

import proyecto.odontologia.webapp.springboot_web.models.Paciente;

public interface IPacienteRepository extends CrudRepository <Paciente,Integer>{

    // Paciente buscarByDni (int dni);

    
}
