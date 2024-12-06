package proyecto.odontologia.webapp.springboot_web.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import proyecto.odontologia.webapp.springboot_web.models.Paciente;

@Repository
public interface PacienteRepository {

    List<Paciente> listarTodos();
    Paciente buscarByDni(int dni);
    void guardarPaciente(Paciente paciente);

}
