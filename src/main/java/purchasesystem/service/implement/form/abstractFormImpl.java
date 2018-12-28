package purchasesystem.service.implement.form;

import purchasesystem.dao.Form.FormDao;
import purchasesystem.dao.Form.FormDetailDao;
import purchasesystem.model.Form.form;
import purchasesystem.model.Goods.DetailItem;
import org.apache.log4j.Logger;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

public abstract class abstractFormImpl {
    protected FormDetailDao fdDao;
    protected FormDao formDao;
    protected String tablename;
    private static Logger logger = Logger.getLogger(abstractFormImpl.class);
    public abstract void setFormDao(FormDao formDao);
    public abstract void setFdDao(FormDetailDao fdDao);
    public abstract void setTablename(String tablename);
    //新增一个表
    public long addForm(form f){
        long num=0;
        try {
            List detailList = f.getDetailList();
            formDao.insertForm(f);
            fdDao.insertDetail(tablename,detailList,f.getId());
            num = f.getId();
            System.out.println(num);
        }catch (Exception e){
            logger.error(e);
            logger.info(e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();//手动执行回滚
            num=-1;
        }
        return num;
    }
    //给某一个表增加一条或者多条detail项目
    public int addFormDetailItem(int formid,List<DetailItem> detailList){
        int num=0;
        try{
            fdDao.insertDetail(tablename,detailList,formid);
        }catch (Exception e){
            logger.error(e);
            logger.info(e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();//手动执行回滚
            num=-1;
        }
        return num;
    }
    //删除一个form
    public int deleteForm(int id){
        int num=0;
        try {
            fdDao.deleteDetail(tablename,id);
            formDao.deleteForm(id);
        }catch (Exception e){
            logger.error(e);
            logger.info(e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            num=-1;
        }
        return num;
    }
    //批量删除form
    public int deleteFormBatch(List<Integer> deleteList){
        int num=0;
        try {
            for(int id:deleteList){
                fdDao.deleteDetail(tablename,id);
                formDao.deleteForm(id);
            }
        }catch (Exception e){
            logger.error(e);
            logger.info(e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            num=-1;
        }
        return num;
    }
    //删除某一个表的detailitem表项
    public int deleteFormDetailItem(List<Integer> deleteList){
        int num=0;
        try {
            for(int id:deleteList){
                fdDao.deleteDetailItem(tablename,id);
            }
        }catch (Exception e){
            logger.error(e);
            logger.info(e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            num=-1;
        }
        return num;
    }
    //更新表
    public int updateForm(form f){
        int num=0;
        try {
            formDao.updateForm(f);
            if(f.getDetailList()!=null)
                fdDao.updateDetail(tablename,f.getDetailList());
        }catch (Exception e) {
            logger.error(e);
            logger.info(e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            num = -1;
        }
        return num;
    }
    //批量更新表
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
            logger.error(e);
            logger.info(e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            num=-1;
        }
        return num;
    }
    //获得表的简略信息 不含detail项
    public HashMap getBriefFormBatch(int base, int offset){//没有详细的具体货物信息，只是摘要
        HashMap map = new HashMap();
        List list = formDao.selectFormBatch(base,offset);
        map.put("batchNum",list.size());
        map.put("formList",list);
        return map;
    }
    //获得某一个表的对应detail项
    public HashMap getFormDetailById(int id){//获得某一需求计划单的详情货物信息
        HashMap map = new HashMap();
        List list = fdDao.selectDetailByFormId(tablename,id);
        map.put("detailList",list);
        map.put("num",list.size());
        map.put("formId",id);
        return map;
    }
    //获得表的记录的数量
    public int getCount(){
        return formDao.getCount();
    }
}
