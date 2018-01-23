package Model;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class CarTableModel extends AbstractTableModel{
    private String[] titles = {"R.NUMBER", "Model", "Brand", "Price"};
    private Object[][] data;

    public CarTableModel() {
        data = new Object[][]{};
    }

    public CarTableModel(List<Car> cars) {
        this.loadData(cars);
    }

    public void loadData(List<Car> cars) {
        int i = 0;
        this.data = new Object[][]{};
        for(Car c:cars) {
            data[i][0] = c.getRegistrationNumber();
            data[i][1] = c.getRegistrationNumber();
            data[i][2] = c.getModel();
            data[i][3] = c.getBrand();
            data[i][4] =String.valueOf(c.getPrice());
            i++;
        }
        fireTableChanged(null);
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
