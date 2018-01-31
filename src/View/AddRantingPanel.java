package View;

import Model.CarTableModel;
import Model.ClientTableModel;

import javax.swing.*;
import java.awt.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class AddRantingPanel extends JPanel {
    //tables to search
    private ClientTableModel clientModel;
    private CarTableModel carModel;
    private JTable clientsTable;
    private JTable carsTable;
    //labels: add new ranting
    private JLabel selectedCarLabel;
    private JLabel selectedClientLabel;
    private JLabel rentalDateLabel;
    private JLabel returnDateLabel;
    //selected client an car content
    private JTextField selectedCar;
    private JTextField selectedClient;
    //add ranting field
    private JTextField rentalDateField;
    private JTextField returnDateField;
    //search client labels
    private JLabel cinLabel;
    private JLabel fnameLabel;
    private JLabel lnameLabel;
    //search client field
    private JTextField cinField;
    private JTextField fnameField;
    private JTextField lnameField;
    //search car labels
    private JLabel numLabel;
    private JLabel modelLabel;
    private JLabel brandLabel;
    private JLabel priceLabel;
    //search car fields
    private JTextField numField;
    private JTextField modelField;
    private JTextField brandField;
    private JTextField priceField;
    //buttons
    private JButton clientSearchButton;
    private JButton carSearchButton;
    private JButton addRantingButton;
    private JButton resetRantingButton;


    public AddRantingPanel() {
        this.setLayout(new BorderLayout());
        //get data from DB
        clientModel = new ClientTableModel();
        clientModel.availables();
        carModel = new CarTableModel();
        carModel.availables();
        this.clientsTable = new JTable(clientModel);
        this.carsTable = new JTable(carModel);
        //components
        //font and color
        Font f = new Font("Tahoma", Font.PLAIN, 15);
        Color c = new Color (193, 73, 13);

        Font ff = new Font("Tahoma", Font.PLAIN, 20);
        Color cc = new Color(66, 134, 244);

        Color cccc = Color.white;

        //add ranting: labels
        this.selectedCarLabel = new JLabel("Selected car N°:", SwingConstants.LEFT);
        this.selectedCarLabel.setFont(f);
        this.selectedCarLabel.setForeground(c);

        this.selectedClientLabel = new JLabel("Selected client CIN:", SwingConstants.LEFT);
        this.selectedClientLabel.setFont(f);
        this.selectedClientLabel.setForeground(c);

        this.rentalDateLabel = new JLabel("Rental date:(Y-M-D)", SwingConstants.LEFT);
        this.rentalDateLabel.setFont(f);
        this.rentalDateLabel.setForeground(c);

        this.returnDateLabel = new JLabel("Return date:(Y-M-D)", SwingConstants.LEFT);
        this.returnDateLabel.setFont(f);
        this.returnDateLabel.setForeground(c);

        JLabel addLabel = new JLabel("");
        JLabel resetLabel = new JLabel("");
        //add ranting content
        this.selectedCar = new JTextField(SwingConstants.LEFT);
        this.selectedClient= new JTextField(SwingConstants.LEFT);
        this.selectedClient.setEditable(false);
        this.selectedCar.setEditable(false);
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
        //JFormattedTextField txtDate = new JFormattedTextField(df);
        this.rentalDateField =  new JFormattedTextField(df);
        this.returnDateField =  new JFormattedTextField(df);

        this.addRantingButton = new JButton("Add");
        this.addRantingButton.setFont(f);
        this.addRantingButton.setForeground(cc);
        this.addRantingButton.setBackground(cccc);

        this.resetRantingButton = new JButton("Reset");
        this.resetRantingButton.setFont(f);
        this.resetRantingButton.setForeground(cc);
        this.resetRantingButton.setBackground(cccc);

        //search : cars
        //labels
        this.numLabel = new JLabel("R.NUMBER: ", SwingConstants.LEFT);
        this.numLabel.setFont(f);
        this.numLabel.setForeground(c);

        this.modelLabel = new JLabel("Model: ", SwingConstants.LEFT);
        this.modelLabel.setFont(f);
        this.modelLabel.setForeground(c);

        this.brandLabel = new JLabel("Brand: ", SwingConstants.LEFT);
        this.brandLabel.setFont(f);
        this.brandLabel.setForeground(c);

        this.priceLabel = new JLabel("Price: ", SwingConstants.LEFT);
        this.priceLabel.setFont(f);
        this.priceLabel.setForeground(c);

        JLabel carsL = new JLabel("");
        //fields
        this.numField = new JTextField(8);
        this.modelField = new JTextField(8);
        this.brandField = new JTextField(8);
        this.priceField = new JTextField(8);
        //button
        this.carSearchButton = new JButton("search");
        this.carSearchButton.setFont(f);
        this.carSearchButton.setForeground(cc);
        this.carSearchButton.setBackground(cccc);
        //search : clients
        //labels
        this.cinLabel = new JLabel("      CIN: ", SwingConstants.LEFT);
        this.cinLabel.setFont(f);
        this.cinLabel.setForeground(c);

        this.fnameLabel = new JLabel("First name: ", SwingConstants.LEFT);
        this.fnameLabel.setFont(f);
        this.fnameLabel.setForeground(c);

        this.lnameLabel = new JLabel("   Last name: ", SwingConstants.LEFT);
        this.lnameLabel.setFont(f);
        this.lnameLabel.setForeground(c);

        JLabel clientsL = new JLabel("");
        //fields
        this.cinField = new JTextField(8);
        this.fnameField = new JTextField(8);
        this.lnameField = new JTextField(8);
        //button
        this.clientSearchButton = new JButton("search");
        this.clientSearchButton.setFont(f);
        this.clientSearchButton.setForeground(cc);
        this.clientSearchButton.setBackground(cccc);

        ImageIcon addI = new ImageIcon("png/add.PNG");
        this.addRantingButton.setIcon(addI);
        ImageIcon resetI = new ImageIcon("png/reset.PNG");
        this.resetRantingButton.setIcon(resetI);
        ImageIcon searchCarI = new ImageIcon("png/search.PNG");
        this.carSearchButton.setIcon(searchCarI);
        ImageIcon searchClientI = new ImageIcon("png/search.PNG");
        this.clientSearchButton.setIcon(searchClientI);


        //panels
        //for add ranting
        JPanel topPanel = new JPanel(new GridLayout(2, 6));
        //for search cars
        JPanel leftPanel = new JPanel();
        leftPanel.setLayout(new BoxLayout (leftPanel, BoxLayout.Y_AXIS));
        JPanel leftPanelTop = new JPanel(new GridLayout(2, 5));
        JPanel leftPanelBottom = new JPanel(new FlowLayout());
        //for search clients
        JPanel rightPanel = new JPanel();
        rightPanel.setLayout(new BoxLayout (rightPanel, BoxLayout.Y_AXIS));
        JPanel rightPanelTop = new JPanel(new GridLayout(2, 4));
        JPanel rightPanelBottom = new JPanel(new FlowLayout());
        //for nothing
        JPanel bottomPanel = new JPanel (new FlowLayout());

        // add components to panel
        // add ranting
        //row 1
        topPanel.add(this.selectedCarLabel);
        topPanel.add(this.selectedClientLabel);
        topPanel.add(this.rentalDateLabel);
        topPanel.add(this.returnDateLabel);
        topPanel.add(addLabel);
        topPanel.add(resetLabel);
        //row 2
        topPanel.add(this.selectedCar);
        topPanel.add(this.selectedClient);
        topPanel.add(this.rentalDateField);
        topPanel.add(this.returnDateField);
        topPanel.add(this.addRantingButton);
        topPanel.add(this.resetRantingButton);
        //add search
        //car : top
        //row 1
        leftPanelTop.add(this.numLabel);
        leftPanelTop.add(this.modelLabel);
        leftPanelTop.add(this.brandLabel);
        leftPanelTop.add(this.priceLabel);
        leftPanelTop.add(carsL);
        //row 2
        leftPanelTop.add(this.numField);
        leftPanelTop.add(this.modelField);
        leftPanelTop.add(this.brandField);
        leftPanelTop.add(this.priceField);
        leftPanelTop.add(carSearchButton);
        //car bottom
        leftPanelBottom.add(new JScrollPane(this.carsTable), BorderLayout.CENTER);
        leftPanel.add(leftPanelTop);
        leftPanel.add(leftPanelBottom);
        //client : top
        //row 1
        rightPanelTop.add(this.cinLabel);
        rightPanelTop.add(this.fnameLabel);
        rightPanelTop.add(this.lnameLabel);
        rightPanelTop.add(clientsL);
        //row 2
        rightPanelTop.add(this.cinField);
        rightPanelTop.add(this.fnameField);
        rightPanelTop.add(this.lnameField);
        rightPanelTop.add(clientSearchButton);
        //client : bottom
        rightPanelBottom.add(new JScrollPane(clientsTable), BorderLayout.CENTER);
        rightPanel.add(rightPanelTop);
        rightPanel.add(rightPanelBottom);

        //add borders to panels

        topPanel.setBorder( BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(66, 134, 244)),"Add a new rental"));
       ((javax.swing.border.TitledBorder) topPanel.getBorder()).setTitleFont(ff);
        ((javax.swing.border.TitledBorder) topPanel.getBorder()).setTitleColor(cc);

        rightPanel.setBorder( BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(66, 134, 244)),"Search for a client"));
        ((javax.swing.border.TitledBorder) rightPanel.getBorder()).setTitleFont(ff);
        ((javax.swing.border.TitledBorder) rightPanel.getBorder()).setTitleColor(cc);

        leftPanel.setBorder( BorderFactory.createTitledBorder(BorderFactory.createLineBorder(new Color(66, 134, 244)),"Search for a car"));
        ((javax.swing.border.TitledBorder) leftPanel.getBorder()).setTitleFont(ff);
        ((javax.swing.border.TitledBorder) leftPanel.getBorder()).setTitleColor(cc);


        //add panels to ranting panel
        this.add(topPanel, BorderLayout.NORTH);
        this.add(rightPanel, BorderLayout.EAST);
        this.add(leftPanel, BorderLayout.WEST);


    }
    public void paintComponent(Graphics g){

    }

    public ClientTableModel getClientModel() {
        return clientModel;
    }

    public CarTableModel getCarModel() {
        return carModel;
    }

    public JTable getClientsTable() {
        return clientsTable;
    }

    public JTable getCarsTable() {
        return carsTable;
    }

    public JLabel getSelectedCarLabel() {
        return selectedCarLabel;
    }

    public JLabel getSelectedClientLabel() {
        return selectedClientLabel;
    }

    public JLabel getRentalDateLabel() {
        return rentalDateLabel;
    }

    public JLabel getReturnDateLabel() {
        return returnDateLabel;
    }

    public JTextField getSelectedCar() {
        return selectedCar;
    }

    public JTextField getSelectedClient() {
        return selectedClient;
    }

    public JTextField getRentalDateField() {
        return rentalDateField;
    }

    public JTextField getReturnDateField() {
        return returnDateField;
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

    public JButton getClientSearchButton() {
        return clientSearchButton;
    }

    public JButton getCarSearchButton() {
        return carSearchButton;
    }

    public JButton getAddRantingButton() {
        return addRantingButton;
    }

    public JButton getResetRantingButton() {
        return resetRantingButton;
    }

    public void setClientModel(ClientTableModel clientModel) {
        this.clientModel = clientModel;
    }

    public void setCarModel(CarTableModel carModel) {
        this.carModel = carModel;
    }
}
