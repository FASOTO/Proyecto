package proyecto.odontologia.webapp.springboot_web.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proyecto.odontologia.webapp.springboot_web.models.Paciente;
import proyecto.odontologia.webapp.springboot_web.repositories.IPacienteRepository;

@Service
public class PacienteService {

    @Autowired
    IPacienteRepository repository;

    public List<Paciente> listarTodos() 
    {
        return (List<Paciente>)repository.findAll();
    }

    //Buscar un paciente por su DNI
    public Paciente buscarByDni(int dni)
    {
        return repository.findByDni(dni);
    }

    //Guardar un paciente (estaticamente)
    public void guardarPaciente(Paciente paciente)
    {
        repository.save(paciente);
    }


    public void calcularEdad(Paciente paciente)
    {
        
    }
}
