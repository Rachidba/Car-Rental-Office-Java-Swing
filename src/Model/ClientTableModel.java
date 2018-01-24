package Model;

import javax.swing.table.AbstractTableModel;
import java.util.List;
import java.util.Vector;

public class ClientTableModel extends AbstractTableModel {
    private String[] titles = {"CIN", "First Name", "LAST NAME"};
    private Object[][] data ;
    List<Client> clients;

    public ClientTableModel() {
        clients = DAOFactory.getClientDAO().all();
        this.loadData();
    }

    public String[] getTitles() {
        return titles;
    }

    public Object[][] getData() {
        return data;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void loadData() {
        int i=0;
        this.data = new Object[clients.size()][5];

        for(Client c:clients) {
            data[i][0] = c.getCIN();
            data[i][1] = c.getFirstName();
            data[i][2] = c.getLastName();
            data[i][4] = new Boolean(false);
            i++;
        }
    }

    public int getRowCount() {
        return this.data.length;
    }

    public int getColumnCount() {
        return this.titles.length;
    }

    public Object getValueAt(int rowIndex, int columnIndex) {
        return this.data[rowIndex][columnIndex];
    }

    public String getColumnName(int col) {
        return this.titles[col];
    }
}