package PurchaseSystem.controller;

import PurchaseSystem.model.Form.PurchasePlanForm;
import PurchaseSystem.service.IpurchasePlanFormService;
import PurchaseSystem.util.returnJson;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value = "/purchaseplanform")
public class PurchasePlanFormController {
    @Resource
    IpurchasePlanFormService purchasePlanFormService;
    @PostMapping(value = "/insert",consumes = "application/json",produces = "application/json")
    public @ResponseBody
    String addPurchasePlanForm(@RequestBody PurchasePlanForm form){
        int num = purchasePlanFormService.addPPF(form);
        if(num<0) return returnJson.returnError();
        else return returnJson.returnOK();
    }

    @GetMapping(value = "/delete")
    public @ResponseBody String deletePurchasePlanForm(@RequestParam int id){
        int num = purchasePlanFormService.deletePPF(id);
        if(num<0) return returnJson.returnError();
        else return returnJson.returnOK();
    }

    @PostMapping(value = "deletebatch",consumes = "application/json",produces = "application/json")
    public @ResponseBody String deletePurchasePlanFormBatch(@RequestBody HashMap hashMap){
        List deleteList = (List)hashMap.get("deleteList");
        int num = purchasePlanFormService.deletePPFBatch(deleteList);
        if(num<0) return returnJson.returnError();
        else return returnJson.returnOK();
    }

    @PostMapping(value = "update",consumes = "application/json",produces = "application/json")
    public @ResponseBody String updatePurchasePlanForm(@RequestBody HashMap<String,PurchasePlanForm> hashMap){
        PurchasePlanForm form = hashMap.get("form");
        int num = purchasePlanFormService.updatePPF(form);
        if(num<0) return returnJson.returnError();
        else return returnJson.returnOK();
    }

    @PostMapping(value = "updatebatch",consumes = "application/json",produces = "application/json")
    public @ResponseBody String updatePurchasePlanFormBatch(@RequestBody HashMap<String,List<PurchasePlanForm>> hashMap){
        List<PurchasePlanForm> formlist = hashMap.get("formlist");
        int num = purchasePlanFormService.updatePPFBatch(formlist);
        if(num<0) return returnJson.returnError();
        else return returnJson.returnOK();
    }
    @GetMapping(value = "/getlist",produces = "application/json")
    public @ResponseBody HashMap getPurchasePlanFormBatch(@RequestParam int base,@RequestParam int offset){
        HashMap hashMap = (HashMap) purchasePlanFormService.getBriefPPFBatch(base,offset);
        hashMap.put("sum",purchasePlanFormService.getCount());
        return hashMap;
    }
    @GetMapping(value = "/detail/get",produces = "application/json")
    public @ResponseBody HashMap getPurchasePlanFormDetail(@RequestParam int id){
        return (HashMap) purchasePlanFormService.getPPFDetailById(id);
    }
}
