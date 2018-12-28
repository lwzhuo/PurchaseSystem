package purchasesystem.service;
import purchasesystem.model.goods.DetailItem;
import purchasesystem.model.store.OutStoreForm;

import java.util.List;
import java.util.Map;

public interface IoutStoreFormService {
    public long addOSF(OutStoreForm form);
    public int deleteOSF(int id);
    public int deleteOSFBatch(List<Integer> deleteList);
    public int updateOSF(OutStoreForm form);
    public int updateOSFBatch(List<OutStoreForm> formList);
    public Map getBriefOSFBatch(int base, int offset);//没有详细的具体货物信息，只是摘要
    public Map getOSFDetailById(int id);//获得某一需求计划单的详情货物信息
    public int getCount();
    public int deleteOSFDetailItem(List<Integer> deleteList);
    public int addOSFDetailItem(int formid,List<DetailItem> detailList);
}
