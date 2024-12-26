package proyecto.odontologia.webapp.springboot_web.view.pdf;

import java.util.Map;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import proyecto.odontologia.webapp.springboot_web.models.Paciente;

// Debe ir LA VISTA o lo que devuelve el controller en el método traerPaciente 
// (nose como hacer si es que devuelve un json)

@Component("pacientes")
// @Component("respuesta")
// @Component("pacientePDF")
public class PacientePDFView extends AbstractPdfView {

    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
            HttpServletRequest request, HttpServletResponse response) throws Exception 
    {
        // List<Paciente> pacientes = (List<Paciente>) model.get("listadoPacientes");
        Paciente paciente = (Paciente) model.get("paciente"); //Obtiene Paciente que se pasa a la vista en controller
        
        PdfPTable tabla = new PdfPTable(1);
        tabla.addCell("Datos de Paciente");
        tabla.addCell("Paciente: " + paciente.getApellido() + " " + paciente.getNombre());
        tabla.addCell("DNI: " + paciente.getDni());
        tabla.addCell("Fecha de Nacimiento: " + paciente.getFechaNacimiento());
        tabla.addCell("Edad: " + paciente.getEdad());
        tabla.addCell("Teléfono: " + paciente.getTelefono());
        tabla.addCell("Nacionalidad: " + paciente.getNacionalidad());

        // PdfPTable tabla2 = new PdfPTable(1);
        // Más datos

        document.add(tabla);
        
        // throw new UnsupportedOperationException("Unimplemented method 'buildPdfDocument'");
    }

}
