package controller;

import model.Book;
import service.BookService;
import view.UserView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by iliesalinadenisa on 03/05/2017.
 */
public class UserController {
    UserView userView ;
    BookService bookService ;

    public UserController(UserView userView,BookService bookService){
     this.userView = userView;
     this.bookService = bookService;
     this.userView.addSearchByGenderListener(new SearchByGenderListener());
     this.userView.addSearchByAuthorListener(new SearchByAuthorListener());
     this.userView.addSearchByTitleListener(new SearchByTitleListener());
     this.userView.addSellBookListener(new SellBookListener());
    }

    private class SearchByGenderListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            List<Book> bookList;
            String gender = userView.getGendreBookField().getText();
            bookList = bookService.searchByGenre(gender);
            for(Book book : bookList){
                System.out.println(book.toString());
                userView.getTextArea().append(book.toString());
            }
        }
    }

    private class SearchByAuthorListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
        List<Book> bookList;
        String author = userView.getAuthorBookField().getText();
        bookList = bookService.searchByAuthor(author);
            for(Book book : bookList){
                System.out.println(book.toString());
                userView.getTextArea().append(book.toString());
            }
        }
    }

    private class SearchByTitleListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            List<Book> bookList;
            String title = userView.getTitleBookField().getText();
            bookList = bookService.searchByTitle(title);
            for(Book book : bookList){
                System.out.println(book.toString());
                userView.getTextArea().append(book.toString());
            }
        }
    }

    private class SellBookListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Book book = new Book();
            String title = userView.getTitleBookField().getText();
            book.setTitle(title);
            String quantityString = userView.getQuantityBookField().getText();
            int quantity = Integer.parseInt(quantityString);
            bookService.sell(book,quantity);
        }
    }
}
