package proyecto.odontologia.webapp.springboot_web.services;

import java.util.List;


import proyecto.odontologia.webapp.springboot_web.models.Paciente;

public interface PacienteService {

    List<Paciente> listarTodos();
    Paciente buscarByDni(int dni);
    void guardarPaciente(Paciente paciente);

}
