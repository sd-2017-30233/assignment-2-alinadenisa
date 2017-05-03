package service;
 import com.itextpdf.text.Document;
 import com.itextpdf.text.DocumentException;
 import com.itextpdf.text.Paragraph;
 import com.itextpdf.text.pdf.PdfWriter;
 import model.Book;

 import java.io.FileNotFoundException;
 import java.io.FileOutputStream;
 import java.util.List;

/**
 * Created by iliesalinadenisa on 03/05/2017.
 */
public class PDF extends iReport{

    public void report(){
        Document document = new Document();
        List<Book> booksOutOfStock = BookService.stock();
       try{
        PdfWriter writer = PdfWriter.getInstance(document, new FileOutputStream("pdfReport.pdf"));
        document.open();
        for(int i=0;i<booksOutOfStock.size();i++) {
            document.add(new Paragraph(booksOutOfStock.get(i).toString()));
        }
        document.close();
        writer.close();
    } catch (FileNotFoundException | DocumentException e) {
           e.printStackTrace();
       }
    }
}