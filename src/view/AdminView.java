package view;

import javax.swing.*;
import java.awt.event.ActionListener;

/**
 * Created by iliesalinadenisa on 03/05/2017.
 */
public class AdminView {
    private JFrame frame = new JFrame();
    private JPanel panel;
    private JButton createUserButton;
    private JButton deleteUserButton;
    private JButton updateUserButton;

    private JButton addBookButton;
    private JButton updateBookButton;
    private JButton deleteBookButton;
    private JButton sellBookButton;
    private JButton generateReportButton;

    private JTextField usernameUserField;
    private JTextField passwordUserField;
    private JTextField nameUserField;
    private JTextField isAdminUserField;

    private JTextField titleBookField;
    private JTextField authorBookField;
    private JTextField gendreBookField;
    private JTextField quantityBookField;
    private JTextField priceBookField;


    public AdminView() {
        initComponents();
    }

    private void initComponents() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Admin");
        frame.setSize(800, 600);
        frame.setResizable(false);
        frame.setVisible(true);
        panel = new JPanel();
        frame.add(panel);
        panel.setVisible(true);
        panel.setLayout(null);

        JLabel userLabel = new JLabel("User");
        JLabel usernameUserLabel = new JLabel("Username");
        JLabel passwordUserLabel = new JLabel("Password");
        JLabel nameUserLabel = new JLabel("Name");
        JLabel adminUserLabel = new JLabel("Admin");

        JLabel bookLabel = new JLabel("Book");
        JLabel titleBookLabel = new JLabel("Title");
        JLabel authorBookLabel = new JLabel("Author");
        JLabel gendreBookLabel = new JLabel("Gender");
        JLabel quantityBookLabel = new JLabel("Quantity");
        JLabel priceBookLabel = new JLabel("Price");

        panel.add(userLabel);
        panel.add(usernameUserLabel);
        panel.add(passwordUserLabel);
        panel.add(nameUserLabel);
        panel.add(adminUserLabel);

        panel.add(bookLabel);
        panel.add(titleBookLabel);
        panel.add(authorBookLabel);
        panel.add(gendreBookLabel);
        panel.add(quantityBookLabel);
        panel.add(priceBookLabel);

        userLabel.setBounds(50, 50, 150, 30);
        usernameUserLabel.setBounds(50, 100, 150, 30);
        passwordUserLabel.setBounds(50, 150, 150, 30);
        nameUserLabel.setBounds(50, 200, 150, 30);
        adminUserLabel.setBounds(50, 250, 150, 30);

        bookLabel.setBounds(400, 50, 150, 30);
        titleBookLabel.setBounds(400, 100, 150, 30);
        authorBookLabel.setBounds(400, 150, 150, 30);
        gendreBookLabel.setBounds(400, 200, 150, 30);
        quantityBookLabel.setBounds(400, 250, 150, 30);
        priceBookLabel.setBounds(400, 300, 150, 30);

        createUserButton = new JButton("Create User");
        updateUserButton = new JButton("Update User");
        deleteUserButton = new JButton("Delete User ");

        addBookButton = new JButton("Add Book");
        updateBookButton = new JButton("Update Book");
        deleteBookButton = new JButton("Delete Book ");
        sellBookButton = new JButton("Sell Book");
        generateReportButton = new JButton("Generate Reports");


        createUserButton.setBounds(220, 100, 150, 30);
        updateUserButton.setBounds(220, 150, 150, 30);
        deleteUserButton.setBounds(220, 200, 150, 30);

        addBookButton.setBounds(600, 100, 150, 30);
        updateBookButton.setBounds(600, 150, 150, 30);
        deleteBookButton.setBounds(600, 200, 150, 30);
        sellBookButton.setBounds(600, 250, 150, 30);
        generateReportButton.setBounds(600, 300, 150, 30);

        panel.add(createUserButton);
        panel.add(updateUserButton);
        panel.add(deleteUserButton);

        panel.add(addBookButton);
        panel.add(updateBookButton);
        panel.add(deleteBookButton);
        panel.add(sellBookButton);
        panel.add(generateReportButton);

        usernameUserField = new JTextField();
        passwordUserField = new JTextField();
        nameUserField = new JTextField();
        isAdminUserField = new JTextField();

        titleBookField = new JTextField();
        authorBookField = new JTextField();
        gendreBookField = new JTextField();
        quantityBookField = new JTextField();
        priceBookField = new JTextField();

        usernameUserField.setBounds(120, 100, 80, 30);
        passwordUserField.setBounds(120, 150, 80, 30);
        nameUserField.setBounds(120, 200, 80, 30);
        isAdminUserField.setBounds(120, 250, 80, 30);

        titleBookField.setBounds(500, 100, 80, 30);
        authorBookField.setBounds(500, 150, 80, 30);
        gendreBookField.setBounds(500, 200, 80, 30);
        quantityBookField.setBounds(500, 250, 80, 30);
        priceBookField.setBounds(500, 300, 80, 30);

        panel.add(usernameUserField);
        panel.add(passwordUserField);
        panel.add(nameUserField);
        panel.add(isAdminUserField);

        panel.add(titleBookField);
        panel.add(authorBookField);
        panel.add(gendreBookField);
        panel.add(quantityBookField);
        panel.add(priceBookField);


    }

    public void clear() {
        usernameUserField.setText("");
        nameUserField.setText("");
        passwordUserField.setText("");
        isAdminUserField.setText("");

        titleBookField.setText("");
        authorBookField.setText("");
        gendreBookField.setText("");
        quantityBookField.setText("");
        priceBookField.setText("");
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


    public void addCreateUserListener(ActionListener a) {
        createUserButton.addActionListener(a);
    }

    public void addUpdateUserListener(ActionListener a) {
        updateUserButton.addActionListener(a);
    }

    public void addDeleteUserListener(ActionListener a) {
        deleteUserButton.addActionListener(a);
    }

    public void addAddBookListener(ActionListener a) {
        addBookButton.addActionListener(a);
    }

    public void addUpdateBookListener(ActionListener a) {
        updateBookButton.addActionListener(a);
    }

    public void addDeleteBookListener(ActionListener a) {
        deleteBookButton.addActionListener(a);
    }
    public void addGenerateReportListener(ActionListener a) {
        generateReportButton.addActionListener(a);
    }

    public JButton getCreateUserButton() {
        return createUserButton;
    }

    public void setCreateUserButton(JButton createUserButton) {
        this.createUserButton = createUserButton;
    }

    public JButton getDeleteUserButton() {
        return deleteUserButton;
    }

    public void setDeleteUserButton(JButton deleteUserButton) {
        this.deleteUserButton = deleteUserButton;
    }

    public JButton getUpdateUserButton() {
        return updateUserButton;
    }

    public void setUpdateUserButton(JButton updateUserButton) {
        this.updateUserButton = updateUserButton;
    }

    public JButton getAddBookButton() {
        return addBookButton;
    }

    public void setAddBookButton(JButton addBookButton) {
        this.addBookButton = addBookButton;
    }

    public JButton getUpdateBookButton() {
        return updateBookButton;
    }

    public void setUpdateBookButton(JButton updateBookButton) {
        this.updateBookButton = updateBookButton;
    }

    public JButton getDeleteBookButton() {
        return deleteBookButton;
    }

    public void setDeleteBookButton(JButton deleteBookButton) {
        this.deleteBookButton = deleteBookButton;
    }

    public JButton getSellBookButton() {
        return sellBookButton;
    }

    public void setSellBookButton(JButton sellBookButton) {
        this.sellBookButton = sellBookButton;
    }

    public JButton getGenerateReportButton() {
        return generateReportButton;
    }

    public void setGenerateReportButton(JButton generateReportButton) {
        this.generateReportButton = generateReportButton;
    }

    public JTextField getUsernameUserField() {
        return usernameUserField;
    }

    public void setUsernameUserField(JTextField usernameUserField) {
        this.usernameUserField = usernameUserField;
    }

    public JTextField getPasswordUserField() {
        return passwordUserField;
    }

    public void setPasswordUserField(JTextField passwordUserField) {
        this.passwordUserField = passwordUserField;
    }

    public JTextField getNameUserField() {
        return nameUserField;
    }

    public void setNameUserField(JTextField nameUserField) {
        this.nameUserField = nameUserField;
    }

    public JTextField getIsAdminUserField() {
        return isAdminUserField;
    }

    public void setIsAdminUserField(JTextField isAdminUserField) {
        this.isAdminUserField = isAdminUserField;
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

    public JTextField getPriceBookField() {
        return priceBookField;
    }

    public void setPriceBookField(JTextField priceBookField) {
        this.priceBookField = priceBookField;
    }


}
