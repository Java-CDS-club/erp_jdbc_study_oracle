package erp_jdbc_study_oracle.ui.component.table;

import javax.swing.SwingConstants;

import erp_jdbc_study_oracle.dto.Title;
import erp_jdbc_study_oracle.ui.service.TitleService;

@SuppressWarnings("serial")
public class TitleTable extends AbstractCustomTable<Title> {
    private TitleService service;
    
    public TitleTable() {
        service = new TitleService();
    }

    @Override
    String[] getColNames() {
        return new String[] {"직책 번호", "직책명"};
    }

    @Override
    Object[] toArray(Title item) {
        return new Object[] {item.getTitleNo(), item.getTitleName()};
    }

    @Override
    void setWidthAlign() {
        tableSetWidth(150, 200);
        tableCellAlign(SwingConstants.CENTER, 0, 1);        
    }

    @Override
    public void loadItems() {
        items = service.getLists();
        loadData();
    }

    @Override
    void addItem(Title item) {
        service.addTitle(item);
    }

    @Override
    void deleteItem(Title item) {
        service.deleteTitle(item);
    }

    @Override
    void modifyItem(Title item) {
        service.modifyTitle(item);
    }

}
