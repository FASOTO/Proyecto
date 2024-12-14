package proyecto.odontologia.webapp.springboot_web.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import proyecto.odontologia.webapp.springboot_web.models.Paciente;
import proyecto.odontologia.webapp.springboot_web.repositories.IPacienteRepository;

@Service
public class PacienteService {

    @Autowired
    IPacienteRepository repository;

    public List<Paciente> listarTodos()
    {
        List<Paciente> listadoPacientes = (List<Paciente>)repository.findAll();
        return listadoPacientes;
    }

    /*public List<String> listarNacionalidades()
    {
        //nueva función
        List<String> Nacionalidades = (List<String>)repository.findNacionalidad();
        return Nacionalidades;
    }*/

    //Buscar un paciente por su DNI
    public Paciente buscarByDni(int dni)
    {
        return repository.findByDni(dni);
    }

    //Guardar un paciente (estaticamente)
    @Transactional
    public void guardarPaciente(Paciente paciente)
    {
        repository.save(paciente);
    }

}
