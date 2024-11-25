package proyecto.odontologia.webapp.springboot_web.repositories;

import java.util.Arrays;
import java.util.List;

import proyecto.odontologia.webapp.springboot_web.models.Paciente;

public class PacienteRepository {

    public List<Paciente> listarTodos() {
        List<Paciente> listadoPacientes = Arrays.asList(
            new Paciente("Daniel Ricciardo", 1120202020, 20, "Argentino", 45738293),
            new Paciente("Carlos Sainz", 388929912, 30, "Argentino", 34928422),
            new Paciente("Sergio Perez", 11292922, 25, "Argentino", 23839233),
            new Paciente("Franco Argentino", 11223231, 23, "Argentino", 129233)
        );
        return listadoPacientes;
    }

}
