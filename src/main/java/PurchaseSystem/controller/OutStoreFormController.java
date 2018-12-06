package PurchaseSystem.controller;

import PurchaseSystem.model.Store.OutStoreForm;
import PurchaseSystem.service.IoutStoreFormService;
import PurchaseSystem.util.returnJson;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/outstoreform")
public class OutStoreFormController {
    @Resource
    IoutStoreFormService outStoreFormService;
    @PostMapping(value = "/insert",consumes = "application/json",produces = "application/json")
    public @ResponseBody
    String addOutStoreForm(@RequestBody OutStoreForm form){
        int num = outStoreFormService.addOSF(form);
        if(num<0) return returnJson.returnError();
        else return returnJson.returnOK();
    }

    @GetMapping(value = "/delete")
    public @ResponseBody String deleteOutStoreForm(@RequestParam int id){
        int num = outStoreFormService.deleteOSF(id);
        if(num<0) return returnJson.returnError();
        else return returnJson.returnOK();
    }

    @PostMapping(value = "deletebatch",consumes = "application/json",produces = "application/json")
    public @ResponseBody String deleteOutStoreFormBatch(@RequestBody HashMap hashMap){
        List deleteList = (List)hashMap.get("deleteList");
        int num = outStoreFormService.deleteOSFBatch(deleteList);
        if(num<0) return returnJson.returnError();
        else return returnJson.returnOK();
    }

    @PostMapping(value = "update",consumes = "application/json",produces = "application/json")
    public @ResponseBody String updateOutStoreForm(@RequestBody HashMap<String,OutStoreForm> hashMap){
        OutStoreForm form = hashMap.get("form");
        int num = outStoreFormService.updateOSF(form);
        if(num<0) return returnJson.returnError();
        else return returnJson.returnOK();
    }

    @PostMapping(value = "updatebatch",consumes = "application/json",produces = "application/json")
    public @ResponseBody String updateOutStoreFormBatch(@RequestBody HashMap<String,List<OutStoreForm>> hashMap){
        List<OutStoreForm> formlist = hashMap.get("formlist");
        int num = outStoreFormService.updateOSFBatch(formlist);
        if(num<0) return returnJson.returnError();
        else return returnJson.returnOK();
    }
    @GetMapping(value = "/getlist",produces = "application/json")
    public @ResponseBody HashMap getOutStoreFormBatch(@RequestParam int base,@RequestParam int offset){
        HashMap hashMap = (HashMap) outStoreFormService.getBriefOSFBatch(base,offset);
        hashMap.put("sum",outStoreFormService.getCount());
        return hashMap;
    }
    @GetMapping(value = "/detail/get",produces = "application/json")
    public @ResponseBody HashMap getOutStoreFormDetail(@RequestParam int id){
        return (HashMap) outStoreFormService.getOSFDetailById(id);
    }
}
