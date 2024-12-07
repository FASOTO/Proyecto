package proyecto.odontologia.webapp.springboot_web.repositories;

import java.util.List;

import org.springframework.stereotype.Repository;

import proyecto.odontologia.webapp.springboot_web.models.Paciente;

@Repository
public class PacienteRepository {

    private List<Paciente> listadoPacientes;

    public PacienteRepository() 
    {
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
