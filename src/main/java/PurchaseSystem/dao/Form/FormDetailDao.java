package PurchaseSystem.dao.Form;

import PurchaseSystem.model.Goods.DetailItem;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface FormDetailDao {
    public int insertDetail(@Param("table") String table,@Param("detailList") List<DetailItem> detailList,@Param("formid") long formid);
    public int deleteDetail(@Param("table") String table,@Param("formid") long formid);
    public int updateDetail(@Param("table") String table,@Param("detailList") List<DetailItem> detailList);
    public List<Map> selectDetailByFormId(@Param("table") String table,@Param("id") long id);
}