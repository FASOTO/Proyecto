package proyecto.odontologia.webapp.springboot_web.view.pdf;

import java.util.Map;

import java.awt.Color;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
import com.lowagie.text.Paragraph;
import com.lowagie.text.Phrase;
import com.lowagie.text.FontFactory;

import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import proyecto.odontologia.webapp.springboot_web.models.Paciente;

@Component("informacionPaciente")
public class PacientePDFView extends AbstractPdfView {

    @Override
    protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
            HttpServletRequest request, HttpServletResponse response) throws Exception 
    {
        Paciente paciente = (Paciente) model.get("pacienteEncontrado"); //Obtiene Paciente que se pasa a la vista en controller      
        // PdfFont font = PdfFontFactory.createFont(FontConstants.TIMES_ITALIC);
    //Informacion General
    PdfPTable tabla1 = new PdfPTable(1);

        PdfPCell cell1 = null;
        cell1 = new PdfPCell(new Phrase("Información General"));
        cell1.setBackgroundColor(new Color(184, 218, 255));
        cell1.setPadding(8f);
        tabla1.addCell(cell1);
//--
        PdfPTable tabla2 = new PdfPTable(6);
        // PdfPCell cell2 = null;
        // tabla2.
        tabla2.setWidths(new float[] { 7, 5, 6, 3, 6, 6 });
        tabla2.addCell("Paciente");
        tabla2.addCell(new Paragraph("Paciente"));
        tabla2.addCell("DNI");
        tabla2.addCell("Fecha de Nacimiento");
        tabla2.addCell("Edad");
        tabla2.addCell("Teléfono");
        tabla2.addCell("Nacionalidad");
        // cell2.setHorizontalAlignment(PdfPCell.ALIGN_CENTER);

        tabla2.addCell(paciente.getNombre() + " " + paciente.getApellido());
        tabla2.addCell("" +paciente.getDni());
        tabla2.addCell(paciente.getFechaNacimiento().toString());
        tabla2.addCell(String.valueOf(paciente.getEdad()));
        tabla2.addCell(paciente.getTelefono());
        tabla2.addCell(paciente.getNacionalidad());
        tabla2.setSpacingAfter(20);


    //Informacion Clinica
    PdfPTable tabla3 = new PdfPTable(1);
        tabla3.setSpacingAfter(20);

        PdfPCell cell3 = null;
        cell3 = new PdfPCell(new Phrase("Información Clínica"));
        cell3.setBackgroundColor(new Color(195, 230, 203));
        cell3.setPadding(8f);
        tabla3.addCell(cell3);

        document.add(tabla1);
        document.add(tabla2);
        document.add(tabla3);
    }

}
