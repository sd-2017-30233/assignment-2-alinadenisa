package controller;

import model.Book;
import model.User;
import service.BookService;
import service.CSV;
import service.PDF;
import service.UserLogic;
import view.AdminView;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Created by iliesalinadenisa on 03/05/2017.
 */
public class AdminController {
    AdminView adminView;
    BookService bookService;
    UserLogic userLogic;

    public AdminController(AdminView adminView, UserLogic userLogic, BookService bookService){
        this.adminView = adminView;
        this.userLogic = userLogic;
        this.bookService = bookService;
        this.adminView.addCreateUserListener(new CreateUserListener());
        this.adminView.addUpdateUserListener(new UpdateUserListener());
        this.adminView.addDeleteUserListener(new DeleteUserListener());
        this.adminView.addAddBookListener(new AddBookListener());
        this.adminView.addUpdateBookListener(new UpdateBookListener());
        this.adminView.addDeleteBookListener(new DeleteBookListener());
        this.adminView.addGenerateReportListener(new GenerateReportListener());
    }

    private class CreateUserListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String username = adminView.getUsernameUserField().getText();
            String password = adminView.getPasswordUserField().getText();
            String name = adminView.getNameUserField().getText();
            String isAdmin = adminView.getIsAdminUserField().getText();
            User user = new User(username,password,name,Boolean.valueOf(isAdmin));
            userLogic.addUser(user);
            JOptionPane.showMessageDialog(null, "User successfully added",
                    "Succes", JOptionPane.INFORMATION_MESSAGE);

            adminView.clear();

        }
    }

    private class UpdateUserListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String username = adminView.getUsernameUserField().getText();
            String password = adminView.getPasswordUserField().getText();
            String name = adminView.getNameUserField().getText();
            String isAdmin = adminView.getIsAdminUserField().getText();
            User user = new User(username,password,name,Boolean.valueOf(isAdmin));
            userLogic.updateUser(username,user);
            JOptionPane.showMessageDialog(null, "User successfully updated",
                    "Succes", JOptionPane.INFORMATION_MESSAGE);

            adminView.clear();

        }
    }

    private class DeleteUserListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String username = adminView.getUsernameUserField().getText();
            userLogic.deleteUser(username);
            JOptionPane.showMessageDialog(null, "User successfully deleted",
                    "Succes", JOptionPane.INFORMATION_MESSAGE);

            adminView.clear();
        }
    }

    private class AddBookListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String title = adminView.getTitleBookField().getText();
            String author = adminView.getAuthorBookField().getText();
            String gendre = adminView.getGendreBookField().getText();
            String quantityString = adminView.getQuantityBookField().getText();
            String priceString = adminView.getPriceBookField().getText();
            int quantity = Integer.parseInt(quantityString);
            int price = Integer.parseInt(priceString);
            Book book = new Book(title,author,gendre,quantity,price);
            bookService.addBook(book);
            JOptionPane.showMessageDialog(null, "Book successfully added",
                    "Succes", JOptionPane.INFORMATION_MESSAGE);

            adminView.clear();
        }
    }

    private class UpdateBookListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String title = adminView.getTitleBookField().getText();
            String author = adminView.getAuthorBookField().getText();
            String gendre = adminView.getGendreBookField().getText();
            String quantityString = adminView.getQuantityBookField().getText();
            String priceString = adminView.getPriceBookField().getText();
            int quantity = Integer.parseInt(quantityString);
            int price = Integer.parseInt(priceString);
            Book book = new Book(title,author,gendre,quantity,price);
            bookService.updateBook(title,book);
            JOptionPane.showMessageDialog(null, "Book successfully updated",
                    "Succes", JOptionPane.INFORMATION_MESSAGE);

            adminView.clear();
        }
    }

    private class DeleteBookListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String title = adminView.getTitleBookField().getText();
            bookService.deleteBook(title);
            JOptionPane.showMessageDialog(null, "Book successfully deleted",
                    "Succes", JOptionPane.INFORMATION_MESSAGE);

            adminView.clear();

        }
    }

    private class GenerateReportListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            PDF pdf = new PDF();
            CSV csv = new CSV();
            pdf.report();
            csv.report();
            JOptionPane.showMessageDialog(null, "Report successfully generated",
                    "Succes", JOptionPane.INFORMATION_MESSAGE);

        }
    }
}
