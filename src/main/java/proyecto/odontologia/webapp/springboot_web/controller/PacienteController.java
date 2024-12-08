package proyecto.odontologia.webapp.springboot_web.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;

import proyecto.odontologia.webapp.springboot_web.models.Paciente;
import proyecto.odontologia.webapp.springboot_web.services.PacienteService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/paciente")
public class PacienteController {

    @Autowired
    private PacienteService service; 

    //Listar Pacientes
    @GetMapping("/listarPacientes")
    public String listarPacientes(Model model) 
    {
        List<Paciente> listaPacientes = service.listarTodos();

        List<Map<String, Object>> pacientesConEdad = listaPacientes.stream().map(paciente -> {
            
            Map<String, Object> pacientesData = new HashMap<>();
            pacientesData.put("paciente", paciente);
            pacientesData.put("edad", service.calcularEdad(paciente));
            return pacientesData;

        }).toList();

        // model.addAttribute("listadoPacientes", listaPacientes);
        model.addAttribute("listadoPacientes", pacientesConEdad);
        model.addAttribute("titulo", "Listado de Pacientes");

        return "pacientes";
    }

    //Buscar un paciente por su DNI
    @GetMapping("/{dni}")
    public String mostrarPaciente(@PathVariable int dni, Model model)
    {
        Paciente pacienteEncontrado = service.buscarByDni(dni); 

        model.addAttribute("pacientePorDni", pacienteEncontrado);
        model.addAttribute("titulo", "Paciente encontrado");
        model.addAttribute("edadCalculada", service.calcularEdad(pacienteEncontrado));

        return "informacionPaciente";
    }

    // @ModelAttribute("listadoPacientes")
    // public List<Paciente> pacientesModel()
    // {
    //     return service.listarTodos();
    // }

    //Ir a form de pacientes
    @GetMapping("/formPaciente")
    public String crearPaciente(Model model) 
    {
        Paciente paciente = new Paciente();
        model.addAttribute("paciente", paciente);
        model.addAttribute("titulo", "FORMULARIO DE PACIENTE");
        model.addAttribute("botonGuardar", "Crear Paciente");

        return "formPaciente"; // cambiar luego a conveniencia el nombre del html
    }

    //Guardar un paciente
    @PostMapping("/guardar")
	public String guardar(Paciente paciente) 
    {
        
        service.guardarPaciente(paciente);

        return "redirect:/paciente/listarPacientes";
	}


    

    @ModelAttribute("nacionalidades")
	public List<String> nacionalidades()
	{
		return Arrays.asList("Argentina", "Bolivia", "Brasil", "Colombia", "Chile", "Ecuador", 
				"Guatemala", "Mexico", "Paraguay", "Peru", "Uruguay", "Venezuela");
	}



}
