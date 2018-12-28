package PurchaseSystem.dao;

import PurchaseSystem.model.Goods.Goods;
import org.apache.ibatis.annotations.Param;

import java.util.HashMap;
import java.util.List;

public interface GoodsDao {
    public List<HashMap> selectGoodsById(int id);
    public List<HashMap> selectGoods(@Param("type")int type,@Param("base") int base, @Param("offset") int offset);
    public int insertGoods(Goods goods);
    public int updateGoods(Goods goods);
    public int deleteGoods(int id);
    public List<HashMap> getTypeList();
}
