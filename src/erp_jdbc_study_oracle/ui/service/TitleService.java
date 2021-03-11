package erp_jdbc_study_oracle.ui.service;

import java.util.List;

import erp_jdbc_study_oracle.dao.TitleDao;
import erp_jdbc_study_oracle.dao.impl.TitleDaoImpl;
import erp_jdbc_study_oracle.dto.Title;

public class TitleService {
    private TitleDao dao = TitleDaoImpl.getInstance();
    
    public List<Title> getLists(){
        return dao.selectTitleByAll();
    }
    
    public int addTitle(Title title) {
        return dao.insertTitle(title);
    }
    
    public int deleteTitle(Title title) {
        return dao.deleteTitle(title);
    }
    
    public int modifyTitle(Title title) {
        return dao.updateTitle(title);
    }
}
