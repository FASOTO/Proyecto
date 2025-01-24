package proyecto.odontologia.webapp.springboot_web.controller;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.nio.file.Path;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import proyecto.odontologia.webapp.springboot_web.models.Domicilio;
import proyecto.odontologia.webapp.springboot_web.models.Imagen;
import proyecto.odontologia.webapp.springboot_web.models.Paciente;
import proyecto.odontologia.webapp.springboot_web.services.PacienteService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/paciente")
public class PacienteController {

    @Autowired
    private PacienteService service;

    // Listar Pacientes
    @GetMapping("/listarPacientes")
    public String listarPacientes(Model model) {
        List<Paciente> listaPacientes = service.listarTodos();
        model.addAttribute("listadoPacientes", listaPacientes);
        model.addAttribute("titulo", "Listado de Pacientes");

        return "pacientes";
    }

    // 5) Doble click y muestra en informacionPaciente (13:38)
    @GetMapping("/informacionPaciente/{dni}")
    public String traerPaciente(@PathVariable(name = "dni") int dni, Model model) {
        Paciente pacienteEncontrado = service.buscarByDni(dni);
        int edadCalculada = pacienteEncontrado.getEdad();

        model.addAttribute("pacienteEncontrado", pacienteEncontrado);
        model.addAttribute("edadCalculada", edadCalculada);
        model.addAttribute("titulo", "Información Esencial");

        return "informacionPaciente";
    }

    // Ir a form de pacientes
    @GetMapping("/formPaciente")
    public String crearPaciente(Model model) {
        Paciente paciente = new Paciente();
        // domicilio
        Domicilio domicilio = new Domicilio();
        paciente.setDomicilio(domicilio);
        List<String> listaNacionalidad = service.listarNacionalidades();
        model.addAttribute("listaNacionalidad", listaNacionalidad);
        List<String> listaLocalidad = service.listarLocalidades();
        model.addAttribute("listaLocalidad", listaLocalidad);
        model.addAttribute("paciente", paciente);
        model.addAttribute("titulo", "FORMULARIO DE PACIENTE");
        model.addAttribute("botonGuardar", "Crear Paciente");

        // return "formPaciente"; // cambiar luego a conveniencia el nombre del html
        // mio
        return "formPaciente";
    }

    // Guardar un paciente
    @PostMapping("/guardar")
    public String guardar(Paciente paciente, @RequestParam("files") List<MultipartFile> imagenes) {

        File folder = new File("C://Paciente//Recursos");
        if (!folder.exists()) {
            if (folder.mkdirs()) {
                System.out.println("Multiples directorios fueron creados");
            } else {
                System.out.println("NO entro");
            }
        }
        List<Imagen> listaImagenes = new ArrayList<>();
        /*
         * if (!imagen.isEmpty()) {
         * String rutaAbsoluta = "C://Paciente//Recursos";
         * try {
         * byte[] bytesImg = imagen.getBytes();
         * Path rutaCompleta = Paths.get(rutaAbsoluta + "//" +
         * imagen.getOriginalFilename());
         * Files.write(rutaCompleta, bytesImg);
         * 
         * Imagen nuevaImagen = new Imagen();
         * 
         * nuevaImagen.setUrl(imagen.getOriginalFilename());
         * 
         * listaImagenes.add(nuevaImagen);
         * 
         * 
         * paciente.setImagenes(listaImagenes);
         * 
         * } catch (IOException e) {
         
         * e.printStackTrace();
         * }
         * 
         * }
         */

        for (MultipartFile imagen : imagenes) {
            if (!imagen.isEmpty()) {
                try {
                    // Generar un nombre único para la imagen
                    String nombreUnico = UUID.randomUUID().toString() + "_" + imagen.getOriginalFilename();
                    Path rutaCompleta = Paths.get("C://Paciente//Recursos" + "//" + nombreUnico);

                    // Guardar la imagen en el servidor
                    Files.write(rutaCompleta, imagen.getBytes());

                    // Crear objeto Imagen y agregarlo a la lista
                    Imagen nuevaImagen = new Imagen();
                    nuevaImagen.setUrl(nombreUnico);
                    listaImagenes.add(nuevaImagen);
                    paciente.setImagenes(listaImagenes);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        service.guardarPaciente(paciente);
        return "redirect:/paciente/listarPacientes";
    }

}
