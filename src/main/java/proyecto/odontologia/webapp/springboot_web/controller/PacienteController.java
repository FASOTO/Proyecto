package proyecto.odontologia.webapp.springboot_web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import proyecto.odontologia.webapp.springboot_web.models.Paciente;
import proyecto.odontologia.webapp.springboot_web.services.PacienteService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/paciente")
public class PacienteController {

    @Autowired
    private PacienteService service; 

    //Listar Pacientes
    @GetMapping("/listarPacientes")
    public List<Paciente> listarPacientes() 
    {
        return service.listarTodos();
    }

    //Buscar un paciente por su DNI
    @GetMapping("/{dni}")
    public Paciente mostrarPaciente(@PathVariable int dni)
    {
        return service.buscarByDni(dni);
    }

    @ModelAttribute("listadoPacientes")
    public List<Paciente> pacientesModel()
    {
        return service.listarTodos();
    }

    //Ir a form de pacientes
    @GetMapping("/formPaciente")
    public String crearPaciente(Model model) {
        Paciente paciente = new Paciente();
        model.addAttribute("paciente", paciente);

        return "/formPaciente"; // cambiar luego a conveniencia el nombre del html
    }

    //Guardar un paciente
    @PostMapping("/guardar")
	public Paciente guardar(@RequestBody Paciente paciente) {

        service.guardarPaciente(paciente);

        return paciente;
	}

}
