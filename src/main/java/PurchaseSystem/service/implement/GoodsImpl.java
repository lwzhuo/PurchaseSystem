package PurchaseSystem.service.implement;

import PurchaseSystem.dao.goodsDao;
import PurchaseSystem.model.Goods.Goods;
import PurchaseSystem.service.IGoodsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.transaction.interceptor.TransactionAspectSupport;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.apache.log4j.Logger;

@Service
public class GoodsImpl implements IGoodsService {
    @Resource
    private goodsDao goodsDao;
    private Logger logger = Logger.getLogger(GoodsImpl.class);
    public int insertGoods(Goods goods){
        int num=0;
        try {
            num = this.goodsDao.insertGoods(goods);
        }catch (Exception e){
            logger.error(e);
            logger.info(e);
        }
        return num;
    }

    public int deleteGoods(int id){
        int num=0;
        try{
            this.goodsDao.deleteGoods(id);
        }catch (Exception e){
            logger.error(e);
            logger.info(e);
            num = -1;
        }
        return num;
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public int deleteGoodsBatch(Iterator it){
        int num=0;
        try {
            while (it.hasNext())
                this.goodsDao.deleteGoods((int)it.next());
        }catch (Exception e){
            logger.error(e);
            logger.info(e);
            TransactionAspectSupport.currentTransactionStatus().setRollbackOnly();
            num=-1;
        }
        return num;
    }

    public int updateGoods(Goods goods){
        return this.goodsDao.updateGoods(goods);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public int updateGoodsBatch(Iterator it){
        int num=0;
        while (it.hasNext())
            num+=this.goodsDao.updateGoods((Goods)it.next());
        return num;
    }

    public HashMap selectGoodsById(int id){
        List goodsList = this.goodsDao.selectGoodsById(id);
        HashMap hashMap = new HashMap();
        hashMap.put("nums",1);
        hashMap.put("goodsList",goodsList);
        return hashMap;
    }

    public HashMap selectGoods(int type,int base, int offset){
        List goodsList = this.goodsDao.selectGoods(type,base,offset);
        HashMap hashMap = new HashMap();
        hashMap.put("nums",goodsList.size());
        hashMap.put("goodList",goodsList);
        return hashMap;
    }

    public List<HashMap> getTypeList(){
        return this.goodsDao.getTypeList();
    }
}
