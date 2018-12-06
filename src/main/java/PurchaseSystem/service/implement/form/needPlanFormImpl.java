package PurchaseSystem.service.implement.form;

import PurchaseSystem.dao.Form.FormDao;
import PurchaseSystem.dao.Form.FormDetailDao;
import PurchaseSystem.model.Form.NeedPlanForm;
import PurchaseSystem.model.Form.form;
import PurchaseSystem.service.IneedPlanFormService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service("needPlanFormService")
public class needPlanFormImpl extends abstractFormImpl implements IneedPlanFormService {
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
    public int addNPF(NeedPlanForm npf){
        return addForm(npf);
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
    public int updateNPF(NeedPlanForm npf){
        return updateForm(npf);
    }
    @Transactional(propagation = Propagation.REQUIRED)
    public int updateNPFBatch(List<NeedPlanForm> npfList){
        return updateFormBatch(npfList);
    }
    public Map getBriefNPFBatch(int base, int offset) {//没有详细的具体货物信息，只是摘要
        return getBriefFormBatch(base,offset);
    }
    public Map getNPFDetailById(int id){//获得某一需求计划单的详情货物信息
        return getFormDetailById(id);
    }
}
