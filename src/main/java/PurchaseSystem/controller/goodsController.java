package PurchaseSystem.controller;

import PurchaseSystem.model.Goods.Goods;
import PurchaseSystem.service.IGoodsService;
import PurchaseSystem.util.returnJson;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping("/goods")
public class goodsController {
    @Resource
    private IGoodsService goodsService;

    //insert
    @PostMapping(value = "/insert",consumes = "application/json",produces = "application/json")
    public String addGoods(@RequestBody Goods goods){
        int num = goodsService.insertGoods(goods);
        if(num==1) return returnJson.returnOK();
        else return returnJson.returnError();
    }

    //delete
    @GetMapping(value = "/delete",produces = "application/json")
    public String deleteGoods(@RequestParam int id){
        int num = goodsService.deleteGoods(id);
        if(num==0) return returnJson.returnOK();
        else return returnJson.returnError();
    }

    @PostMapping(value = "/deletebatch",consumes = "application/json",produces = "application/json")
    public String deleteGoodsBatch(@RequestBody HashMap hashMap){
        List deleteList = (List)hashMap.get("deleteList");
        Iterator iterator = deleteList.iterator();
        hashMap.remove("deleteList");
        int num = goodsService.deleteGoodsBatch(iterator);
        if(num==0) return returnJson.returnOK();
        else return returnJson.returnError();
    }

    //update
    @PostMapping(value = "/update",consumes = "application/json",produces = "application/json")
    public String updateGoods(@RequestBody HashMap<String,Goods> hashMap){
        Goods goods = hashMap.get("goods");
        hashMap.remove("goods");
        int num = goodsService.updateGoods(goods);
        if(num==1) return returnJson.returnOK();
        else return returnJson.returnError();
    }

    @PostMapping(value = "/updatebatch",consumes = "application/json",produces = "application/json")
    public String updateGoodsBatch(@RequestBody HashMap<String,List<Goods>> hashMap){
        List<Goods> goodsList = hashMap.get("goodsList");
        Iterator it = goodsList.iterator();
        int num = goodsService.updateGoodsBatch(it);
        if(num==goodsList.size()) return returnJson.returnOK();
        else return returnJson.returnError();
    }
    //select
    @GetMapping(value = "/get",produces = "application/json")
    public @ResponseBody HashMap getGoods(@RequestParam int id){
        return goodsService.selectGoodsById(id);
    }

    @GetMapping(value = "/getlist",produces = "application/json")
    public @ResponseBody HashMap getGoodsList(@RequestParam int type,@RequestParam int base,@RequestParam int offset){
        return goodsService.selectGoods(type,base,offset);
    }

    @GetMapping(value = "/typelist",produces = "application/json")
    public @ResponseBody HashMap getTypeList(){
        HashMap hashMap = new HashMap();
        List list = goodsService.getTypeList();
        hashMap.put("typeList",list);
        hashMap.put("num",list.size());
        return hashMap;
    }
}
