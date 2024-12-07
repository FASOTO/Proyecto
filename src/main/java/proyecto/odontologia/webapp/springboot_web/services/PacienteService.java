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
        // System.out.println(repository.buscarByDni(45738293).getApellido());
        return (List<Paciente>)repository.findAll();
    }

    //Buscar un paciente por su DNI
    // public Paciente buscarByDni(int dni)
    // {
    //     System.out.println(repository.buscarByDni(dni).getApellido());
    //     return null;
    //     // return repository.buscarByDni(dni);
    // }

    //Guardar un paciente (estaticamente)
    // public void guardarPaciente(Paciente paciente)
    // {
    //     repository.guardarPaciente(paciente);
    // }


    public void calcularEdad(Paciente paciente)
    {
        
    }
}
