package proyecto.odontologia.webapp.springboot_web.view.pdf;

import java.util.Map;

import java.awt.Color;
import com.lowagie.text.Font;
import com.lowagie.text.Element;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Document;
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
        
    // Título principal
        Font tituloFont = FontFactory.getFont(FontFactory.HELVETICA, 16, Font.BOLD);
        document.add(new Phrase("HISTORIA CLÍNICA GENERAL", tituloFont));
        document.add(new Phrase("\n\n")); // Espaciado

    // 1ra Fila: Encabezados (Lugar, Fecha)
    PdfPTable encabezado = new PdfPTable(2);
        encabezado.setWidthPercentage(100);
        encabezado.setWidths(new float[] { 3, 2 });

        PdfPCell cell = new PdfPCell(new Phrase("Lugar: _______________________"));
        cell.setBorder(0);
        encabezado.addCell(cell);

        cell = new PdfPCell(new Phrase("Fecha: ____/____/____"));
        cell.setBorder(0);
        encabezado.addCell(cell);
        document.add(encabezado);

    // 2da Fila: Odontologo y N° de Matricula
    PdfPTable segundaFila = new PdfPTable(2);
        segundaFila.setSpacingBefore(20);
        segundaFila.setWidthPercentage(100);
        segundaFila.setWidths(new float[] { 3, 1 });

        cell = new PdfPCell(new Phrase("ODONTOLOGO: "));
        cell.setPadding(18f);
        segundaFila.addCell(cell);

        cell = new PdfPCell(new Phrase("N° Matrícula: "));
        cell.setPadding(18f);
        segundaFila.addCell(cell);
        
        cell.setBackgroundColor(new Color(255, 255, 255));

        segundaFila.addCell(cell);
        document.add(segundaFila);

    // 3ra Fila: Paciente y N° Afil
    PdfPTable terceraFila = new PdfPTable(2);
        terceraFila.setSpacingBefore(25);
        terceraFila.setWidthPercentage(100);
        terceraFila.setWidths(new float[] { 2, 1.5f });

        cell = new PdfPCell(new Phrase("PACIENTE - " + paciente.getNombre() + " " + paciente.getApellido()));
        cell.setPadding(6f);
        terceraFila.addCell(cell);

        cell = new PdfPCell(new Phrase("N° AFIL: "));
        cell.setPadding(6f);
        terceraFila.addCell(cell);
        
        cell.setBackgroundColor(new Color(255, 255, 255));

        terceraFila.addCell(cell);
        document.add(terceraFila);

    // Informacion general del Paciente, Primera linea
    PdfPTable tablaInfo = new PdfPTable(3);
        tablaInfo.setWidthPercentage(100);
        tablaInfo.setSpacingBefore(10);
        tablaInfo.setWidths(new float[] { 2, 1, 1 });

        tablaInfo.addCell(createLabelCell("O. Social. _____________________________"));
        tablaInfo.addCell(createLabelCell("F. Nac. " + paciente.getFechaNacimiento().toString()));
        tablaInfo.addCell(createLabelCell("Tel. " + paciente.getTelefono()));
        document.add(tablaInfo);

    // Segunda linea
    PdfPTable tablaInfo2 = new PdfPTable(5);
        tablaInfo2.setWidthPercentage(100);
        tablaInfo2.setSpacingBefore(10);
        tablaInfo2.setWidths(new float[] { 1, 2.2f, 2.5f, 2, 2 });

        tablaInfo2.addCell(createLabelCell("Edad. " + String.valueOf(paciente.getEdad())));
        tablaInfo2.addCell(createLabelCell("Estado Civil. CASADO"));
        tablaInfo2.addCell(createLabelCell("Nacionalidad. " + paciente.getNacionalidad()));
        tablaInfo2.addCell(createLabelCell("N° de Doc. " + paciente.getDni()));
        tablaInfo2.addCell(createLabelCell("Cel. " + paciente.getTelefono()));
        document.add(tablaInfo2);

    // Tercera linea
    PdfPTable tablaInfo3 = new PdfPTable(1);
        tablaInfo3.setWidthPercentage(100);
        tablaInfo3.setSpacingBefore(10);
        tablaInfo3.setWidths(new float[] { 1 });

        tablaInfo3.addCell(createLabelCell("Domicilio (calle, num., barrio, localidad). ________________________________________________"));
        document.add(tablaInfo3);

    // Cuarta linea
    PdfPTable tablaInfo4 = new PdfPTable(4);
        tablaInfo4.setWidthPercentage(100);
        tablaInfo4.setSpacingBefore(10);
        tablaInfo4.setWidths(new float[] { 2, 1.5f, 2, 1.4f });

        tablaInfo4.addCell(createLabelCell("Profesión/Actividad. ________"));
        tablaInfo4.addCell(createLabelCell("Titular. _________"));
        tablaInfo4.addCell(createLabelCell("Lugar de Trabajo. _________"));
        tablaInfo4.addCell(createLabelCell("Jerarquía. ________"));
        document.add(tablaInfo4);

    // Separador
    PdfPTable separador = new PdfPTable(1);
        separador.setWidthPercentage(100);
        separador.setSpacingBefore(5);
        separador.setWidths(new float[] { 1 });

        separador.addCell(negrita("_____________________________________________________________________________________________"));
        document.add(separador);

    //Informacion General - EJEMPLO
    PdfPTable tabla1 = new PdfPTable(1);
        
        tabla1.setSpacingBefore(50);
        PdfPCell cell1 = null;
        cell1 = new PdfPCell(new Phrase("Información General"));
        cell1.setBackgroundColor(new Color(184, 218, 255));
        cell1.setPadding(8f);
        tabla1.addCell(cell1);
        document.add(tabla1);
//--
    PdfPTable tabla2 = new PdfPTable(6);
        // PdfPCell cell2 = null;
        // tabla2.
        tabla2.setWidths(new float[] { 7, 5, 6, 3, 6, 6 });
        tabla2.addCell("Paciente");
        // tabla2.addCell(new Paragraph("Paciente"));
        tabla2.addCell("DNI");
        tabla2.addCell("Fecha de Nacimiento");
        tabla2.addCell("Edad");
        tabla2.addCell("Teléfono");
        tabla2.addCell("Nacionalidad");

        tabla2.addCell(paciente.getNombre() + " " + paciente.getApellido());
        tabla2.addCell("" +paciente.getDni());
        tabla2.addCell(paciente.getFechaNacimiento().toString());
        tabla2.addCell(String.valueOf(paciente.getEdad()));
        tabla2.addCell(paciente.getTelefono());
        tabla2.addCell(paciente.getNacionalidad());
        tabla2.setSpacingAfter(20);
        document.add(tabla2);

    //Informacion Clinica
    PdfPTable tabla3 = new PdfPTable(1);
        tabla3.setSpacingAfter(20);

        PdfPCell cell3 = null;
        cell3 = new PdfPCell(new Phrase("Información Clínica"));
        cell3.setBackgroundColor(new Color(195, 230, 203));
        cell3.setPadding(8f);
        tabla3.addCell(cell3);
        document.add(tabla3);
        
        
        
    }

    private PdfPCell createLabelCell(String text) {
        Font font = new Font(Font.HELVETICA, 10, Font.NORMAL);
        PdfPCell cell = new PdfPCell(new Phrase(text, font));
        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
        cell.setBorder(0);
        return cell;
    }

    private PdfPCell negrita(String text) {
        Font font = new Font(Font.HELVETICA, 10, Font.BOLD);
        PdfPCell cell = new PdfPCell(new Phrase(text, font));
        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
        cell.setBorder(0);
        return cell;
    }
}
