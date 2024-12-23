package proyecto.odontologia.webapp.springboot_web.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import proyecto.odontologia.webapp.springboot_web.models.Paciente;
import proyecto.odontologia.webapp.springboot_web.services.PacienteService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;


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
        model.addAttribute("listadoPacientes", listaPacientes);
        model.addAttribute("titulo", "Listado de Pacientes");

        return "pacientes";
    }


// 4) Link y muestra en en Modal (funciona)
    @GetMapping("/informacionPaciente/{dni}")
    @ResponseBody
    public Map<String, Object> traerPaciente(@PathVariable(name = "dni") int dni) 
    {
        Paciente pacienteEncontrado = service.buscarByDni(dni);
        int edadCalculada = pacienteEncontrado.getEdad();
        
        // Se prepara la respuesta con la información del paciente y la edad
        Map<String, Object> response = new HashMap<>();
        response.put("paciente", pacienteEncontrado);
        response.put("edadCalculada", edadCalculada);
        
        return response;
    }


    //Ir a form de pacientes
    @GetMapping("/formPaciente")
    public String crearPaciente(Model model) 
    {
        Paciente paciente = new Paciente();
        List<String> listaNacionalidad = service.listarNacionalidades();
        model.addAttribute("listaNacionalidad", listaNacionalidad);
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
    

}
