package PurchaseSystem.service;

import PurchaseSystem.model.Form.ReceiptForm;

import java.util.List;
import java.util.Map;

public interface IreceiptFormService {
    public int addRF(ReceiptForm form);
    public int deleteRF(int id);
    public int deleteRFBatch(List<Integer> deleteList);
    public int updateRF(ReceiptForm form);
    public int updateRFBatch(List<ReceiptForm> formList);
    public Map getBriefRFBatch(int base, int offset);//没有详细的具体货物信息，只是摘要
    public Map getRFDetailById(int id);//获得某一需求计划单的详情货物信息
    public int getCount();
}