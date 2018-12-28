package purchasesystem.controller;

import purchasesystem.model.form.NeedPlanForm;
import purchasesystem.model.goods.DetailItem;
import purchasesystem.service.IneedPlanFormService;
import purchasesystem.util.ReturnJson;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/needplanform")
public class NeedPlanFormController {
    @Resource
    IneedPlanFormService needPlanFormService;
    @PostMapping(value = "/insert",consumes = "application/json",produces = "application/json")
    public @ResponseBody String addNeedPlanForm(@RequestBody NeedPlanForm form){
        long num = needPlanFormService.addNPF(form);
        if(num<0) return ReturnJson.returnError();
        else return ReturnJson.returnOKWithExtraData("formId",num);//返回刚刚添加的表的id
    }

    @GetMapping(value = "/delete")
    public @ResponseBody String deleteNeedPlanForm(@RequestParam int id){
        int num = needPlanFormService.deleteNPF(id);
        if(num<0) return ReturnJson.returnError();
        else return ReturnJson.returnOK();
    }

    @PostMapping(value = "deletebatch",consumes = "application/json",produces = "application/json")
    public @ResponseBody String deleteNeedPlanFormBatch(@RequestBody Map map){
        List deleteList = (List)map.get("deleteList");
        int num = needPlanFormService.deleteNPFBatch(deleteList);
        if(num<0) return ReturnJson.returnError();
        else return ReturnJson.returnOK();
    }

    @PostMapping(value = "update",consumes = "application/json",produces = "application/json")
    public @ResponseBody String updateNeedPlanForm(@RequestBody Map<String,NeedPlanForm> map){
        NeedPlanForm npf = map.get("form");
        int num = needPlanFormService.updateNPF(npf);
        if(num<0) return ReturnJson.returnError();
        else return ReturnJson.returnOK();
    }

    @PostMapping(value = "updatebatch",consumes = "application/json",produces = "application/json")
    public @ResponseBody String updateNeedPlanFormBatch(@RequestBody Map<String,List<NeedPlanForm>> map){
        List<NeedPlanForm> formlist = map.get("formlist");
        int num = needPlanFormService.updateNPFBatch(formlist);
        if(num<0) return ReturnJson.returnError();
        else return ReturnJson.returnOK();
    }
    @GetMapping(value = "/getlist",produces = "application/json")
    public @ResponseBody Map getNeedPlanFormBatch(@RequestParam int base,@RequestParam int offset){
        HashMap hashMap = (HashMap) needPlanFormService.getBriefNPFBatch(base,offset);
        hashMap.put("sum",needPlanFormService.getCount());
        return hashMap;
    }
    @GetMapping(value = "/detail/get",produces = "application/json")
    public @ResponseBody Map getNeedPlanFormDetail(@RequestParam int id){
        return needPlanFormService.getNPFDetailById(id);
    }
    @PostMapping(value = "/detail/insert",consumes = "application/json",produces = "application/json")
    public @ResponseBody String insertDetailItem(@RequestBody Map map){
        int formid = (int)map.get("formId");
        List<DetailItem> detailItems = (List<DetailItem>)map.get("detailList");
        int num = needPlanFormService.addNPFDetailItem(formid,detailItems);
        if(num<0) return ReturnJson.returnError();
        else return ReturnJson.returnOK();
    }
    @PostMapping(value = "/detail/delete",consumes = "application/json",produces = "application/json")
    public @ResponseBody String deleteDetailItem(@RequestBody Map map){
        List<Integer> detailItems = (List<Integer>)map.get("deleteList");
        int num = needPlanFormService.deleteNPFDetailItem(detailItems);
        if(num<0) return ReturnJson.returnError();
        else return ReturnJson.returnOK();
    }
}
