package proyecto.odontologia.webapp.springboot_web.services.imp;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proyecto.odontologia.webapp.springboot_web.models.Paciente;
import proyecto.odontologia.webapp.springboot_web.repositories.PacienteRepository;
import proyecto.odontologia.webapp.springboot_web.services.PacienteService;

@Service
public class PacienteServiceImp implements PacienteService {

    @Autowired
    PacienteRepository repository;

    public List<Paciente> listarTodos() 
    {
        return repository.listarTodos();
    }

    //Buscar un paciente por su DNI
    public Paciente buscarByDni(int dni)
    {
        return repository.buscarByDni(dni);
    }

    //Guardar un paciente (estaticamente)
    public void guardarPaciente(Paciente paciente)
    {
        repository.guardarPaciente(paciente);
    }

    //Existe
}
