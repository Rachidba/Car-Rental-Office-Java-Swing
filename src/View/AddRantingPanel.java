package View;

import Model.CarTableModel;
import Model.ClientTableModel;

import javax.swing.*;
import java.awt.*;

public class AddRantingPanel extends JPanel {
    private JTable clientsTable;
    private JTable carsTable;
    private JLabel cinLabel;
    private JLabel fnameLabel;
    private JLabel lnameLabel;
    private JLabel numLabel;
    private JLabel modelLabel;
    private JLabel brandLabel;
    private JLabel priceLabel;
    private JTextField cinField;
    private JTextField fnameField;
    private JTextField lnameField;
    private JTextField numField;
    private JTextField modelField;
    private JTextField brandField;
    private JTextField priceField;
    private JButton clientSearchButton;
    private JButton carSearchButton;
    private JButton clientResetButton;
    private JButton carResetButton;

    public AddRantingPanel() {
        this.setLayout(new BorderLayout());

        this.clientsTable = new JTable(new ClientTableModel());
        this.carsTable = new JTable(new CarTableModel());
        this.cinLabel = new JLabel("      CIN: ", SwingConstants.RIGHT);
        this.fnameLabel = new JLabel("First name: ", SwingConstants.RIGHT);
        this.lnameLabel = new JLabel("   Last name: ", SwingConstants.RIGHT);
        //fnameLabel.setHorizontalTextPosition(JLabel.RIGHT);
        this.numLabel = new JLabel("R.NUMBER: ", SwingConstants.RIGHT);
        this.modelLabel = new JLabel("Model: ", SwingConstants.RIGHT);
        this.brandLabel = new JLabel("Brand: ", SwingConstants.RIGHT);
        this.priceLabel = new JLabel("Price: ", SwingConstants.RIGHT);
        this.cinField = new JTextField(8);
        this.fnameField = new JTextField(8);
        this.lnameField = new JTextField(8);
        this.numField = new JTextField(8);
        this.modelField = new JTextField(8);
        this.brandField = new JTextField(8);
        this.priceField = new JTextField(4);
        this.clientSearchButton = new JButton("Search");
        this.carSearchButton = new JButton("Search");
        this.clientResetButton = new JButton("Reset");
        this.carResetButton = new JButton("Reset");

        JPanel topPanel = new JPanel(new FlowLayout());
        JPanel centerPanel = new JPanel(new BorderLayout());
        JPanel leftPanelGlob = new JPanel(new BorderLayout());
        JPanel leftPanel = new JPanel(new GridLayout(0, 4));
        JPanel leftPanel1 = new JPanel();
        JPanel leftPanel2 = new JPanel();
        JPanel leftPanel3 = new JPanel();
        JPanel leftPanel4 = new JPanel();
        JPanel rightPanelGlob = new JPanel(new BorderLayout());
        JPanel rightPanel = new JPanel(new GridLayout(0, 4));
        JPanel rightPanel1 = new JPanel(new FlowLayout());
        JPanel rightPanel2 = new JPanel(new FlowLayout());
        JPanel rightPanel3 = new JPanel(new FlowLayout());
        JPanel bottomPanel = new JPanel(new FlowLayout());

        leftPanel.add(cinLabel);
        leftPanel.add(cinField);
        leftPanel.add(new Label());
        leftPanel.add(new Label());
        //leftPanel.add(leftPanel1);

        leftPanel.add(fnameLabel);
        leftPanel.add(fnameField);
        //leftPanel.add(leftPanel2);

        leftPanel.add(lnameLabel);
        leftPanel.add(lnameField);
        leftPanel.add(new Label());
        leftPanel.add(new Label());
        leftPanel.add(new Label());
        leftPanel.add(new Label());
        leftPanel.add(new Label());
        leftPanel.add(new Label());

        leftPanel.add(clientSearchButton);
        leftPanel.add(clientResetButton);
        leftPanel.add(new Label());
        leftPanel.add(new Label());
        leftPanel.add(new Label());
        leftPanel.add(new Label());
        //leftPanel.add(leftPanel3);

        leftPanelGlob.add(leftPanel, BorderLayout.NORTH);
        leftPanelGlob.add(new JScrollPane(clientsTable), BorderLayout.CENTER);
        //centerPanel.add(leftPanelGlob, BorderLayout.EAST);

        rightPanel.add(numLabel);
        rightPanel.add(numField);
        rightPanel.add(priceLabel);
        rightPanel.add(priceField);
        //rightPanel.add(rightPanel1);

        rightPanel.add(brandLabel);
        rightPanel.add(brandField);
        rightPanel.add(modelLabel);
        rightPanel.add(modelField);
        //rightPanel.add(rightPanel2);

        rightPanel.add(new Label());
        rightPanel.add(new Label());
        rightPanel.add(new Label());
        rightPanel.add(new Label());
        rightPanel.add(new Label());
        rightPanel.add(new Label());
        rightPanel.add(carSearchButton);
        rightPanel.add(carResetButton);
        rightPanel.add(new Label());
        rightPanel.add(new Label());
        rightPanel.add(new Label());
        rightPanel.add(new Label());
        //rightPanel.add(rightPanel3);

        rightPanelGlob.add(rightPanel, BorderLayout.NORTH);
        rightPanelGlob.add(new JScrollPane(carsTable), BorderLayout.CENTER);
        //centerPanel.add(rightPanelGlob, BorderLayout.WEST);


        this.add(topPanel, BorderLayout.NORTH);
        this.add(leftPanelGlob, BorderLayout.WEST);
        this.add(rightPanelGlob, BorderLayout.EAST);
        this.add(bottomPanel, BorderLayout.SOUTH);
    }

    public JTable getClientsTable() {
        return clientsTable;
    }

    public JTable getCarsTable() {
        return carsTable;
    }

    public JLabel getCinLabel() {
        return cinLabel;
    }

    public JLabel getFnameLabel() {
        return fnameLabel;
    }

    public JLabel getLnameLabel() {
        return lnameLabel;
    }

    public JLabel getNumLabel() {
        return numLabel;
    }

    public JLabel getModelLabel() {
        return modelLabel;
    }

    public JLabel getBrandLabel() {
        return brandLabel;
    }

    public JLabel getPriceLabel() {
        return priceLabel;
    }

    public JTextField getCinField() {
        return cinField;
    }

    public JTextField getFnameField() {
        return fnameField;
    }

    public JTextField getLnameField() {
        return lnameField;
    }

    public JTextField getNumField() {
        return numField;
    }

    public JTextField getModelField() {
        return modelField;
    }

    public JTextField getBrandField() {
        return brandField;
    }

    public JTextField getPriceField() {
        return priceField;
    }

    public JButton getClientSearchButton() {
        return clientSearchButton;
    }

    public JButton getCarSearchButton() {
        return carSearchButton;
    }

    public JButton getClientResetButton() {
        return clientResetButton;
    }

    public JButton getCarResetButton() {
        return carResetButton;
    }
}
