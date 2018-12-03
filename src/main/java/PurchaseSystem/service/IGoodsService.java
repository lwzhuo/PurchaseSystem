package PurchaseSystem.service;

import PurchaseSystem.model.Goods.Goods;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public interface IGoodsService {
    public int insertGoods(Goods goods);
    public int deleteGoods(int id);
    public int deleteGoodsBatch(Iterator it);
    public int updateGoods(Goods goods);
    public int updateGoodsBatch(Iterator it);
    public HashMap selectGoodsById(int id);
    public HashMap selectGoods(int base, int offset);
    public List<HashMap> getTypeList();
}
