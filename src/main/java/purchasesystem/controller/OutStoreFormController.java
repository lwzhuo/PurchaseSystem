package purchasesystem.controller;

import purchasesystem.model.Goods.DetailItem;
import purchasesystem.model.Store.OutStoreForm;
import purchasesystem.service.IoutStoreFormService;
import purchasesystem.util.returnJson;
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
        long num = outStoreFormService.addOSF(form);
        if(num<0) return returnJson.returnError();
        else return returnJson.returnOKWithExtraData("formId",num);
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
    @PostMapping(value = "/detail/insert",consumes = "application/json",produces = "application/json")
    public @ResponseBody String insertDetailItem(@RequestBody HashMap hashMap){
        int formid = (int)hashMap.get("formId");
        List<DetailItem> detailItems = (List<DetailItem>)hashMap.get("detailList");
        int num = outStoreFormService.addOSFDetailItem(formid,detailItems);
        if(num<0) return returnJson.returnError();
        else return returnJson.returnOK();
    }
    @PostMapping(value = "/detail/delete",consumes = "application/json",produces = "application/json")
    public @ResponseBody String deleteDetailItem(@RequestBody HashMap hashMap){
        List<Integer> detailItems = (List<Integer>)hashMap.get("deleteList");
        int num = outStoreFormService.deleteOSFDetailItem(detailItems);
        if(num<0) return returnJson.returnError();
        else return returnJson.returnOK();
    }
}
