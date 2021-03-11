package erp_jdbc_study_oracle.ui.component.table;

import javax.swing.table.DefaultTableModel;

@SuppressWarnings("serial")
public class CustomModel extends DefaultTableModel {
    
    public CustomModel(Object[][] data, Object[] columnNames) {
        super(data, columnNames);
    }

    @Override
    public boolean isCellEditable(int row, int column) {
        return false;
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return getValueAt(1, columnIndex).getClass();
    }
}
