package purchasesystem.service;

import purchasesystem.model.form.PurchasePlanForm;
import purchasesystem.model.goods.DetailItem;

import java.util.List;
import java.util.Map;

public interface IpurchasePlanFormService {
    public long addPPF(PurchasePlanForm form);
    public int deletePPF(int id);
    public int deletePPFBatch(List<Integer> deleteList);
    public int updatePPF(PurchasePlanForm form);
    public int updatePPFBatch(List<PurchasePlanForm> formList);
    public Map getBriefPPFBatch(int base, int offset);//没有详细的具体货物信息，只是摘要
    public Map getPPFDetailById(int id);//获得某一需求计划单的详情货物信息
    public int getCount();
    public int deletePPFDetailItem(List<Integer> deleteList);
    public int addPPFDetailItem(int formid,List<DetailItem> detailList);
}
