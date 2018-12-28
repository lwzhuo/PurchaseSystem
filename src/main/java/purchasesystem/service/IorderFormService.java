package purchasesystem.service;

import purchasesystem.model.form.OrderForm;
import purchasesystem.model.Goods.DetailItem;

import java.util.List;
import java.util.Map;

public interface IorderFormService {
    public long addOF(OrderForm form);
    public int deleteOF(int id);
    public int deleteOFBatch(List<Integer> deleteList);
    public int updateOF(OrderForm form);
    public int updateOFBatch(List<OrderForm> formList);
    public Map getBriefOFBatch(int base, int offset);//没有详细的具体货物信息，只是摘要
    public Map getOFDetailById(int id);//获得某一需求计划单的详情货物信息
    public int getCount();
    public int deleteOFDetailItem(List<Integer> deleteList);
    public int addOFDetailItem(int formid,List<DetailItem> detailList);
}
