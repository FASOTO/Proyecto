package proyecto.odontologia.webapp.springboot_web.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

import proyecto.odontologia.webapp.springboot_web.models.Paciente;
import proyecto.odontologia.webapp.springboot_web.services.PacienteService;

import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PacienteController {

    private PacienteService service = new PacienteService(); 

    @GetMapping("/pacientes")
    public String listarPacientes(Model model) 
    {
        model.addAttribute("title", "Prueba de Pacientes");
        return "pacientes"; //uso pacientes.html solo como ejemplo
    }

    @ModelAttribute("listadoPacientes")
    public List<Paciente> pacientesModel()
    {
        return service.listarTodos();
    }

    @GetMapping("/formPaciente")
    public String crearPaciente(Model model) {
        Paciente paciente = new Paciente();
        model.addAttribute("paciente", paciente);

        return "/formPaciente"; // cambiar luego a conveniencia el nombre del html
    }

    @PostMapping("/formPaciente")
	public String guardar(@Validated Paciente paciente, BindingResult result, Model model) {

        //listadoPacientes1.add(paciente);

        return "redirect:/pacientes";
	}

}
