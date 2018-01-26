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
    private JButton deleteButton;
    private JButton updateButton;

    public ClientTableModel getModel() {
        return model;
    }

    public JButton getDeleteButton() {
        return deleteButton;
    }

    public JButton getUpdateButton() {
        return updateButton;
    }

    public ClientsPanel() {
        this.setLayout(new BorderLayout());
        this.model = new ClientTableModel();

        this.table = new JTable(model);
        //font and color
        Font f = new Font("Tahoma", Font.PLAIN, 15);
        Color c = new Color (193, 73, 13);

        Font ff = new Font("Tahoma", Font.PLAIN, 20);
        Color cc = new Color(66, 134, 244);

        Color cccc = Color.white;

        this.cinLabel = new JLabel("CIN: ");
        this.cinLabel.setFont(f);
        this.cinLabel.setForeground(c);

        this.fnameLabel = new JLabel("First name: ");
        this.fnameLabel.setFont(f);
        this.fnameLabel.setForeground(c);

        this.lnameLabel = new JLabel("Last name: ");
        this.lnameLabel.setFont(f);
        this.lnameLabel.setForeground(c);

        this.cinField = new JTextField(8);
        this.fnameField = new JTextField(12);
        this.lnameField = new JTextField(12);

        this.addButton = new JButton("ADD");
        this.addButton.setFont(f);
        this.addButton.setForeground(cc);
        this.addButton.setBackground(cccc);

        this.resetButton = new JButton("Reset");
        this.resetButton.setFont(f);
        this.resetButton.setForeground(cc);
        this.resetButton.setBackground(cccc);

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
        ImageIcon addI = new ImageIcon("png/add.PNG");
        this.addButton.setIcon(addI);
        ImageIcon deleteI = new ImageIcon("png/delete.PNG");
        this.deleteButton.setIcon(deleteI);
        ImageIcon resetI = new ImageIcon("png/reset.PNG");
        this.resetButton.setIcon(resetI);
        ImageIcon updateI = new ImageIcon("png/update.PNG");
        this.updateButton.setIcon(updateI);
        ImageIcon exportI = new ImageIcon("png/export.PNG");
        this.exportButton.setIcon(exportI);

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
        bottomPanel.add(deleteButton);
        bottomPanel.add(updateButton);

        //add borders to panels
        this.setBorder( BorderFactory.createTitledBorder(BorderFactory.createLineBorder(cc),"Browse clients list"));
        ((javax.swing.border.TitledBorder) this.getBorder()).setTitleFont(ff);
        ((javax.swing.border.TitledBorder) this.getBorder()).setTitleColor(cc);



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

    public void setModel(ClientTableModel model) {
        this.model = model;
    }
}
