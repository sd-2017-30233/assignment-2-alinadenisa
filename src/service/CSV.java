package service;

import model.Book;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

/**
 * Created by iliesalinadenisa on 03/05/2017.
 */
public class CSV extends iReport {
    public void report() {
        FileWriter fileWriter = null;
        List<Book> booksOutOfStock = BookService.stock();
        final String COMMA_DELIMITER = ",";
        final String NEW_LINE_SEPARATOR = "\n";
        final String FILE_HEADER = "title,author,gender,quantity,price";
        try {
             fileWriter = new FileWriter("csvReport.csv");
            fileWriter.append(FILE_HEADER);
            fileWriter.append(NEW_LINE_SEPARATOR);
            for (Book book : booksOutOfStock) {
                fileWriter.append(book.getTitle());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(book.getAuthor());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(book.getGendre());
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(book.getQuantity()));
                fileWriter.append(COMMA_DELIMITER);
                fileWriter.append(String.valueOf(book.getPrice()));
                fileWriter.append(NEW_LINE_SEPARATOR);

            }
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fileWriter.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fileWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
