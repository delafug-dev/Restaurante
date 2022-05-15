package utilidades;
import modelos.CuentaPDF;
import modelos.TotalesComanda;
import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.pdmodel.PDPage;
import org.apache.pdfbox.pdmodel.PDPageContentStream;
import org.apache.pdfbox.pdmodel.common.PDRectangle;
import org.apache.pdfbox.pdmodel.font.PDType1Font;
import org.apache.pdfbox.pdmodel.graphics.image.PDImageXObject;
import windows.camarero.Cuenta;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class UtilidadesPDF {

    public static void GenerarCuentaPDF(CuentaPDF cuenta){

        try {

            //Creamos un Objete de tipo documento pdf
            PDDocument document = new PDDocument();

            //Creamos una página para el documento
            PDPage page1 = new PDPage(PDRectangle.A6);
            document.addPage(page1);


            //Abrir el documento
            PDPageContentStream contentStream = new PDPageContentStream(document, page1);

            // Image
            PDImageXObject pdImage = PDImageXObject.createFromFile(new File("").getAbsolutePath() +"\\imagenes\\logo_restaurante.png", document);
            contentStream.drawImage(pdImage, 40, 10, pdImage.getWidth() / 3, pdImage.getHeight() / 3);

            //Escribimos en la página
            contentStream.beginText();

            //ESTILOS
            contentStream.setFont(PDType1Font.TIMES_BOLD, 12);
            contentStream.newLineAtOffset( 10, page1.getMediaBox().getHeight() - 22);
            contentStream.setLeading(18.5f);

            contentStream.showText("Número de Mesa: " + cuenta.getNum_mesa());
            contentStream.newLine();
            contentStream.showText("Camarero: " + cuenta.getNombre_camarero());
            contentStream.newLine();
            contentStream.newLine();




            //CABECERAS
            contentStream.showText("PRODUCTO");
            contentStream.newLineAtOffset(120, 0);
            contentStream.showText("CANTIDAD");
            contentStream.newLineAtOffset(105, 0);
            contentStream.showText("PRECIO");
            contentStream.newLine();
            contentStream.newLineAtOffset(-225, 0);


            //PRODUCTOS
            for(TotalesComanda t : cuenta.getTotalesComandas()){
                contentStream.showText(t.getNombre_producto());
                contentStream.newLineAtOffset(150, 0);
                contentStream.showText(t.getCantidad_pedida().toString());
                contentStream.newLineAtOffset(100, 0);
                contentStream.showText(t.getPrecio_total().toString());
                contentStream.newLine();
                contentStream.newLineAtOffset(-250, 0);

            }

            contentStream.newLine();
            contentStream.showText("TOTAL");
            contentStream.newLineAtOffset(250, 0);
            contentStream.showText(cuenta.getTotalCuenta().toString());
            contentStream.endText();

            //LINEAS NEGRAS
            PDRectangle bbox = page1.getBBox();
            contentStream.moveTo(bbox.getLowerLeftX() ,360);
            contentStream.lineTo(bbox.getUpperRightX(),360);
            contentStream.setLineWidth( 2f);
            contentStream.stroke();

            contentStream.moveTo(bbox.getLowerLeftX() ,2);
            contentStream.lineTo(bbox.getUpperRightX(),2);
            contentStream.setLineWidth( 2f );
            contentStream.stroke();


            contentStream.close();

            LocalDateTime fecha = LocalDateTime.now();
            String identificadorFactura = ""
                    + fecha.getDayOfMonth()
                    + fecha.getMonth()
                    + fecha.getYear()
                    + fecha.getHour()
                    + fecha.getMinute()
                    + fecha.getSecond();

            document.save("cuenta"+cuenta.getNum_mesa()+"_"+identificadorFactura +".pdf");

        }catch (Exception e){
            System.out.println(e.getMessage());
        }



    }


}
