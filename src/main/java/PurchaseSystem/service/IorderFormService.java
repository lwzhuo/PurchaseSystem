package PurchaseSystem.service;

import PurchaseSystem.model.Form.OrderForm;

import java.util.List;
import java.util.Map;

public interface IorderFormService {
    public int addOF(OrderForm form);
    public int deleteOF(int id);
    public int deleteOFBatch(List<Integer> deleteList);
    public int updateOF(OrderForm form);
    public int updateOFBatch(List<OrderForm> formList);
    public Map getBriefOFBatch(int base, int offset);//没有详细的具体货物信息，只是摘要
    public Map getOFDetailById(int id);//获得某一需求计划单的详情货物信息
    public int getCount();
}
