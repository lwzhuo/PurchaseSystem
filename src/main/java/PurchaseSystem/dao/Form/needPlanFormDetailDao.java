package PurchaseSystem.dao.Form;

import PurchaseSystem.model.Goods.DetailItem;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface needPlanFormDetailDao {
    public int insertDetail(@Param("detailList") List<DetailItem> detailList,@Param("formid") long formid);
    public int deleteDetail(long formid);
    public int updateDetail(@Param("detailList") List<DetailItem> detailList);
    public List<Map> selectDetailByFormId(long id);
}
