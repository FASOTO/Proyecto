package proyecto.odontologia.webapp.springboot_web.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import proyecto.odontologia.webapp.springboot_web.models.Paciente;
import proyecto.odontologia.webapp.springboot_web.repositories.IPacienteRepository;

@Service
public class PacienteService {

    @Autowired
    IPacienteRepository repository;

    public List<Paciente> listarTodos() {
        List<Paciente> listadoPacientes = (List<Paciente>) repository.findAll();
        return listadoPacientes;
    }

    public List<String> listarNacionalidades() {
        // nueva función

        // defini una lista con 3 nacionalidades
        List<String> nacionalidades = new ArrayList<>();
        nacionalidades.add("Argentina");
        nacionalidades.add("Bolivia");
        nacionalidades.add("Chile");

        //List<String> Nacionalidades = (List<String>) repository.findNacionalidad();
        return nacionalidades;
    }

    // Buscar un paciente por su DNI
    public Paciente buscarByDni(int dni) {
        return repository.findByDni(dni);
    }

    // Guardar un paciente (estaticamente)
    @Transactional
    public void guardarPaciente(Paciente paciente) {
        repository.save(paciente);
    }
    public List<String> listarLocalidades() {
        // nueva función

        // defini una lista con 3 nacionalidades
        List<String> nacionalidades = new ArrayList<>();
        nacionalidades.add("San Salvador de Jujuy");
        nacionalidades.add("San Pedro de Jujuy");
        nacionalidades.add("Libertador General San Martín");
        nacionalidades.add("La Quiaca");
        nacionalidades.add("Humahuaca");
        nacionalidades.add("Tilcara");
        nacionalidades.add("Purmamarca");
        nacionalidades.add("El Carmen");
        nacionalidades.add("Perico");
        nacionalidades.add("Palpalá");
        nacionalidades.add("Monterrico");
        nacionalidades.add("Abra Pampa");
        nacionalidades.add("Maimará");
        nacionalidades.add("Calilegua");
        nacionalidades.add("Caimancito");
        nacionalidades.add("Fraile Pintado");
        nacionalidades.add("La Esperanza");
        nacionalidades.add("Palma Sola");
        nacionalidades.add("Yuto");

        //List<String> Nacionalidades = (List<String>) repository.findNacionalidad();
        return nacionalidades;
    }


}
