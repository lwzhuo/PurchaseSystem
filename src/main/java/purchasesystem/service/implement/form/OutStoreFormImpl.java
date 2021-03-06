package purchasesystem.service.implement.form;

import purchasesystem.dao.form.FormDao;
import purchasesystem.dao.form.FormDetailDao;
import purchasesystem.model.goods.DetailItem;
import purchasesystem.model.store.OutStoreForm;
import purchasesystem.service.IoutStoreFormService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service("outStoreFormService")
public class OutStoreFormImpl extends AbstractFormImpl implements IoutStoreFormService {
    @Resource(name = "outStoreFormDao")
    public void setFormDao(FormDao formDao){
        this.formDao = formDao;
    }

    @Value("outstoreform_detail")
    public void setTablename(String tablename){
        this.tablename = tablename;
    }

    @Resource
    public void setFdDao(FormDetailDao fdDao){
        this.fdDao = fdDao;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public long addOSF(OutStoreForm form){
        return addForm(form);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public int deleteOSF(int id){
        return deleteForm(id);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public int deleteOSFBatch(List<Integer> deleteList){
        return deleteFormBatch(deleteList);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public int updateOSF(OutStoreForm form){
        return updateForm(form);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public int updateOSFBatch(List<OutStoreForm> formList){
        return updateFormBatch(formList);
    }

    public Map getBriefOSFBatch(int base, int offset) {//没有详细的具体货物信息，只是摘要
        return getBriefFormBatch(base,offset);
    }

    public Map getOSFDetailById(int id){//获得某一需求计划单的详情货物信息
        return getFormDetailById(id);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public int deleteOSFDetailItem(List<Integer> deleteList){
        return deleteFormDetailItem(deleteList);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public int addOSFDetailItem(int formid,List<DetailItem> detailList){
        return addFormDetailItem(formid,detailList);
    }
}
