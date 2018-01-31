package Model;

import javax.swing.table.AbstractTableModel;
import java.util.List;
import java.util.Vector;

public class ClientTableModel extends AbstractTableModel {
    private String[] titles = {"CIN", "First Name", "LAST NAME"};
    //private Object[][] data ;
    private Vector<String[]> data;
    //List<Client> clients;

    public ClientTableModel() {
        //clients = DAOFactory.getClientDAO().all();
        initData();
    }

    public void loadData(List<Client> clients) {
        this.data = new Vector<String[]>();//[clients.size()][3];
        for(Client c:clients) {
            String[] str = {c.getCIN(), c.getFirstName(), c.getLastName()};
            data.add (str);
        }
        fireTableChanged(null);
    }

    public void initData() {
        this.loadData(DAOFactory.getClientDAO().all());
    }

    public void availables() {
        this.loadData(DAOFactory.getClientDAO().available());
    }

    public int getRowCount() {
        return this.data.size();
    }

    public int getColumnCount() {
        return this.titles.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        return this.data.get(rowIndex)[columnIndex];
    }

    public String getColumnName(int col) {
        return this.titles[col];
    }

    public String[] getTitles() {
        return titles;
    }

    public Vector<String[]> getData() {
        return data;
    }

    public void removeRow(int i) {
        this.data.remove(i);
        fireTableChanged(null);
    }

    public void setRow(int i, String[] str) {
        this.data.set(i, str);
        fireTableChanged(null);
    }

    public void addRow(String[] str) {
        this.data.add(str);
        fireTableChanged(null);
    }
}
