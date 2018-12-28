package purchasesystem.controller;

import purchasesystem.model.Goods.DetailItem;
import purchasesystem.model.Store.OutStoreForm;
import purchasesystem.service.IoutStoreFormService;
import purchasesystem.util.ReturnJson;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/outstoreform")
public class OutStoreFormController {
    @Resource
    IoutStoreFormService outStoreFormService;
    @PostMapping(value = "/insert",consumes = "application/json",produces = "application/json")
    public @ResponseBody
    String addOutStoreForm(@RequestBody OutStoreForm form){
        long num = outStoreFormService.addOSF(form);
        if(num<0) return ReturnJson.returnError();
        else return ReturnJson.returnOKWithExtraData("formId",num);
    }

    @GetMapping(value = "/delete")
    public @ResponseBody String deleteOutStoreForm(@RequestParam int id){
        int num = outStoreFormService.deleteOSF(id);
        if(num<0) return ReturnJson.returnError();
        else return ReturnJson.returnOK();
    }

    @PostMapping(value = "deletebatch",consumes = "application/json",produces = "application/json")
    public @ResponseBody String deleteOutStoreFormBatch(@RequestBody Map map){
        List deleteList = (List)map.get("deleteList");
        int num = outStoreFormService.deleteOSFBatch(deleteList);
        if(num<0) return ReturnJson.returnError();
        else return ReturnJson.returnOK();
    }

    @PostMapping(value = "update",consumes = "application/json",produces = "application/json")
    public @ResponseBody String updateOutStoreForm(@RequestBody Map<String,OutStoreForm> map){
        OutStoreForm form = map.get("form");
        int num = outStoreFormService.updateOSF(form);
        if(num<0) return ReturnJson.returnError();
        else return ReturnJson.returnOK();
    }

    @PostMapping(value = "updatebatch",consumes = "application/json",produces = "application/json")
    public @ResponseBody String updateOutStoreFormBatch(@RequestBody Map<String,List<OutStoreForm>> map){
        List<OutStoreForm> formlist = map.get("formlist");
        int num = outStoreFormService.updateOSFBatch(formlist);
        if(num<0) return ReturnJson.returnError();
        else return ReturnJson.returnOK();
    }
    @GetMapping(value = "/getlist",produces = "application/json")
    public @ResponseBody Map getOutStoreFormBatch(@RequestParam int base,@RequestParam int offset){
        HashMap hashMap = (HashMap) outStoreFormService.getBriefOSFBatch(base,offset);
        hashMap.put("sum",outStoreFormService.getCount());
        return hashMap;
    }
    @GetMapping(value = "/detail/get",produces = "application/json")
    public @ResponseBody Map getOutStoreFormDetail(@RequestParam int id){
        return outStoreFormService.getOSFDetailById(id);
    }
    @PostMapping(value = "/detail/insert",consumes = "application/json",produces = "application/json")
    public @ResponseBody String insertDetailItem(@RequestBody Map map){
        int formid = (int)map.get("formId");
        List<DetailItem> detailItems = (List<DetailItem>)map.get("detailList");
        int num = outStoreFormService.addOSFDetailItem(formid,detailItems);
        if(num<0) return ReturnJson.returnError();
        else return ReturnJson.returnOK();
    }
    @PostMapping(value = "/detail/delete",consumes = "application/json",produces = "application/json")
    public @ResponseBody String deleteDetailItem(@RequestBody Map map){
        List<Integer> detailItems = (List<Integer>)map.get("deleteList");
        int num = outStoreFormService.deleteOSFDetailItem(detailItems);
        if(num<0) return ReturnJson.returnError();
        else return ReturnJson.returnOK();
    }
}
