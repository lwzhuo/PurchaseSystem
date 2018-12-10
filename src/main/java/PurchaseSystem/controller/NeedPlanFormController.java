package PurchaseSystem.controller;

import PurchaseSystem.model.Form.NeedPlanForm;
import PurchaseSystem.model.Goods.DetailItem;
import PurchaseSystem.service.IneedPlanFormService;
import PurchaseSystem.util.returnJson;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping(value = "/needplanform")
public class NeedPlanFormController {
    @Resource
    IneedPlanFormService needPlanFormService;
    @PostMapping(value = "/insert",consumes = "application/json",produces = "application/json")
    public @ResponseBody String addNeedPlanForm(@RequestBody NeedPlanForm form){
        int num = needPlanFormService.addNPF(form);
        if(num<0) return returnJson.returnError();
        else return returnJson.returnOK();
    }

    @GetMapping(value = "/delete")
    public @ResponseBody String deleteNeedPlanForm(@RequestParam int id){
        int num = needPlanFormService.deleteNPF(id);
        if(num<0) return returnJson.returnError();
        else return returnJson.returnOK();
    }

    @PostMapping(value = "deletebatch",consumes = "application/json",produces = "application/json")
    public @ResponseBody String deleteNeedPlanFormBatch(@RequestBody HashMap hashMap){
        List deleteList = (List)hashMap.get("deleteList");
        int num = needPlanFormService.deleteNPFBatch(deleteList);
        if(num<0) return returnJson.returnError();
        else return returnJson.returnOK();
    }

    @PostMapping(value = "update",consumes = "application/json",produces = "application/json")
    public @ResponseBody String updateNeedPlanForm(@RequestBody HashMap<String,NeedPlanForm> hashMap){
        NeedPlanForm npf = hashMap.get("form");
        int num = needPlanFormService.updateNPF(npf);
        if(num<0) return returnJson.returnError();
        else return returnJson.returnOK();
    }

    @PostMapping(value = "updatebatch",consumes = "application/json",produces = "application/json")
    public @ResponseBody String updateNeedPlanFormBatch(@RequestBody HashMap<String,List<NeedPlanForm>> hashMap){
        List<NeedPlanForm> formlist = hashMap.get("formlist");
        int num = needPlanFormService.updateNPFBatch(formlist);
        if(num<0) return returnJson.returnError();
        else return returnJson.returnOK();
    }
    @GetMapping(value = "/getlist",produces = "application/json")
    public @ResponseBody HashMap getNeedPlanFormBatch(@RequestParam int base,@RequestParam int offset){
        HashMap hashMap = (HashMap) needPlanFormService.getBriefNPFBatch(base,offset);
        hashMap.put("sum",needPlanFormService.getCount());
        return hashMap;
    }
    @GetMapping(value = "/detail/get",produces = "application/json")
    public @ResponseBody HashMap getNeedPlanFormDetail(@RequestParam int id){
        return (HashMap) needPlanFormService.getNPFDetailById(id);
    }
    @PostMapping(value = "/detail/insert",consumes = "application/json",produces = "application/json")
    public @ResponseBody String insertDetailItem(@RequestBody HashMap hashMap){
        int formid = (int)hashMap.get("formId");
        List<DetailItem> detailItems = (List<DetailItem>)hashMap.get("detailList");
        int num = needPlanFormService.addNPFDetailItem(formid,detailItems);
        if(num<0) return returnJson.returnError();
        else return returnJson.returnOK();
    }
    @PostMapping(value = "/detail/delete",consumes = "application/json",produces = "application/json")
    public @ResponseBody String deleteDetailItem(@RequestBody HashMap hashMap){
        List<Integer> detailItems = (List<Integer>)hashMap.get("deleteList");
        int num = needPlanFormService.deleteNPFDetailItem(detailItems);
        if(num<0) return returnJson.returnError();
        else return returnJson.returnOK();
    }
}
