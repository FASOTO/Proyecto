package proyecto.odontologia.webapp.springboot_web.repositories;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Repository;

import proyecto.odontologia.webapp.springboot_web.models.Paciente;

@Repository
public class PacienteRepository {

    private List<Paciente> listadoPacientes;

    public PacienteRepository() 
    {
        listadoPacientes = new ArrayList<>();
        listadoPacientes.add(new Paciente("Daniel Ricciardo", 1120202020, "Argentino", 45738293, LocalDate.of(2004, 04, 28)));
        listadoPacientes.add(new Paciente("Carlos Sainz", 388929912, "Argentino", 34928422, LocalDate.of(2003, 03, 14)));
        listadoPacientes.add(new Paciente("Sergio Perez", 11292922, "Argentino", 23839233, LocalDate.of(2000, 07, 02)));
        listadoPacientes.add(new Paciente("Franco Argentino", 11223231, "Argentino", 129233, LocalDate.of(1990, 03, 01)));
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


    // --------------------------------------------
    //Ejemplo, para formatear la fecha a la hora de mostrar
    // LocalDate fecha = LocalDate.of(1994, 9, 1);
    // String fechaFormateada = fecha.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
    // System.out.println(fechaFormateada); // Imprime: 01/09/1994
}
