package PurchaseSystem.service.implement.form;

import PurchaseSystem.dao.Form.FormDao;
import PurchaseSystem.dao.Form.FormDetailDao;
import PurchaseSystem.model.Form.ReceiptForm;
import PurchaseSystem.service.IreceiptFormService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service("receiptFormService")
public class receiptFormImpl extends abstractFormImpl implements IreceiptFormService {
    @Resource(name = "receiptFormDao")
    public void setFormDao(FormDao formDao){
        this.formDao = formDao;
    }
    @Value("receiptform_detail")
    public void setTablename(String tablename){
        this.tablename = tablename;
    }
    @Resource
    public void setFdDao(FormDetailDao fdDao){
        this.fdDao = fdDao;
    }
    @Transactional(propagation = Propagation.REQUIRED)
    public int addRF(ReceiptForm form){
        return addForm(form);
    }
    @Transactional(propagation = Propagation.REQUIRED)
    public int deleteRF(int id){
        return deleteForm(id);
    }
    @Transactional(propagation = Propagation.REQUIRED)
    public int deleteRFBatch(List<Integer> deleteList){
        return deleteFormBatch(deleteList);
    }
    @Transactional(propagation = Propagation.REQUIRED)
    public int updateRF(ReceiptForm form){
        return updateForm(form);
    }
    @Transactional(propagation = Propagation.REQUIRED)
    public int updateRFBatch(List<ReceiptForm> formList){
        return updateFormBatch(formList);
    }
    public Map getBriefRFBatch(int base, int offset) {//没有详细的具体货物信息，只是摘要
        return getBriefFormBatch(base,offset);
    }
    public Map getRFDetailById(int id){//获得某一需求计划单的详情货物信息
        return getFormDetailById(id);
    }
}