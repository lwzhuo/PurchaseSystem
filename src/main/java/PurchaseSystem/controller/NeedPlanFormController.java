package PurchaseSystem.controller;

import PurchaseSystem.model.Form.NeedPlanForm;
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
    public @ResponseBody String addNeedPlanForm(@RequestBody NeedPlanForm npf){
        int num = needPlanFormService.addNPF(npf);
        if(num<0) return returnJson.returnError();
        else return returnJson.returnOK();
    }

    @GetMapping(value = "/delete/{id}")
    public @ResponseBody String deleteNeedPlanForm(@PathVariable("id") int id){
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
        NeedPlanForm npf = (NeedPlanForm)hashMap.get("npform");
        int num = needPlanFormService.updateNPF(npf);
        if(num<0) return returnJson.returnError();
        else return returnJson.returnOK();
    }

    @PostMapping(value = "updatebatch",consumes = "application/json",produces = "application/json")
    public @ResponseBody String updateNeedPlanFormBatch(@RequestBody HashMap<String,List<NeedPlanForm>> hashMap){
        List<NeedPlanForm> npflist = hashMap.get("npfList");
        int num = needPlanFormService.updateNPFBatch(npflist);
        if(num<0) return returnJson.returnError();
        else return returnJson.returnOK();
    }
    @GetMapping(value = "/{base:[0-9]+}-{offset:[0-9]+}",produces = "application/json")
    public @ResponseBody HashMap getNeedPlanFormBatch(@PathVariable("base")int base,@PathVariable("offset")int offset){
        HashMap hashMap = (HashMap) needPlanFormService.getBriefNPFBatch(base,offset);
        hashMap.put("sum",needPlanFormService.getCount());
        return hashMap;
    }
    @GetMapping(value = "/detail/{id}",produces = "application/json")
    public @ResponseBody HashMap getNeedPlanFormDetail(@PathVariable("id")int id){
        return (HashMap) needPlanFormService.getNPFDetailById(id);
    }
}
