package view;

import model.User;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * Created by iliesalinadenisa on 03/05/2017.
 */
public class UserView extends JFrame {
    private JFrame frame = new JFrame();
    private JPanel panel;
    private JButton searchByGender;
    private JButton searchByTitle;
    private JButton searchByAuthor;
    private JButton sellBooks;

    private JTextField titleBookField;
    private JTextField authorBookField;
    private JTextField gendreBookField;
    private JTextField quantityBookField;
    private JTextArea textArea;

    public UserView(){
        initComponents();
    }

    private void initComponents() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("User");
        frame.setSize(800, 600);
        frame.setResizable(false);
        frame.setVisible(true);
        panel = new JPanel();
        frame.add(panel);
        panel.setVisible(true);
        panel.setLayout(null);

        JLabel bookLabel = new JLabel("Book");
        JLabel titleBookLabel = new JLabel("Title");
        JLabel authorBookLabel = new JLabel("Author");
        JLabel gendreBookLabel = new JLabel("Gender");
        JLabel quantityBookLabel = new JLabel("Quantity");

        panel.add(bookLabel);
        panel.add(titleBookLabel);
        panel.add(authorBookLabel);
        panel.add(gendreBookLabel);
        panel.add(quantityBookLabel);

        bookLabel.setBounds(50, 50, 150, 30);
        titleBookLabel.setBounds(50, 100, 150, 30);
        authorBookLabel.setBounds(50, 150, 150, 30);
        gendreBookLabel.setBounds(50, 200, 150, 30);
        quantityBookLabel.setBounds(50, 250, 150, 30);


        searchByGender = new JButton("Search By Gender");
        searchByTitle = new JButton("Search By Title");
        searchByAuthor = new JButton("Search By Author");
        sellBooks = new JButton("Sell Book");

        searchByGender.setBounds(300, 100, 130, 30);
        searchByTitle.setBounds(300, 150, 130, 30);
        searchByAuthor.setBounds(300, 200, 130, 30);
        sellBooks.setBounds(300, 250, 130, 30);

        panel.add(searchByGender);
        panel.add(searchByTitle);
        panel.add(searchByAuthor);
        panel.add(sellBooks);

        titleBookField = new JTextField();
        authorBookField = new JTextField();
        gendreBookField = new JTextField();
        quantityBookField = new JTextField();

        titleBookField.setBounds(120, 100, 150, 30);
        authorBookField.setBounds(120, 150, 150, 30);
        gendreBookField.setBounds(120, 200, 150, 30);
        quantityBookField.setBounds(120, 250, 150, 30);

        panel.add(titleBookField);
        panel.add(authorBookField);
        panel.add(gendreBookField);
        panel.add(quantityBookField);

        textArea = new JTextArea(5, 20);
        JScrollPane scrollPane = new JScrollPane(textArea);
        panel.add(textArea);
        panel.add(scrollPane);

        textArea.setVisible(true);
        textArea.setBounds(50, 320, 200, 100);

    }
    public void clear(){
        titleBookField.setText("");
        authorBookField.setText("");
        gendreBookField.setText("");
        quantityBookField.setText("");
    }

    public JFrame getFrame() {
        return frame;
    }

    public void setFrame(JFrame frame) {
        this.frame = frame;
    }

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }

    public void addSearchByGenderListener(ActionListener a) {
        searchByGender.addActionListener(a);
    }

    public void addSearchByTitleListener(ActionListener a) {
        searchByTitle.addActionListener(a);
    }

    public void addSearchByAuthorListener(ActionListener a) {
        searchByAuthor.addActionListener(a);
    }

    public void addSellBookListener(ActionListener a) {
        sellBooks.addActionListener(a);
    }

    public JButton getSearchByGender() {
        return searchByGender;
    }

    public void setSearchByGender(JButton searchByGender) {
        this.searchByGender = searchByGender;
    }

    public JButton getSearchByTitle() {
        return searchByTitle;
    }

    public void setSearchByTitle(JButton searchByTitle) {
        this.searchByTitle = searchByTitle;
    }

    public JButton getSearchByAuthor() {
        return searchByAuthor;
    }

    public void setSearchByAuthor(JButton searchByAuthor) {
        this.searchByAuthor = searchByAuthor;
    }

    public JButton getSellBooks() {
        return sellBooks;
    }

    public void setSellBooks(JButton sellBooks) {
        this.sellBooks = sellBooks;
    }

    public JTextField getTitleBookField() {
        return titleBookField;
    }

    public void setTitleBookField(JTextField titleBookField) {
        this.titleBookField = titleBookField;
    }

    public JTextField getAuthorBookField() {
        return authorBookField;
    }

    public void setAuthorBookField(JTextField authorBookField) {
        this.authorBookField = authorBookField;
    }

    public JTextField getGendreBookField() {
        return gendreBookField;
    }

    public void setGendreBookField(JTextField gendreBookField) {
        this.gendreBookField = gendreBookField;
    }

    public JTextField getQuantityBookField() {
        return quantityBookField;
    }

    public void setQuantityBookField(JTextField quantityBookField) {
        this.quantityBookField = quantityBookField;
    }
    public JTextArea getTextArea() {
        return textArea;
    }

    public void setTextArea(JTextArea textArea) {
        this.textArea = textArea;
    }
}
