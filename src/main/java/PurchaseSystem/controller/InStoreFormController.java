package PurchaseSystem.controller;

import PurchaseSystem.model.Store.InStoreForm;
import PurchaseSystem.service.IinStoreFormService;
import PurchaseSystem.util.returnJson;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping("/instoreform")
public class InStoreFormController {
    @Resource
    IinStoreFormService inStoreFormService;
    @PostMapping(value = "/insert",consumes = "application/json",produces = "application/json")
    public @ResponseBody
    String addInStoreForm(@RequestBody InStoreForm form){
        int num = inStoreFormService.addISF(form);
        if(num<0) return returnJson.returnError();
        else return returnJson.returnOK();
    }

    @GetMapping(value = "/delete")
    public @ResponseBody String deleteInStoreForm(@RequestParam int id){
        int num = inStoreFormService.deleteISF(id);
        if(num<0) return returnJson.returnError();
        else return returnJson.returnOK();
    }

    @PostMapping(value = "deletebatch",consumes = "application/json",produces = "application/json")
    public @ResponseBody String deleteInStoreFormBatch(@RequestBody HashMap hashMap){
        List deleteList = (List)hashMap.get("deleteList");
        int num = inStoreFormService.deleteISFBatch(deleteList);
        if(num<0) return returnJson.returnError();
        else return returnJson.returnOK();
    }

    @PostMapping(value = "update",consumes = "application/json",produces = "application/json")
    public @ResponseBody String updateInStoreForm(@RequestBody HashMap<String,InStoreForm> hashMap){
        InStoreForm form = hashMap.get("form");
        int num = inStoreFormService.updateISF(form);
        if(num<0) return returnJson.returnError();
        else return returnJson.returnOK();
    }

    @PostMapping(value = "updatebatch",consumes = "application/json",produces = "application/json")
    public @ResponseBody String updateInStoreFormBatch(@RequestBody HashMap<String,List<InStoreForm>> hashMap){
        List<InStoreForm> formlist = hashMap.get("formlist");
        int num = inStoreFormService.updateISFBatch(formlist);
        if(num<0) return returnJson.returnError();
        else return returnJson.returnOK();
    }
    @GetMapping(value = "/getlist",produces = "application/json")
    public @ResponseBody HashMap getInStoreFormBatch(@RequestParam int base,@RequestParam int offset){
        HashMap hashMap = (HashMap) inStoreFormService.getBriefISFBatch(base,offset);
        hashMap.put("sum",inStoreFormService.getCount());
        return hashMap;
    }
    @GetMapping(value = "/detail/get",produces = "application/json")
    public @ResponseBody HashMap getInStoreFormDetail(@RequestParam int id){
        return (HashMap) inStoreFormService.getISFDetailById(id);
    }
}
