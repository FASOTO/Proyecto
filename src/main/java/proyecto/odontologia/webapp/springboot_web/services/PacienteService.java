package proyecto.odontologia.webapp.springboot_web.services;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import proyecto.odontologia.webapp.springboot_web.models.Paciente;
import proyecto.odontologia.webapp.springboot_web.repositories.PacienteRepository;

@Service
public class PacienteService {

    @Autowired
    PacienteRepository repository;

    public List<Paciente> listarTodos()
    {
        return repository.listarTodos();
    }

    //Buscar un paciente por su DNI
    public Paciente buscarByDni(int dni)
    {
        Paciente paciente = repository.buscarByDni(dni);
        return paciente;
    }

    //Guardar un paciente (estaticamente)
    public void guardarPaciente(Paciente paciente)
    {
        repository.guardarPaciente(paciente);
    }

    //Calcular edad mediante fechaNacimiento
    //No guardar EDAD, solo mostrar
    public int calcularEdad(Paciente paciente)
    {
        LocalDate hoy = LocalDate.now();
        LocalDate fechaNacimiento = paciente.getFechaNacimiento();

        if(fechaNacimiento != null)
        {
            int edadCalculada = Period.between(fechaNacimiento, hoy).getYears();
            return edadCalculada;
        }
        else
        {
            System.out.println("la fecha de nacimiento es nula");
            return 0;
        }

    }




}
