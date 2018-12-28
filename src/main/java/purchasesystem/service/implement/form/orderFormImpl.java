package purchasesystem.service.implement.form;

import purchasesystem.dao.Form.FormDao;
import purchasesystem.dao.Form.FormDetailDao;
import purchasesystem.model.Form.OrderForm;
import purchasesystem.model.Goods.DetailItem;
import purchasesystem.service.IorderFormService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service("orderFormService")
public class orderFormImpl extends abstractFormImpl implements IorderFormService {
    @Resource(name = "orderFormDao")
    public void setFormDao(FormDao formDao){
        this.formDao = formDao;
    }

    @Value("orderform_detail")
    public void setTablename(String tablename){
        this.tablename = tablename;
    }

    @Resource
    public void setFdDao(FormDetailDao fdDao){
        this.fdDao = fdDao;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public long addOF(OrderForm form){
        return addForm(form);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public int deleteOF(int id){
        return deleteForm(id);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public int deleteOFBatch(List<Integer> deleteList){
        return deleteFormBatch(deleteList);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public int updateOF(OrderForm form){
        return updateForm(form);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public int updateOFBatch(List<OrderForm> formList){
        return updateFormBatch(formList);
    }

    public Map getBriefOFBatch(int base, int offset) {//没有详细的具体货物信息，只是摘要
        return getBriefFormBatch(base,offset);
    }

    public Map getOFDetailById(int id){//获得某一需求计划单的详情货物信息
        return getFormDetailById(id);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public int deleteOFDetailItem(List<Integer> deleteList){
        return deleteFormDetailItem(deleteList);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public int addOFDetailItem(int formid,List<DetailItem> detailList){
        return addFormDetailItem(formid,detailList);
    }
}
