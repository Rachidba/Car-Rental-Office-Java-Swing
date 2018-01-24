package View;

import Model.DefaultTableModel;

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

    public CarsPanel(DefaultTableModel model) {
        this.setLayout(new BorderLayout());

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
}
