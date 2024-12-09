package proyecto.odontologia.webapp.springboot_web.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proyecto.odontologia.webapp.springboot_web.models.Paciente;
import proyecto.odontologia.webapp.springboot_web.models.dto.PacienteDto;
import proyecto.odontologia.webapp.springboot_web.repositories.IPacienteRepository;

@Service
public class PacienteService {

    @Autowired
    IPacienteRepository repository;

    public List<PacienteDto> listarTodos()
    {
        List<Paciente> listadoPacientes = (List<Paciente>)repository.findAll();
        List<PacienteDto> listadoPacientesDTO = new ArrayList<>(); 

        for (Paciente paciente : listadoPacientes) 
        {
            listadoPacientesDTO.add(new PacienteDto(paciente));
        }


        return listadoPacientesDTO;
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

}
