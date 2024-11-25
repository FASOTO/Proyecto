package proyecto.odontologia.webapp.springboot_web.services;

import java.util.List;

import proyecto.odontologia.webapp.springboot_web.models.Paciente;
import proyecto.odontologia.webapp.springboot_web.repositories.PacienteRepository;

public class PacienteService {

    PacienteRepository repository = new PacienteRepository();

    public List<Paciente> listarTodos() {
         
        return repository.listarTodos();
    }

}
