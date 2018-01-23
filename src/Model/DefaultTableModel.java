package Model;

import javax.swing.table.AbstractTableModel;

public class DefaultTableModel extends AbstractTableModel {
    private Object[][] data;
    private String[] titles;

    public DefaultTableModel(Object[][] data, String[] titles) {
        this.titles = titles;
        this.data = data;
    }

    @Override
    public int getRowCount() {
        return this.data.length;
    }

    @Override
    public int getColumnCount() {
        return this.titles.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        return this.data[rowIndex][columnIndex];
    }

    public String getColumnName(int col) {
        return this.titles[col];
    }

}
