package View;

import Model.RantalsTableModel;
import javafx.beans.Observable;

import javax.swing.*;
import java.awt.*;
import java.util.Observer;

public class RentalsPanel extends JPanel implements Observer {
    public RantalsTableModel getModel() {
        return model;
    }

    private RantalsTableModel model;
    private JTable table;
    private JButton exportButton;

    public JButton getDeleteButton() {
        return deleteButton;
    }

    public JButton getUpdateButton() {
        return updateButton;
    }

    private JButton deleteButton;
    private JButton updateButton;

    public RentalsPanel() {
        this.setLayout(new BorderLayout());
        this.model = new RantalsTableModel();
        this.table = new JTable(model);
        //font and color
        Font f = new Font("Tahoma", Font.PLAIN, 15);
        Color c = new Color (193, 73, 13);

        Font ff = new Font("Tahoma", Font.PLAIN, 20);
        Color cc = new Color(66, 134, 244);

        Color cccc = Color.white;

        this.exportButton = new JButton("Export");
        this.exportButton.setFont(f);
        this.exportButton.setForeground(cc);
        this.exportButton.setBackground(cccc);

        this.deleteButton = new JButton("Delete");
        this.deleteButton.setFont(f);
        this.deleteButton.setForeground(cc);
        this.deleteButton.setBackground(cccc);

        this.updateButton = new JButton("Update");
        this.updateButton.setFont(f);
        this.updateButton.setForeground(cc);
        this.updateButton.setBackground(cccc);

        //button icons
        ImageIcon deleteI = new ImageIcon("png/delete.PNG");
        this.deleteButton.setIcon(deleteI);
        ImageIcon updateI = new ImageIcon("png/update.PNG");
        this.updateButton.setIcon(updateI);
        ImageIcon exportI = new ImageIcon("png/export.PNG");
        this.exportButton.setIcon(exportI);

        JPanel bottomPanel = new JPanel(new FlowLayout());


        bottomPanel.add(exportButton);
        bottomPanel.add(deleteButton);
        bottomPanel.add(updateButton);

        //add borders to panels
        this.setBorder( BorderFactory.createTitledBorder(BorderFactory.createLineBorder(cc),"Browse rentals list"));
        ((javax.swing.border.TitledBorder) this.getBorder()).setTitleFont(ff);
        ((javax.swing.border.TitledBorder) this.getBorder()).setTitleColor(cc);


        //this.add(topPanel, BorderLayout.NORTH);
        this.add(new JScrollPane(table), BorderLayout.CENTER);
        this.add(bottomPanel, BorderLayout.SOUTH);
    }

    public JTable getTable() {
        return table;
    }


    public JButton getExportButton() {
        return exportButton;
    }

    @Override
    public void update(java.util.Observable o, Object arg) {
        this.model.initData();
    }
}
