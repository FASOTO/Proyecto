package proyecto.odontologia.webapp.springboot_web.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import proyecto.odontologia.webapp.springboot_web.models.Paciente;


@Controller
public class PacienteController {

    @GetMapping("/pacientes")
    public String listarPacientes(Model model) 
    {
        model.addAttribute("title", "Prueba de Pacientes");
        return "pacientes"; //uso pacientes.html solo como ejemplo
    }

    @ModelAttribute("listadoPacientes")
    public List<Paciente> pacientesModel()
    {
        List<Paciente> listadoPacientes = Arrays.asList(
            new Paciente("Daniel Ricciardo", 1120202020, 20, "Argentino", 45738293),
            new Paciente("Carlos Sainz", 388929912, 30, "Argentino", 34928422),
            new Paciente("Sergio Perez", 11292922, 25, "Argentino", 23839233)
        );

        return listadoPacientes;
    }
    

}
