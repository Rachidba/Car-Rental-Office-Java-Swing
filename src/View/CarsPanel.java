package View;

import Model.CarTableModel;

import javax.swing.*;
import java.awt.*;

public class CarsPanel extends JPanel {
    private JTable table;
    private JLabel numLabel;
    private JLabel modelLabel;
    private JLabel brandLabel;
    private JLabel priceLabel;
    private JTextField numField;
    private JTextField modelField;
    private JTextField brandField;
    private JTextField priceField;
    private JButton addButton;
    private JButton resetButton;
    private JButton exportButton;
    private JButton deleteButton;
    private JButton updateButton;

    public CarsPanel() {
        this.setLayout(new BorderLayout());

        this.table = new JTable(new CarTableModel());
        //font and color
        Font f = new Font("Tahoma", Font.PLAIN, 15);
        Color c = new Color (193, 73, 13);
        this.numLabel = new JLabel("R.NUMBER: ");
        this.numLabel.setFont(f);
        this.numLabel.setForeground(c);

        this.modelLabel = new JLabel("Model: ");
        this.modelLabel.setFont(f);
        this.modelLabel.setForeground(c);

        this.brandLabel = new JLabel("Brand: ");
        this.brandLabel.setFont(f);
        this.brandLabel.setForeground(c);

        this.priceLabel = new JLabel("Price: ");
        this.priceLabel.setFont(f);
        this.priceLabel.setForeground(c);


        this.numField = new JTextField(8);
        this.modelField = new JTextField(12);
        this.brandField = new JTextField(12);
        this.priceField = new JTextField(8);

        this.addButton = new JButton("ADD");
        this.resetButton = new JButton("Reset");
        this.exportButton = new JButton("Export");

        this.deleteButton = new JButton("Delete");
        this.updateButton = new JButton("Update");

        JPanel topPanel = new JPanel(new FlowLayout());
        JPanel bottomPanel = new JPanel(new FlowLayout());

        topPanel.add(numLabel);
        topPanel.add(numField);
        topPanel.add(modelLabel);
        topPanel.add(modelField);
        topPanel.add(brandLabel);
        topPanel.add(brandField);
        topPanel.add(priceLabel);
        topPanel.add(priceField);
        topPanel.add(addButton);
        topPanel.add(resetButton);

        bottomPanel.add(exportButton);
        bottomPanel.add(deleteButton);
        bottomPanel.add(updateButton);


        //add borders to panels
        this.setBorder( BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(66, 134, 244)),"Browse cars list"));
        ((javax.swing.border.TitledBorder) this.getBorder()).setTitleFont(new Font("Tahoma", Font.PLAIN, 20));
        ((javax.swing.border.TitledBorder) this.getBorder()).setTitleColor(new Color(66, 134, 244));


        this.add(topPanel, BorderLayout.NORTH);
        this.add(new JScrollPane(table), BorderLayout.CENTER);
        this.add(bottomPanel, BorderLayout.SOUTH);
    }

    public JTable getTable() {
        return table;
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

    public JButton getAddButton() {
        return addButton;
    }

    public JButton getResetButton() {
        return resetButton;
    }

    public JButton getExportButton() {
        return exportButton;
    }
}
