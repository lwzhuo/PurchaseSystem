package PurchaseSystem.dao.Form;

import PurchaseSystem.model.Form.NeedPlanForm;
import org.apache.ibatis.annotations.Param;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public interface needPlanFormDao {
    public List<HashMap> selectNPFormBatch(@Param("base")int base,@Param("offset")int offset);
    public int insertNPForm(NeedPlanForm npf);
    public int updateNPForm(NeedPlanForm npf);
    public int deleteNPForm(int id);
    public int getCount();
}
