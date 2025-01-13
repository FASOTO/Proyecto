package proyecto.odontologia.webapp.springboot_web.view.pdf;

import java.util.Map;

import java.awt.Color;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import com.lowagie.text.Font;
import com.lowagie.text.Element;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.lowagie.text.Chunk;
import com.lowagie.text.Document;
import com.lowagie.text.Phrase;
import com.lowagie.text.Image;
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

    // Numero de Pagina
    PdfPTable tablaInfo = new PdfPTable(1);
    tablaInfo.setWidthPercentage(100);
        tablaInfo.setSpacingAfter(20);
        tablaInfo.setWidths(new float[] { 1 });

        Image numero = Image.getInstance("src/main/resources/static/images/01.png");
        numero.scaleToFit(50, 50);
        PdfPCell cell = new PdfPCell(numero);
        cell.setBorder(0);
        cell.setHorizontalAlignment(Element.ALIGN_CENTER); // Alinear imagen a la izquierda

        tablaInfo.addCell(cell);
        document.add(tablaInfo);

    // Logo y Titulo
    tablaInfo = new PdfPTable(2);
        tablaInfo.setWidthPercentage(100);
        tablaInfo.setSpacingAfter(20);
        tablaInfo.setWidths(new float[] { 1, 4 }); 

    // IMAGEN
        Image logo = Image.getInstance("src/main/resources/static/images/icono2.jpg");
        logo.scaleToFit(60, 60);
        cell = new PdfPCell(logo);
        cell.setBorder(0);
        cell.setHorizontalAlignment(Element.ALIGN_RIGHT); // Alinear imagen a la izquierda
        cell.setPaddingTop(-35);

    // TÍTULO
        Chunk chunkSubrayado = new Chunk("HISTORIA CLÍNICA GENERAL", new Font(Font.HELVETICA, 16, Font.BOLD));
        chunkSubrayado.setUnderline(0.5f, -2f); // (grosor, posición)

        Phrase fraseSubrayada = new Phrase(chunkSubrayado);
        PdfPCell cellTitulo = new PdfPCell(fraseSubrayada);
        cellTitulo.setBorder(0);
        cellTitulo.setHorizontalAlignment(Element.ALIGN_LEFT);
        cellTitulo.setPaddingTop(-5);
        cellTitulo.setPaddingLeft(50);

        tablaInfo.addCell(cell);
        tablaInfo.addCell(cellTitulo);
        document.add(tablaInfo);


    // 1ra Fila: Encabezados (Lugar, Fecha)
    tablaInfo = new PdfPTable(2);
        tablaInfo.setWidthPercentage(100);
        tablaInfo.setWidths(new float[] { 3, 1 });

        cell = new PdfPCell(formato("Lugar: ", "Independencia 922"));
        cell.setBorder(0);
        tablaInfo.addCell(cell);

        LocalDate hoy = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formatoHoy = hoy.format(formatter);
        cell = new PdfPCell(formato("Fecha: ", formatoHoy));
        cell.setBorder(0);
        tablaInfo.addCell(cell);
        document.add(tablaInfo);

    // 2da Fila: Odontologo y N° de Matricula
    tablaInfo = new PdfPTable(2);
        tablaInfo.setSpacingBefore(20);
        tablaInfo.setWidthPercentage(100);
        tablaInfo.setWidths(new float[] { 3, 1 });

        cell = new PdfPCell(formato("ODONTOLOGO: ", "Nombre Apellido")); //Reemplazar por el valor
        cell.setPadding(18f);
        tablaInfo.addCell(cell);

        cell = new PdfPCell(formato("N° Matrícula ", "00000")); //Reemplazar por el valor
        cell.setPadding(18f);
        tablaInfo.addCell(cell);
        
        cell.setBackgroundColor(new Color(255, 255, 255));

        tablaInfo.addCell(cell);
        document.add(tablaInfo);

    // 3ra Fila: Paciente y N° Afil
    tablaInfo = new PdfPTable(2);
        tablaInfo.setSpacingBefore(25);
        tablaInfo.setWidthPercentage(100);
        tablaInfo.setWidths(new float[] { 2, 1.5f });

        cell = new PdfPCell(formato("PACIENTE - ", paciente.getNombre() + " " + paciente.getApellido()));
        cell.setPadding(6f);
        tablaInfo.addCell(cell);

        cell = new PdfPCell(formato("N° AFIL: ", "0000")); //Reemplazar por el valor
        cell.setPadding(6f);
        tablaInfo.addCell(cell);
        
        cell.setBackgroundColor(new Color(255, 255, 255));

        tablaInfo.addCell(cell);
        document.add(tablaInfo);

    // Informacion general del Paciente, Primera linea
    tablaInfo = new PdfPTable(3);
        tablaInfo.setWidthPercentage(100);
        tablaInfo.setSpacingBefore(10);
        tablaInfo.setWidths(new float[] { 2, 1, 1 });

        cell = new PdfPCell(formatito("O. Social. ", "obraSocial"));
        terminar(cell, tablaInfo);

        cell = new PdfPCell(formatito("F. Nac. ", paciente.getFechaNacimiento().toString()));
        terminar(cell, tablaInfo);

        cell = new PdfPCell(formatito("Tel. ", paciente.getTelefono()));
        terminar(cell, tablaInfo);

        document.add(tablaInfo);

    // Segunda linea
    tablaInfo = new PdfPTable(5);
        tablaInfo.setWidthPercentage(100);
        tablaInfo.setSpacingBefore(10);
        tablaInfo.setWidths(new float[] { 1, 2.2f, 2.5f, 2, 2 });

        cell = new PdfPCell(formatito("Edad. ", String.valueOf(paciente.getEdad())));
        terminar(cell, tablaInfo);

        cell = new PdfPCell(formatito("Estado Civil. ", "estado"));
        terminar(cell, tablaInfo);

        cell = new PdfPCell(formatito("Nacionalidad. ", paciente.getNacionalidad()));
        terminar(cell, tablaInfo);

        cell = new PdfPCell(formatito("N° de Doc. ", String.valueOf(paciente.getDni())));
        terminar(cell, tablaInfo);
        
        // tablaInfo.addCell(createLabelCell("Cel. " + paciente.getTelefono()));
        cell = new PdfPCell(formatito("Cel. ", paciente.getTelefono()));
        terminar(cell, tablaInfo);
        

        document.add(tablaInfo);

    // Tercera linea
    tablaInfo = new PdfPTable(1);
        tablaInfo.setWidthPercentage(100);
        tablaInfo.setSpacingBefore(10);
        tablaInfo.setWidths(new float[] { 1 });

        cell = new PdfPCell
            (formatito("Domicilio (calle, num., barrio, localidad). ", 
                        paciente.getDomicilio().getCalle() 
                        + " " + paciente.getDomicilio().getNroCalle() 
                        + ", " + paciente.getDomicilio().getBarrio() 
                        + ", " + paciente.getDomicilio().getLocalidad()
                    )
            );

        terminar(cell, tablaInfo);
        document.add(tablaInfo);

    // Cuarta linea
    tablaInfo = new PdfPTable(4);
        tablaInfo.setWidthPercentage(100);
        tablaInfo.setSpacingBefore(10);
        tablaInfo.setWidths(new float[] { 2, 1.5f, 2, 1.4f });

        cell = new PdfPCell(formatito("Profesión/Actividad. ", "profesion"));
        terminar(cell, tablaInfo);

        cell = new PdfPCell(formatito("Titular. ", paciente.getNombre() + " " + paciente.getApellido()));
        terminar(cell, tablaInfo);

        cell = new PdfPCell(formatito("Lugar de Trabajo. ", "lugar"));
        terminar(cell, tablaInfo);

        cell = new PdfPCell(formatito("Jerarquía. ", "jerarquia"));
        terminar(cell, tablaInfo);

        document.add(tablaInfo);

    // Separador
    tablaInfo = new PdfPTable(1);
        tablaInfo.setWidthPercentage(100);
        tablaInfo.setSpacingBefore(5);
        tablaInfo.setWidths(new float[] { 1 });

        tablaInfo.addCell(negrita("_____________________________________________________________________________"));
        document.add(tablaInfo);

    // Si/No
        // document.add(new Paragraph("Padre con vida?  Si / No"));
        // document.add(new Paragraph("Enfermedad que padece o padeció: ............................................................"));
        // document.add(new Paragraph("\n")); // Espacio en blanco
        
    // Odontograma
    tablaInfo = new PdfPTable(1);
        tablaInfo.setWidthPercentage(100);
        tablaInfo.setSpacingBefore(10);
        tablaInfo.setWidths(new float[] { 1 });

        cell = new PdfPCell(negrita("ODONTROGRAMA:"));
        terminar(cell, tablaInfo);
        document.add(tablaInfo);

    }

    // private PdfPCell createLabelCell(String text) {
    //     Font font = new Font(Font.HELVETICA, 16, Font.BOLD);
    //     PdfPCell cell = new PdfPCell(new Phrase(text, font));
    //     cell.setHorizontalAlignment(Element.ALIGN_LEFT);
    //     cell.setBorder(0);
    //     return cell;
    // }

    private Phrase formato(String titulo, String texto)
    {
        Phrase phrase = new Phrase();
        phrase.add(new Chunk(titulo, new Font(Font.HELVETICA, 12, Font.BOLD))); // Título en negrita
        phrase.add(new Chunk(texto, new Font(Font.HELVETICA, 12, Font.NORMAL))); // Texto normal
        return phrase;
    }

    private Phrase formatito(String titulo, String texto)
    {
        Phrase phrase = new Phrase();
        phrase.add(new Chunk(titulo, new Font(Font.HELVETICA, 10, Font.BOLD))); // Título en negrita
        phrase.add(new Chunk(texto, new Font(Font.HELVETICA, 10, Font.NORMAL))); // Texto normal
        return phrase;
    }

    private void terminar(PdfPCell cell, PdfPTable tablaInfo)
    {
        cell.setBorder(0);
        tablaInfo.addCell(cell);
    }

    private PdfPCell negrita(String text) {
        Font font = new Font(Font.HELVETICA, 12, Font.BOLD);
        PdfPCell cell = new PdfPCell(new Phrase(text, font));
        cell.setHorizontalAlignment(Element.ALIGN_LEFT);
        cell.setBorder(0);
        return cell;
    }
}
