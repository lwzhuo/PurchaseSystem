package purchasesystem.controller;

import purchasesystem.model.form.PurchasePlanForm;
import purchasesystem.model.goods.DetailItem;
import purchasesystem.service.IpurchasePlanFormService;
import purchasesystem.util.ReturnJson;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

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
    public @ResponseBody String deletePurchasePlanFormBatch(@RequestBody Map map){
        List deleteList = (List)map.get("deleteList");
        int num = purchasePlanFormService.deletePPFBatch(deleteList);
        if(num<0) return ReturnJson.returnError();
        else return ReturnJson.returnOK();
    }

    @PostMapping(value = "update",consumes = "application/json",produces = "application/json")
    public @ResponseBody String updatePurchasePlanForm(@RequestBody Map<String,PurchasePlanForm> map){
        PurchasePlanForm form = map.get("form");
        int num = purchasePlanFormService.updatePPF(form);
        if(num<0) return ReturnJson.returnError();
        else return ReturnJson.returnOK();
    }

    @PostMapping(value = "updatebatch",consumes = "application/json",produces = "application/json")
    public @ResponseBody String updatePurchasePlanFormBatch(@RequestBody Map<String,List<PurchasePlanForm>> map){
        List<PurchasePlanForm> formlist = map.get("formlist");
        int num = purchasePlanFormService.updatePPFBatch(formlist);
        if(num<0) return ReturnJson.returnError();
        else return ReturnJson.returnOK();
    }
    @GetMapping(value = "/getlist",produces = "application/json")
    public @ResponseBody Map getPurchasePlanFormBatch(@RequestParam int base,@RequestParam int offset){
        HashMap hashMap = (HashMap) purchasePlanFormService.getBriefPPFBatch(base,offset);
        hashMap.put("sum",purchasePlanFormService.getCount());
        return hashMap;
    }
    @GetMapping(value = "/detail/get",produces = "application/json")
    public @ResponseBody Map getPurchasePlanFormDetail(@RequestParam int id){
        return purchasePlanFormService.getPPFDetailById(id);
    }
    @PostMapping(value = "/detail/insert",consumes = "application/json",produces = "application/json")
    public @ResponseBody String insertDetailItem(@RequestBody Map map){
        int formid = (int)map.get("formId");
        List<DetailItem> detailItems = (List<DetailItem>)map.get("detailList");
        int num = purchasePlanFormService.addPPFDetailItem(formid,detailItems);
        if(num<0) return ReturnJson.returnError();
        else return ReturnJson.returnOK();
    }
    @PostMapping(value = "/detail/delete",consumes = "application/json",produces = "application/json")
    public @ResponseBody String deleteDetailItem(@RequestBody Map map){
        List<Integer> detailItems = (List<Integer>)map.get("deleteList");
        int num = purchasePlanFormService.deletePPFDetailItem(detailItems);
        if(num<0) return ReturnJson.returnError();
        else return ReturnJson.returnOK();
    }
}
