package PurchaseSystem.service.implement.form;

import PurchaseSystem.dao.Form.needPlanFormDao;
import PurchaseSystem.dao.Form.FormDetailDao;
import PurchaseSystem.model.Form.NeedPlanForm;
import PurchaseSystem.service.IneedPlanFormService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

@Service("needPlanFormService")
public class needPlanFormImpl implements IneedPlanFormService {
    @Resource
    private needPlanFormDao npfDao;
    @Resource
    private FormDetailDao npfdDao;

    @Transactional(propagation = Propagation.REQUIRED)
    public int addNPF(NeedPlanForm npf){
        int num=0;
        try {
            List detailList = npf.getDetailList();
            npfDao.insertNPForm(npf);
            npfdDao.insertDetail("needform_detail",detailList,npf.getId());
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();//手动执行回滚
            num=-1;
        }
        return num;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public int deleteNPF(int id){
        int num=0;
        try {
            npfdDao.deleteDetail("needform_detail",id);
            npfDao.deleteNPForm(id);
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            num=-1;
        }
        return num;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public int deleteNPFBatch(List<Integer> deleteList){
        int num=0;
        try {
            for(int id:deleteList){
                npfdDao.deleteDetail("needform_detail",id);
                npfDao.deleteNPForm(id);
            }
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            num=-1;
        }
        return num;
    }
    @Transactional(propagation = Propagation.REQUIRED)
    public int updateNPF(NeedPlanForm npf){
        int num=0;
        try {
            npfDao.updateNPForm(npf);
            if(npf.getDetailList()!=null)
                npfdDao.updateDetail("needform_detail",npf.getDetailList());
        }catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            num = -1;
        }
        return num;
    }
    @Transactional(propagation = Propagation.REQUIRED)
    public int updateNPFBatch(List<NeedPlanForm> npfList){
        int num=0;
        try {
            Iterator it = npfList.iterator();
            while (it.hasNext()){
                NeedPlanForm npf = (NeedPlanForm)it.next();
                npfDao.updateNPForm(npf);
                if(npf.getDetailList()!=null)
                    npfdDao.updateDetail("needform_detail",npf.getDetailList());
            }
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            num=-1;
        }
        return num;
    }
    public HashMap getBriefNPFBatch(int base, int offset){//没有详细的具体货物信息，只是摘要
        HashMap map = new HashMap();
        List list = npfDao.selectNPFormBatch(base,offset);
        map.put("npfList",list);
        map.put("batchNum",list.size());
        return map;
    }

    public HashMap getNPFDetailById(int id){//获得某一需求计划单的详情货物信息
        HashMap map = new HashMap();
        List list = npfdDao.selectDetailByFormId("needform_detail",id);
        map.put("detailList",list);
        map.put("num",list.size());
        map.put("formId",id);
        return map;
    }
    public int getCount(){
        return npfDao.getCount();
    }
}
