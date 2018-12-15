package PurchaseSystem.service;

import PurchaseSystem.model.Form.NeedPlanForm;
import PurchaseSystem.model.Goods.DetailItem;

import java.util.List;
import java.util.Map;

public interface IneedPlanFormService {
    public long addNPF(NeedPlanForm form);
    public int deleteNPF(int id);
    public int deleteNPFBatch(List<Integer> deleteList);
    public int updateNPF(NeedPlanForm form);
    public int updateNPFBatch(List<NeedPlanForm> formList);
    public Map getBriefNPFBatch(int base,int offset);//没有详细的具体货物信息，只是摘要
    public Map getNPFDetailById(int id);//获得某一需求计划单的详情货物信息
    public int getCount();
    public int deleteNPFDetailItem(List<Integer> deleteList);
    public int addNPFDetailItem(int formid,List<DetailItem> detailList);
}
