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

    public void loadData() {
        int i=0;
        this.data = new Object[clients.size()][3];
        for(Client c:clients) {
            data[i][0] = c.getCIN();
            data[i][1] = c.getFirstName();
            data[i][2] = c.getLastName();
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
