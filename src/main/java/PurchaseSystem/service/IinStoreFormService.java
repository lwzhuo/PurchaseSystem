package PurchaseSystem.service;

import PurchaseSystem.model.Goods.DetailItem;
import PurchaseSystem.model.Store.InStoreForm;

import java.util.List;
import java.util.Map;

public interface IinStoreFormService {
    public long addISF(InStoreForm form);
    public int deleteISF(int id);
    public int deleteISFBatch(List<Integer> deleteList);
    public int updateISF(InStoreForm form);
    public int updateISFBatch(List<InStoreForm> formList);
    public Map getBriefISFBatch(int base, int offset);//没有详细的具体货物信息，只是摘要
    public Map getISFDetailById(int id);//获得某一需求计划单的详情货物信息
    public int getCount();
    public int deleteISFDetailItem(List<Integer> deleteList);
    public int addISFDetailItem(int formid,List<DetailItem> detailList);
}
