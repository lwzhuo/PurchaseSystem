package PurchaseSystem.service.implement.form;

import PurchaseSystem.dao.Form.FormDao;
import PurchaseSystem.dao.Form.FormDetailDao;
import PurchaseSystem.model.Form.PurchasePlanForm;
import PurchaseSystem.model.Goods.DetailItem;
import PurchaseSystem.service.IpurchasePlanFormService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service("purchasePlanService")
public class purchasePlanFormImpl extends abstractFormImpl implements IpurchasePlanFormService {
    @Resource(name = "purchasePlanFormDao")
    public void setFormDao(FormDao formDao){
        this.formDao = formDao;
    }

    @Value("purchaseplan_detail")
    public void setTablename(String tablename){
        this.tablename = tablename;
    }

    @Resource
    public void setFdDao(FormDetailDao fdDao){
        this.fdDao = fdDao;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public long addPPF(PurchasePlanForm form){
        return addForm(form);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public int deletePPF(int id){
        return deleteForm(id);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public int deletePPFBatch(List<Integer> deleteList){
        return deleteFormBatch(deleteList);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public int updatePPF(PurchasePlanForm form){
        return updateForm(form);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public int updatePPFBatch(List<PurchasePlanForm> formList){
        return updateFormBatch(formList);
    }

    public Map getBriefPPFBatch(int base, int offset) {//没有详细的具体货物信息，只是摘要
        return getBriefFormBatch(base,offset);
    }

    public Map getPPFDetailById(int id){//获得某一需求计划单的详情货物信息
        return getFormDetailById(id);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public int deletePPFDetailItem(List<Integer> deleteList){
        return deleteFormDetailItem(deleteList);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public int addPPFDetailItem(int formid,List<DetailItem> detailList){
        return addFormDetailItem(formid,detailList);
    }
}
