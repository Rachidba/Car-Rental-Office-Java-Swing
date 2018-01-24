package View;

import Model.Client;
import Model.ClientTableModel;

import javax.swing.*;
import java.awt.*;

public class ClientsPanel extends JPanel {
    private ClientTableModel model;
    private JTable table;
    private JLabel cinLabel;
    private JLabel fnameLabel;
    private JLabel lnameLabel;
    private JTextField cinField;
    private JTextField fnameField;
    private JTextField lnameField;
    private JButton addButton;
    private JButton resetButton;
    private JButton exportButton;

    public ClientsPanel() {
        this.setLayout(new BorderLayout());
        this.model = new ClientTableModel();
        this.table = new JTable(model);
        this.cinLabel = new JLabel("CIN: ");
        this.fnameLabel = new JLabel("First name: ");
        this.lnameLabel = new JLabel("Last name: ");
        this.cinField = new JTextField(8);
        this.fnameField = new JTextField(12);
        this.lnameField = new JTextField(12);
        this.addButton = new JButton("ADD");
        this.resetButton = new JButton("Reset");
        this.exportButton = new JButton("Export");

        JPanel topPanel = new JPanel(new FlowLayout());
        JPanel bottomPanel = new JPanel(new FlowLayout());

        topPanel.add(cinLabel);
        topPanel.add(cinField);
        topPanel.add(fnameLabel);
        topPanel.add(fnameField);
        topPanel.add(lnameLabel);
        topPanel.add(lnameField);
        topPanel.add(addButton);
        topPanel.add(resetButton);

        bottomPanel.add(exportButton);

        this.add(topPanel, BorderLayout.NORTH);
        this.add(new JScrollPane(table), BorderLayout.CENTER);
        this.add(bottomPanel, BorderLayout.SOUTH);

    }

    public JTable getTable() {
        return table;
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

    public JTextField getCinField() {
        return cinField;
    }

    public JTextField getFnameField() {
        return fnameField;
    }

    public JTextField getLnameField() {
        return lnameField;
    }

    public JButton getAddButton() {
        return addButton;
    }

    public JButton getResetButton() {
        return resetButton;
    }

    public JButton getExportButton() {
        return exportButton;
    }

    public ClientTableModel getModel() {
        return model;
    }

}
