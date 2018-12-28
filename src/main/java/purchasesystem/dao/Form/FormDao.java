package purchasesystem.dao.Form;

import purchasesystem.model.Form.form;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

public interface FormDao {
    public List<HashMap> selectFormBatch(@Param("base")int base, @Param("offset")int offset);
    public int insertForm(form form);
    public int updateForm(form form);
    public int deleteForm(int id);
    public int getCount();
}
