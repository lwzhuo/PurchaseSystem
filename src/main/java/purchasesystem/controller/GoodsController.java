package purchasesystem.controller;

import purchasesystem.model.Goods.Goods;
import purchasesystem.service.IGoodsService;
import purchasesystem.util.ReturnJson;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/goods")
public class GoodsController {
    @Resource
    private IGoodsService goodsService;

    //insert
    @PostMapping(value = "/insert",consumes = "application/json",produces = "application/json")
    public String addGoods(@RequestBody Goods goods){
        int num = goodsService.insertGoods(goods);
        if(num==1) return ReturnJson.returnOK();
        else return ReturnJson.returnError();
    }

    //delete
    @GetMapping(value = "/delete",produces = "application/json")
    public String deleteGoods(@RequestParam int id){
        int num = goodsService.deleteGoods(id);
        if(num==0) return ReturnJson.returnOK();
        else return ReturnJson.returnError();
    }

    @PostMapping(value = "/deletebatch",consumes = "application/json",produces = "application/json")
    public String deleteGoodsBatch(@RequestBody Map map){
        List deleteList = (List)map.get("deleteList");
        Iterator iterator = deleteList.iterator();
        map.remove("deleteList");
        int num = goodsService.deleteGoodsBatch(iterator);
        if(num==0) return ReturnJson.returnOK();
        else return ReturnJson.returnError();
    }

    //update
    @PostMapping(value = "/update",consumes = "application/json",produces = "application/json")
    public String updateGoods(@RequestBody Map<String,Goods> map){
        Goods goods = map.get("goods");
        map.remove("goods");
        int num = goodsService.updateGoods(goods);
        if(num==1) return ReturnJson.returnOK();
        else return ReturnJson.returnError();
    }

    @PostMapping(value = "/updatebatch",consumes = "application/json",produces = "application/json")
    public String updateGoodsBatch(@RequestBody Map<String,List<Goods>> map){
        List<Goods> goodsList = map.get("goodsList");
        Iterator it = goodsList.iterator();
        int num = goodsService.updateGoodsBatch(it);
        if(num==goodsList.size()) return ReturnJson.returnOK();
        else return ReturnJson.returnError();
    }
    //select
    @GetMapping(value = "/get",produces = "application/json")
    public @ResponseBody Map getGoods(@RequestParam int id){
        return goodsService.selectGoodsById(id);
    }

    @GetMapping(value = "/getlist",produces = "application/json")
    public @ResponseBody Map getGoodsList(@RequestParam int type,@RequestParam int base,@RequestParam int offset){
        return goodsService.selectGoods(type,base,offset);
    }

    @GetMapping(value = "/typelist",produces = "application/json")
    public @ResponseBody Map getTypeList(){
        HashMap hashMap = new HashMap();
        List list = goodsService.getTypeList();
        hashMap.put("typeList",list);
        hashMap.put("num",list.size());
        return hashMap;
    }
}
