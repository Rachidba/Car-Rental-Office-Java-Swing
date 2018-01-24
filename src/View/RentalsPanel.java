package View;

import Model.RantalsTableModel;

import javax.swing.*;
import java.awt.*;

public class RentalsPanel extends JPanel {
    private JTable table;
    private JButton addButton;
    private JButton resetButton;
    private JButton exportButton;
    private JButton deleteButton;
    private JButton updateButton;

    public RentalsPanel() {
        this.setLayout(new BorderLayout());
        this.table = new JTable(new RantalsTableModel());

        this.addButton = new JButton("ADD");
        this.resetButton = new JButton("Reset");
        this.exportButton = new JButton("Export");
        this.deleteButton = new JButton("Delete");
        this.updateButton = new JButton("Update");

        JPanel topPanel = new JPanel(new FlowLayout());
        JPanel bottomPanel = new JPanel(new FlowLayout());

        topPanel.add(addButton);
        topPanel.add(resetButton);

        bottomPanel.add(exportButton);
        bottomPanel.add(deleteButton);
        bottomPanel.add(updateButton);

        //add borders to panels
        this.setBorder( BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(66, 134, 244)),"Browse rentals list"));
        ((javax.swing.border.TitledBorder) this.getBorder()).setTitleFont(new Font("Tahoma", Font.PLAIN, 20));
        ((javax.swing.border.TitledBorder) this.getBorder()).setTitleColor(new Color(66, 134, 244));


        //this.add(topPanel, BorderLayout.NORTH);
        this.add(new JScrollPane(table), BorderLayout.CENTER);
        this.add(bottomPanel, BorderLayout.SOUTH);
    }

    public JTable getTable() {
        return table;
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
