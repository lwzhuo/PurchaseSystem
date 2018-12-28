package purchasesystem.service.implement.form;

import purchasesystem.dao.form.FormDao;
import purchasesystem.dao.form.FormDetailDao;
import purchasesystem.model.form.NeedPlanForm;
import purchasesystem.model.Goods.DetailItem;
import purchasesystem.service.IneedPlanFormService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service("needPlanFormService")
public class NeedPlanFormImpl extends AbstractFormImpl implements IneedPlanFormService {
    @Resource(name = "needPlanFormDao")
    public void setFormDao(FormDao formDao){
        this.formDao = formDao;
    }

    @Value("needform_detail")
    public void setTablename(String tablename){
        this.tablename = tablename;
    }

    @Resource
    public void setFdDao(FormDetailDao fdDao){
        this.fdDao = fdDao;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public long addNPF(NeedPlanForm form){
        return addForm(form);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public int deleteNPF(int id){
        return deleteForm(id);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public int deleteNPFBatch(List<Integer> deleteList){
        return deleteFormBatch(deleteList);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public int updateNPF(NeedPlanForm form){
        return updateForm(form);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public int updateNPFBatch(List<NeedPlanForm> formList){
        return updateFormBatch(formList);
    }

    public Map getBriefNPFBatch(int base, int offset) {//没有详细的具体货物信息，只是摘要
        return getBriefFormBatch(base,offset);
    }

    public Map getNPFDetailById(int id){//获得某一需求计划单的详情货物信息
        return getFormDetailById(id);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public int deleteNPFDetailItem(List<Integer> deleteList){
        return deleteFormDetailItem(deleteList);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public int addNPFDetailItem(int formid,List<DetailItem> detailList){
        return addFormDetailItem(formid,detailList);
    }
}
