package PurchaseSystem.service.implement.form;

import PurchaseSystem.dao.Form.FormDao;
import PurchaseSystem.dao.Form.FormDetailDao;
import PurchaseSystem.model.Form.form;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public abstract class abstractFormImpl {
    protected FormDetailDao fdDao;
    protected FormDao formDao;
    protected String tablename;

    public abstract void setFormDao(FormDao formDao);
    public abstract void setFdDao(FormDetailDao fdDao);
    public abstract void setTablename(String tablename);
    public int addForm(form f){
        int num=0;
        try {
            List detailList = f.getDetailList();
            formDao.insertForm(f);
            fdDao.insertDetail(tablename,detailList,f.getId());
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();//手动执行回滚
            num=-1;
        }
        return num;
    }

    public int deleteForm(int id){
        int num=0;
        try {
            fdDao.deleteDetail(tablename,id);
            formDao.deleteForm(id);
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            num=-1;
        }
        return num;
    }

    public int deleteFormBatch(List<Integer> deleteList){
        int num=0;
        try {
            for(int id:deleteList){
                fdDao.deleteDetail(tablename,id);
                formDao.deleteForm(id);
            }
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            num=-1;
        }
        return num;
    }

    public int updateForm(form f){
        int num=0;
        try {
            formDao.updateForm(f);
            if(f.getDetailList()!=null)
                fdDao.updateDetail(tablename,f.getDetailList());
        }catch (Exception e) {
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            num = -1;
        }
        return num;
    }

    public int updateFormBatch(List<? extends form> fList){
        int num=0;
        try {
            Iterator<? extends form> it = fList.iterator();
            while (it.hasNext()){
                form f = it.next();
                formDao.updateForm(f);
                if(f.getDetailList()!=null)
                    fdDao.updateDetail(tablename,f.getDetailList());
            }
        }catch (Exception e){
            e.printStackTrace();
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            num=-1;
        }
        return num;
    }
    public HashMap getBriefFormBatch(int base, int offset){//没有详细的具体货物信息，只是摘要
        HashMap map = new HashMap();
        List list = formDao.selectFormBatch(base,offset);
        map.put("formList",list);
        map.put("batchNum",list.size());
        return map;
    }

    public HashMap getFormDetailById(int id){//获得某一需求计划单的详情货物信息
        HashMap map = new HashMap();
        List list = fdDao.selectDetailByFormId(tablename,id);
        map.put("detailList",list);
        map.put("num",list.size());
        map.put("formId",id);
        return map;
    }
    public int getCount(){
        return formDao.getCount();
    }
}
