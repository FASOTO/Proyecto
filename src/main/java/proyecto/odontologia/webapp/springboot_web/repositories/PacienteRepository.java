package proyecto.odontologia.webapp.springboot_web.repositories;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import proyecto.odontologia.webapp.springboot_web.models.Paciente;

@Repository
public class PacienteRepository {

    private List<Paciente> listadoPacientes;

    public PacienteRepository() 
    {
        listadoPacientes = new ArrayList<>();
        listadoPacientes.add(new Paciente("Daniel Ricciardo", 1120202020, 20, "Argentino", 45738293));
        listadoPacientes.add(new Paciente("Carlos Sainz", 388929912, 30, "Argentino", 34928422));
        listadoPacientes.add(new Paciente("Sergio Perez", 11292922, 25, "Argentino", 23839233));
        listadoPacientes.add(new Paciente("Franco Argentino", 11223231, 23, "Argentino", 129233));
    }

    public List<Paciente> listarTodos() 
    {
        return listadoPacientes;
    }

    //Buscar un paciente por su DNI
    public Paciente buscarByDni(int dni)
    {
        return listadoPacientes.stream()
            .filter(p -> p.getDni() == dni)
                .findFirst()
                    .orElse(null);
    }

    //Guardar un paciente (estaticamente)
    public void guardarPaciente(Paciente paciente)
    {
        listadoPacientes.add(paciente);
    }

}
