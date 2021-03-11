package erp_jdbc_study_oracle.ui.component.table;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.RowSorter;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableColumnModel;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

@SuppressWarnings("serial")
public abstract class AbstractCustomTable<T> extends JPanel {

    private JTable table;
    private CustomModel model;
    List<T> items;
    
    public AbstractCustomTable() {
        initComponents();
    }
    
    private void initComponents() {
        setLayout(new BorderLayout(0, 0));
        
        JScrollPane scrollPane = new JScrollPane();
        add(scrollPane, BorderLayout.CENTER);
        
        table = new JTable();
        table.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        scrollPane.setViewportView(table);
    }

    public abstract void loadItems();
    
    void loadData() {
        model = new CustomModel(getRows(), getColNames());
        table.setModel(model);

        setWidthAlign();
        
        RowSorter<TableModel> sorter = new TableRowSorter<TableModel>(model);
        table.setRowSorter(sorter);
    }
    
    abstract String[] getColNames();

    private Object[][] getRows() {
        Object[][] rows = new Object[items.size()][];
        for(int i=0; i<rows.length; i++) {
            rows[i] = toArray(items.get(i));
        }
        return rows;
    }

    abstract Object[] toArray(T item);
    
    
    public void addRow(T item) {
        addItem(item);
        model.addRow(toArray(item));
        loadItems();
    }
    
    public void removeRow(T item){
        deleteItem(item);
        model.removeRow(items.indexOf(item));
        loadItems();
    }
    
    public void updateRow(T item) {
        modifyItem(item);
        int idx = items.indexOf(item);
        model.removeRow(idx);
        model.insertRow(idx, toArray(item));
        table.clearSelection();
        loadItems();
    }
    
    abstract void addItem(T item);
    
    abstract void deleteItem(T item);
    
    abstract void modifyItem(T item);
    

    /**
     *  "학생 번호", "성명", "국어", "영어", "수학", "총점", "평균"<br>
        tableSetWidth(150, 150, 100, 100, 100, 100, 100);<br>
        tableCellAlign(SwingConstants.CENTER, 0, 1);    <br>
        tableCellAlign(SwingConstants.RIGHT, 2, 3, 4, 5, 6); 
     */
    abstract void setWidthAlign();
    
    protected void tableCellAlign(int align, int...idx) {
        DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
        dtcr.setHorizontalAlignment(align);
        
        TableColumnModel cModel = table.getColumnModel();
        for(int i=0; i<idx.length; i++) {
            cModel.getColumn(idx[i]).setCellRenderer(dtcr);
        }
    }
    
    protected void tableSetWidth(int...width) {
        TableColumnModel cModel = table.getColumnModel();
        for(int i=0; i<width.length; i++) {
            cModel.getColumn(i).setPreferredWidth(width[i]);
        }
    }

}
