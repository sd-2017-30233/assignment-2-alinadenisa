package service;

import controller.AdminController;
import controller.UserController;
import model.Book;
import model.User;
import view.AdminView;
import view.UserView;

/**
 * Created by iliesalinadenisa on 03/05/2017.
 */
public class Main {

    public static void main(String[] args) {
        BookService bookService = new BookService();
        UserLogic userLogic = new UserLogic();
        //uService uService = new uService();
        Book book = new Book();
        book.setTitle("Peter Pan");
        book.setAuthor("Author");
        bookService.sell(book,5);
        User user = new User();
        user.setName("cata");
        String username ="cata";
        user.setUsername("cata");
        user.setPassword("123");
        user.setAdmin(false);
     //   uService.addUser(user);
   //    boolean ok = uService.isUserAdmin("cata");
//       System.out.println(ok);
       PDF pdf = new PDF();
       //pdf.report();
       CSV csv = new CSV();
       csv.report();
        AdminView adminView = new AdminView();
        UserView userView = new UserView();
        AdminController adminController = new AdminController(adminView,userLogic,bookService);
        UserController userController = new UserController(userView,bookService);
    }
}
