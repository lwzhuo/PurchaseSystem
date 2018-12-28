package purchasesystem.controller;

import purchasesystem.model.Form.PurchasePlanForm;
import purchasesystem.model.Goods.DetailItem;
import purchasesystem.service.IpurchasePlanFormService;
import purchasesystem.util.ReturnJson;
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
        long num = purchasePlanFormService.addPPF(form);
        if(num<0) return ReturnJson.returnError();
        else return ReturnJson.returnOKWithExtraData("formId",num);
    }

    @GetMapping(value = "/delete")
    public @ResponseBody String deletePurchasePlanForm(@RequestParam int id){
        int num = purchasePlanFormService.deletePPF(id);
        if(num<0) return ReturnJson.returnError();
        else return ReturnJson.returnOK();
    }

    @PostMapping(value = "deletebatch",consumes = "application/json",produces = "application/json")
    public @ResponseBody String deletePurchasePlanFormBatch(@RequestBody HashMap hashMap){
        List deleteList = (List)hashMap.get("deleteList");
        int num = purchasePlanFormService.deletePPFBatch(deleteList);
        if(num<0) return ReturnJson.returnError();
        else return ReturnJson.returnOK();
    }

    @PostMapping(value = "update",consumes = "application/json",produces = "application/json")
    public @ResponseBody String updatePurchasePlanForm(@RequestBody HashMap<String,PurchasePlanForm> hashMap){
        PurchasePlanForm form = hashMap.get("Form");
        int num = purchasePlanFormService.updatePPF(form);
        if(num<0) return ReturnJson.returnError();
        else return ReturnJson.returnOK();
    }

    @PostMapping(value = "updatebatch",consumes = "application/json",produces = "application/json")
    public @ResponseBody String updatePurchasePlanFormBatch(@RequestBody HashMap<String,List<PurchasePlanForm>> hashMap){
        List<PurchasePlanForm> formlist = hashMap.get("formlist");
        int num = purchasePlanFormService.updatePPFBatch(formlist);
        if(num<0) return ReturnJson.returnError();
        else return ReturnJson.returnOK();
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
    @PostMapping(value = "/detail/insert",consumes = "application/json",produces = "application/json")
    public @ResponseBody String insertDetailItem(@RequestBody HashMap hashMap){
        int formid = (int)hashMap.get("formId");
        List<DetailItem> detailItems = (List<DetailItem>)hashMap.get("detailList");
        int num = purchasePlanFormService.addPPFDetailItem(formid,detailItems);
        if(num<0) return ReturnJson.returnError();
        else return ReturnJson.returnOK();
    }
    @PostMapping(value = "/detail/delete",consumes = "application/json",produces = "application/json")
    public @ResponseBody String deleteDetailItem(@RequestBody HashMap hashMap){
        List<Integer> detailItems = (List<Integer>)hashMap.get("deleteList");
        int num = purchasePlanFormService.deletePPFDetailItem(detailItems);
        if(num<0) return ReturnJson.returnError();
        else return ReturnJson.returnOK();
    }
}
