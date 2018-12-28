package purchasesystem.dao.form;

import purchasesystem.model.form.Form;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

public interface FormDao {
    public List<HashMap> selectFormBatch(@Param("base")int base, @Param("offset")int offset);
    public int insertForm(Form form);
    public int updateForm(Form form);
    public int deleteForm(int id);
    public int getCount();
}
