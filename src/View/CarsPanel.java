package View;

import Model.CarTableModel;

import javax.swing.*;
import java.awt.*;

public class CarsPanel extends JPanel {
    private CarTableModel model;
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

    public CarsPanel() {
        this.setLayout(new BorderLayout());
        this.model = new CarTableModel();
        this.table = new JTable(model);
        this.numLabel = new JLabel("R.NUMBER: ");
        this.modelLabel = new JLabel("Model: ");
        this.brandLabel = new JLabel("Brand: ");
        this.priceLabel = new JLabel("Price: ");

        this.numField = new JTextField(8);
        this.modelField = new JTextField(12);
        this.brandField = new JTextField(12);
        this.priceField = new JTextField(8);

        this.addButton = new JButton("ADD");
        this.resetButton = new JButton("Reset");
        this.exportButton = new JButton("Export");

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

    public CarTableModel getModel() {
        return model;
    }
}
