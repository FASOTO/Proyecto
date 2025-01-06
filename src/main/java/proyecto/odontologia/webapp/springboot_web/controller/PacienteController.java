package proyecto.odontologia.webapp.springboot_web.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import proyecto.odontologia.webapp.springboot_web.models.Domicilio;
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
        model.addAttribute("listadoPacientes", listaPacientes);
        model.addAttribute("titulo", "Listado de Pacientes");

        return "pacientes";
    }

//5) Doble click y muestra en informacionPaciente (13:38)
    @GetMapping("/informacionPaciente/{dni}")
    public String traerPaciente(@PathVariable(name = "dni") int dni, Model model) 
    {
        Paciente pacienteEncontrado = service.buscarByDni(dni);
        int edadCalculada = pacienteEncontrado.getEdad();
        
        model.addAttribute("pacienteEncontrado", pacienteEncontrado);
        model.addAttribute("edadCalculada", edadCalculada);
        model.addAttribute("titulo", "Informacion esencial");

        return "informacionPaciente";
    }

    //Ir a form de pacientes
    @GetMapping("/formPaciente")
    public String crearPaciente(Model model) 
    {
        Paciente paciente = new Paciente();
        //domicilio
        Domicilio domicilio = new Domicilio();
        paciente.setDomicilio(domicilio);
        List<String> listaNacionalidad = service.listarNacionalidades();
        model.addAttribute("listaNacionalidad", listaNacionalidad);
        List<String> listaLocalidad = service.listarLocalidades();
        model.addAttribute("listaLocalidad", listaLocalidad);
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
