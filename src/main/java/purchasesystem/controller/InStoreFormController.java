package purchasesystem.controller;

import purchasesystem.model.goods.DetailItem;
import purchasesystem.model.store.InStoreForm;
import purchasesystem.service.IinStoreFormService;
import purchasesystem.util.ReturnJson;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/instoreform")
public class InStoreFormController {
    @Resource
    IinStoreFormService inStoreFormService;
    @PostMapping(value = "/insert",consumes = "application/json",produces = "application/json")
    public @ResponseBody
    String addInStoreForm(@RequestBody InStoreForm form){
        long num = inStoreFormService.addISF(form);
        if(num<0) return ReturnJson.returnError();
        else return ReturnJson.returnOKWithExtraData("formId",num);
    }

    @GetMapping(value = "/delete")
    public @ResponseBody String deleteInStoreForm(@RequestParam int id){
        int num = inStoreFormService.deleteISF(id);
        if(num<0) return ReturnJson.returnError();
        else return ReturnJson.returnOK();
    }

    @PostMapping(value = "deletebatch",consumes = "application/json",produces = "application/json")
    public @ResponseBody String deleteInStoreFormBatch(@RequestBody Map map){
        List deleteList = (List)map.get("deleteList");
        int num = inStoreFormService.deleteISFBatch(deleteList);
        if(num<0) return ReturnJson.returnError();
        else return ReturnJson.returnOK();
    }

    @PostMapping(value = "update",consumes = "application/json",produces = "application/json")
    public @ResponseBody String updateInStoreForm(@RequestBody Map<String,InStoreForm> map){
        InStoreForm form = map.get("form");
        int num = inStoreFormService.updateISF(form);
        if(num<0) return ReturnJson.returnError();
        else return ReturnJson.returnOK();
    }

    @PostMapping(value = "updatebatch",consumes = "application/json",produces = "application/json")
    public @ResponseBody String updateInStoreFormBatch(@RequestBody Map<String,List<InStoreForm>> map){
        List<InStoreForm> formlist = map.get("formlist");
        int num = inStoreFormService.updateISFBatch(formlist);
        if(num<0) return ReturnJson.returnError();
        else return ReturnJson.returnOK();
    }
    @GetMapping(value = "/getlist",produces = "application/json")
    public @ResponseBody Map getInStoreFormBatch(@RequestParam int base,@RequestParam int offset){
        HashMap hashMap = (HashMap) inStoreFormService.getBriefISFBatch(base,offset);
        hashMap.put("sum",inStoreFormService.getCount());
        return hashMap;
    }
    @GetMapping(value = "/detail/get",produces = "application/json")
    public @ResponseBody Map getInStoreFormDetail(@RequestParam int id){
        return inStoreFormService.getISFDetailById(id);
    }

    @PostMapping(value = "/detail/insert",consumes = "application/json",produces = "application/json")
    public @ResponseBody String insertDetailItem(@RequestBody Map map){
        int formid = (int)map.get("formId");
        List<DetailItem> detailItems = (List<DetailItem>)map.get("detailList");
        int num = inStoreFormService.addISFDetailItem(formid,detailItems);
        if(num<0) return ReturnJson.returnError();
        else return ReturnJson.returnOK();
    }
    @PostMapping(value = "/detail/delete",consumes = "application/json",produces = "application/json")
    public @ResponseBody String deleteDetailItem(@RequestBody Map map){
        int formid = (int)map.get("formId");
        List<Integer> detailItems = (List<Integer>)map.get("deleteList");
        int num = inStoreFormService.deleteISFDetailItem(detailItems);
        if(num<0) return ReturnJson.returnError();
        else return ReturnJson.returnOK();
    }
}
